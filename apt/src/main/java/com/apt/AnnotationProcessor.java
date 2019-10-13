package com.apt;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.zz.yu.lib.ApiFactory;
import com.zz.yu.lib.ConverterInstance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.util.ElementFilter;

import static com.squareup.javapoet.TypeSpec.classBuilder;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

/**
 * 生成代码的主要逻辑
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)//java版本支持
@SupportedAnnotationTypes({
        "com.zz.yu.lib.ApiFactory",
        "com.zz.yu.lib.ConverterInstance"
})
public final class AnnotationProcessor extends AbstractProcessor {
    private Filer mFiler; //文件相关的辅助类

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        mFiler = processingEnv.getFiler();
        onApi(roundEnv);
        onConverter(roundEnv);
        return true;
    }


    /*------------------step 6.3 始-------------------*/

    /**
     * 生成MyApiFactory
     */
    private void onApi(RoundEnvironment roundEnv) {
        //类名
        String className = "MyApiFactory";
        //类设定  public final class MyApiFactory
        TypeSpec.Builder tb = classBuilder(className)
                .addModifiers(PUBLIC, FINAL)
                .addJavadoc("by apt");
        /*生成内部方法 */
        //项目的所有用的 ApiFactory的 元素 循环
        for (TypeElement element : ElementFilter.typesIn(roundEnv.getElementsAnnotatedWith(ApiFactory.class))) {
            //找到元素的所有方法
            for (Element e : element.getEnclosedElements()) {
                ExecutableElement executableElement = (ExecutableElement) e;
                //方法设定
                MethodSpec.Builder methodBuilder =
                        MethodSpec.methodBuilder(e.getSimpleName().toString())
                                .addJavadoc("by apt ")
                                .addModifiers(PUBLIC, STATIC);
                //方法返回值设定 与原返回值一致
                methodBuilder.returns(TypeName.get(executableElement.getReturnType()));
                //方法参数设定
                StringBuilder paramsString = new StringBuilder();
                for (VariableElement ep : executableElement.getParameters()) {
                    methodBuilder.addParameter(TypeName.get(ep.asType()), ep.getSimpleName().toString());
                    paramsString.append(ep.getSimpleName().toString()).append(",");
                }
                if (paramsString.length() == 0) {
                    methodBuilder.addStatement("return $T.getInstance()" +
                                    ".weatherService.$L()"
                            , ClassName.get("com.yu.zz.retrofitapt.API", "Api")
                            , e.getSimpleName().toString());
                } else {
                    methodBuilder.addStatement(
                            "return $T.getInstance()" +
                                    ".weatherService.$L($L)"
                            , ClassName.get("com.yu.zz.retrofitapt.API", "Api")
                            , e.getSimpleName().toString()
                            , paramsString.substring(0, paramsString.length() - 1));
                }
                //这句话，简单的说，类加入这个方法
                tb.addMethod(methodBuilder.build());
            }
        }

        JavaFile javaFile = JavaFile.builder("com.apt", tb.build()).build();// 生成源代码
        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e1) {
//            e1.printStackTrace();
        }
    }

    /*------------------step 6.3 终-------------------*/
    /*------------------step 7.2 始-------------------*/
    private void onConverter(RoundEnvironment roundEnv) {
        //类名
        String className = "NewConverter";
        //类设定  public final class NewConverter
        TypeSpec.Builder tb = classBuilder(className)
                .addModifiers(PUBLIC, FINAL)
                .addJavadoc("by Apt,用来返回一些特别的Converter 生成代码见apt 中的AnnotationProcessor nnConverter() \n")
                .addJavadoc("为什么不用@link...因为用了也不管用 \n");
        //方法设定 public static AbstractConverter create(Class mClass)
        MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("create")
                .addJavadoc("by apt \n")
                .returns(ClassName.get("com.yu.zz.retrofitapt.Retrofit", "AbstractConverter"))
                .addModifiers(PUBLIC, STATIC)
                .addParameter(Class.class, "mClass");

        //switch 语句
        CodeBlock.Builder blockBuilder = CodeBlock.builder();
        //括号开始
        blockBuilder.beginControlFlow(" switch (mClass.getSimpleName())");
        ArrayList<ClassName> names = new ArrayList<>();
        for (Element element : roundEnv.getElementsAnnotatedWith(ConverterInstance.class)) {
            ClassName targetClassNmae = null;
            try {
                Class currentType = element.getAnnotation(ConverterInstance.class).value();
                targetClassNmae = ClassName.get(currentType);
            } catch (MirroredTypeException mte) {
                DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
                TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
                targetClassNmae = ClassName.get(classTypeElement);
            }
            //Case 语句：case 所列举的不能有重复，加入一层list的判断:
            if (!names.contains(targetClassNmae)) {
                names.add(targetClassNmae);
                blockBuilder.addStatement("case $S:  \n return  new $T()", targetClassNmae.simpleName(), targetClassNmae);
            }
        }
        //switch default语句，返回默认的Converter
        blockBuilder.add("default: \n return new $T();\n", ClassName.get("com.yu.zz.retrofitapt.Retrofit", "DefualtConverter"));
        //括号线束
        blockBuilder.endControlFlow();
        //方法中加入代码
        methodBuilder.addCode(blockBuilder.build());
        //类中加入方法
        tb.addMethod(methodBuilder.build());
        // 生成源代码
        JavaFile javaFile = JavaFile.builder("com.apt", tb.build()).build();
        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e1) {
//            e1.printStackTrace();
        }
    }

    /*------------------step 7.3 终-------------------*/
}
