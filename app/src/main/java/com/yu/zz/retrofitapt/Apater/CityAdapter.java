package com.yu.zz.retrofitapt.Apater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yu.zz.retrofitapt.Bean.CityBean;
import com.yu.zz.retrofitapt.R;

import java.util.ArrayList;

/**
 * 数据适配（不是本次重点，基本没有写注释）
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.Holder> {

    private ArrayList<CityBean> list;
    private LayoutInflater inflater;

    public CityAdapter(Context context, ArrayList<CityBean> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CityAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_city, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tv_cityName.setText(list.get(position).getCity());
    }


    @Override
    public int getItemCount() {
        return null == list ? 0 : list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView tv_cityName;

        Holder(View itemView) {
            super(itemView);
            tv_cityName = itemView.findViewById(R.id.tv_cityName);
        }
    }
}
