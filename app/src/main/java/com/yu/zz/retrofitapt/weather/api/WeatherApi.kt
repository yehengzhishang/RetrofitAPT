package com.yu.zz.retrofitapt.weather.api

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.*
import okhttp3.internal.http.promisesBody
import okhttp3.internal.platform.Platform

import okio.Buffer
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.EOFException
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.UnsupportedCharsetException
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class WeatherApi {
    //okHttp 拦截器
    companion object {
        private val mInterceptor = object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                return chain.proceed(chain.request().newBuilder()
                        .addHeader("Authorization", "APPCODE e2147361ac1343fbb9096e7ca8481612")
                        .build())
            }
        }
        private val mInterceptorLog = LogInterceptor()
        private val mOkHttpClient = OkHttpClient.Builder()
                .addInterceptor(mInterceptor)
                .addInterceptor(mInterceptorLog)
                .build()
        val retrofit: Retrofit = Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://iweather.market.alicloudapi.com/")
                .build()
    }
}

class LogInterceptor @JvmOverloads constructor(private val logger: Logger = object : Logger {
    override fun log(message: String) {
        Platform.get().log(Platform.WARN, message, null)
    }
}) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val id = ID_GENERATOR.incrementAndGet()
        run {
            val LOG_PREFIX = "[$id request]"
            val requestBody = request.body
            val hasRequestBody = requestBody != null

            val connection = chain.connection()
            val protocol = connection?.protocol() ?: Protocol.HTTP_1_1
            val requestStartMessage = "--> " + request.method + ' '.toString() + request.url + ' '.toString() + protocol
            logger.log(LOG_PREFIX + requestStartMessage)

            if (hasRequestBody) {
                // Request body headers are only present when installed as a network interceptor. Force
                // them to be included (when available) so there values are known.
                if (requestBody!!.contentType() != null) {
                    logger.log(LOG_PREFIX + "Content-Type: " + requestBody.contentType())
                }
                if (requestBody.contentLength() != -1L) {
                    logger.log(LOG_PREFIX + "Content-Length: " + requestBody.contentLength())
                }
            }

            val headers = request.headers
            var i = 0
            val count = headers.size
            while (i < count) {
                val name = headers.name(i)
                // Skip headers from the request body as they are explicitly logged above.
                if (!"Content-Type".equals(name, ignoreCase = true) && !"Content-Length".equals(name, ignoreCase = true)) {
                    logger.log(LOG_PREFIX + name + ": " + headers.value(i))
                }
                i++
            }

            if (!hasRequestBody) {
                logger.log(LOG_PREFIX + "--> END " + request.method)
            } else if (bodyEncoded(request.headers)) {
                logger.log(LOG_PREFIX + "--> END " + request.method + " (encoded body omitted)")
            } else {
                val buffer = Buffer()
                requestBody!!.writeTo(buffer)

                var charset: Charset? = UTF8
                val contentType = requestBody.contentType()
                if (contentType != null) {
                    charset = contentType.charset(UTF8)
                }

                if (isPlaintext(buffer)) {
                    val bufferString = buffer.readString(charset!!)
                    logger.log(LOG_PREFIX + bufferString)
                    if (contentType != null && "json" == contentType.subtype) {
                        logger.log(LOG_PREFIX + "\n" + JSONFormatter.formatJSON(bufferString))
                    }
                    logger.log(LOG_PREFIX + "--> END " + request.method
                            + " (" + requestBody.contentLength() + "-byte body)")
                } else {
                    logger.log(LOG_PREFIX + "--> END " + request.method + " (binary "
                            + requestBody.contentLength() + "-byte body omitted)")
                }
            }
        }

        run {
            val LOG_PREFIX = "[$id response]"
            val startNs = System.nanoTime()
            val response: Response
            try {
                response = chain.proceed(request)
            } catch (e: Exception) {
                logger.log("$LOG_PREFIX<-- HTTP FAILED: $e")
                throw e
            }

            val tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs)

            val responseBody = response.body
            val contentLength = responseBody!!.contentLength()
            logger.log(LOG_PREFIX + "<-- " + response.code + ' '.toString() + response.message + ' '.toString() + response.request.url + " (" + tookMs + "ms" + "" + ')'.toString())

            val headers = response.headers
            var i = 0
            val count = headers.size
            while (i < count) {
                logger.log(LOG_PREFIX + headers.name(i) + ": " + headers.value(i))
                i++
            }

            if (!response.promisesBody()) {
                logger.log("$LOG_PREFIX<-- END HTTP")
            } else if (bodyEncoded(response.headers)) {
                logger.log("$LOG_PREFIX<-- END HTTP (encoded body omitted)")
            } else {
                val source = responseBody.source()
                source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
                val buffer = source.buffer()

                var charset: Charset? = UTF8
                val contentType = responseBody.contentType()
                if (contentType != null) {
                    try {
                        charset = contentType.charset(UTF8)
                    } catch (e: UnsupportedCharsetException) {
                        logger.log(LOG_PREFIX + "")
                        logger.log(LOG_PREFIX + "Couldn't decode the response body; charset is likely malformed.")
                        logger.log("$LOG_PREFIX<-- END HTTP")
                        return response
                    }

                }

                if (!isPlaintext(buffer)) {
                    logger.log(LOG_PREFIX + "<-- END HTTP (binary " + buffer.size + "-byte body omitted)")
                    return response
                }

                if (contentLength != 0L) {
                    val bufferString = buffer.clone().readString(charset!!)
                    logger.log(LOG_PREFIX + bufferString)
                    if (contentType != null && "json" == contentType.subtype) {
                        logger.log(LOG_PREFIX + "\n" + JSONFormatter.formatJSON(bufferString))
                    }
                }

                logger.log(LOG_PREFIX + "<-- END HTTP (" + buffer.size + "-byte body)")
            }
            return response
        }
    }

    private fun bodyEncoded(headers: Headers): Boolean {
        val contentEncoding = headers["Content-Encoding"]
        return contentEncoding != null && !contentEncoding.equals("identity", ignoreCase = true)
    }

    interface Logger {
        fun log(message: String)
    }

    companion object {

        private val UTF8 = Charset.forName("UTF-8")
        private val ID_GENERATOR = AtomicInteger(0)

        internal fun isPlaintext(buffer: Buffer): Boolean {
            try {
                val prefix = Buffer()
                val byteCount = if (buffer.size < 64) buffer.size else 64
                buffer.copyTo(prefix, 0, byteCount)
                for (i in 0..15) {
                    if (prefix.exhausted()) {
                        break
                    }
                    val codePoint = prefix.readUtf8CodePoint()
                    if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                        return false
                    }
                }
                return true
            } catch (e: EOFException) {
                return false // Truncated UTF-8 sequence.
            }

        }
    }
}

open class JSONFormatter {

    internal open fun format(source: String): String {
        return ""
    }

    companion object {

        internal val FORMATTER = findJSONFormatter()

        fun formatJSON(source: String): String {
            try {
                return FORMATTER.format(source)
            } catch (e: Exception) {
                return ""
            }

        }

        private fun findJSONFormatter(): JSONFormatter {
            val gsonFormatter = GsonFormatter.buildIfSupported()
            return if (gsonFormatter != null) {
                gsonFormatter
            } else JSONFormatter()

        }
    }
}

internal class GsonFormatter : JSONFormatter() {
    private val GSON = GsonBuilder().setPrettyPrinting().create()
    private val PARSER = JsonParser()

    override fun format(source: String): String {
        return GSON.toJson(PARSER.parse(source))
    }

    companion object {

        fun buildIfSupported(): JSONFormatter? {
            try {
                Class.forName("com.google.gson.Gson")
                return GsonFormatter()
            } catch (ignore: ClassNotFoundException) {
                return null
            }

        }
    }

}