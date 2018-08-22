package com.jd.myjd.imitate2jd.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.bean.AdvertisingBean;
import com.jd.myjd.imitate2jd.ui.activity.ClassXqPageActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class homeFg_itemliuhsi_Adapter extends RecyclerView.Adapter {

    private Context context;
    private List<AdvertisingBean.MiaoshaBean.ListBeanX> list;

    public homeFg_itemliuhsi_Adapter(Context context, List<AdvertisingBean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
   @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fg_liu_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).indexLiuBargainPrice.setText(list.get(position).getBargainPrice());
            ((ViewHolder) holder).indexLiuPrice.setText(list.get(position).getPrice());
            ((ViewHolder) holder).indexLiuPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            Glide.with(context).load(list.get(position).getImages().split("\\|")[0]).into(((ViewHolder) holder).indexLiuImg);
            ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().postSticky(list.get(position).getPscid());
                    Intent intent = new Intent(context, ClassXqPageActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.index_liu_img)
        ImageView indexLiuImg;
        @BindView(R.id.index_liu_bargainPrice)
        TextView indexLiuBargainPrice;
        @BindView(R.id.index_liu_price)
        TextView indexLiuPrice;
        View view;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;
        }
    }
}
