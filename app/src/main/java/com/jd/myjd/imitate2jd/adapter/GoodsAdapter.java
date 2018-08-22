package com.jd.myjd.imitate2jd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.bean.ProductsBean;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.TextHolder>{
    private Context context;
    private List<ProductsBean.DataBean> dataBeans;

    public GoodsAdapter(Context context, List<ProductsBean.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_goods_layout, parent, false);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {
        String title = dataBeans.get(position).getTitle();
        String image = dataBeans.get(position).getImages().split("\\|")[0];
        String subhead = dataBeans.get(position).getSubhead();
        String price = dataBeans.get(position).getPrice();
        holder.bindText(title,image,subhead,price);

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class TextHolder extends RecyclerView.ViewHolder{


        public TextView good_text_price;
        public TextView good_text_sunband;
        public TextView good_text_title;
        public SimpleDraweeView good_simple_view;

        public TextHolder(View itemView) {
            super(itemView);
            good_simple_view = itemView.findViewById(R.id.goods_Simple_view);
            good_text_title = itemView.findViewById(R.id.good_text_title);
            good_text_price = itemView.findViewById(R.id.good_text_price);
            good_text_sunband = itemView.findViewById(R.id.goods_text_subhead);
        }

        public void bindText(String title, String image, String subhead,String price) {
            good_simple_view.setImageURI(image);
            good_text_price.setText(price);
            good_text_title.setText(title);
            good_text_sunband.setText(subhead);
        }
    }
}
