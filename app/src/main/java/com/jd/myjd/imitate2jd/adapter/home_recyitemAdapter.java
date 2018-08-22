package com.jd.myjd.imitate2jd.adapter;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class home_recyitemAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<AdvertisingBean.TuijianBean.ListBean> list;
    private View view;

    public home_recyitemAdapter(Context context, List<AdvertisingBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.fg_recy_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof home_recyitemAdapter.ViewHolder) {
            ((ViewHolder) holder).gfRecyItemTitle.setText(list.get(position).getTitle());
            ((ViewHolder) holder).gfRecyItemPrice.setText(list.get(position).getPrice());
            Glide.with(context).load(list.get(position).getImages().split("\\|")[0]).into(((ViewHolder) holder).gfRecyItemImg);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ClassXqPageActivity.class);
                   // intent.putExtra("pid",);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gf_recy_item_img)
        ImageView gfRecyItemImg;
        @BindView(R.id.gf_recy_item_title)
        TextView gfRecyItemTitle;
        @BindView(R.id.gf_recy_item_price)
        TextView gfRecyItemPrice;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
