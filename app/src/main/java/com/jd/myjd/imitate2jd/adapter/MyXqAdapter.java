package com.jd.myjd.imitate2jd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.bean.ClassXqBean;
import com.jd.myjd.imitate2jd.ui.activity.ClassXqPageActivity;

import java.util.List;

public class MyXqAdapter extends RecyclerView.Adapter<MyXqAdapter.TextHolder>{
    private Context context;
    private List<ClassXqBean.DataBean> dataBeans;
    private View view;

    public MyXqAdapter(Context context, List<ClassXqBean.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
         view = inflater.inflate(R.layout.class_item_layout, parent, false);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {
        String title = dataBeans.get(position).getTitle();
        String images = dataBeans.get(position).getImages().split("\\|")[0];
        String price = dataBeans.get(position).getPrice();
        holder.bindText(title,images,price);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClassXqPageActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{

        public TextView class_text_price;
        public SimpleDraweeView simple_draw_view;
        public TextView class_text_view;

        public TextHolder(View itemView) {
            super(itemView);
            class_text_view = itemView.findViewById(R.id.class_text_view);
            simple_draw_view = itemView.findViewById(R.id.simple_draw_view);
            class_text_price = itemView.findViewById(R.id.class_text_price);
        }

        public void bindText(String title,String images,String price) {
            class_text_view.setText(title);
            simple_draw_view.setImageURI(images);
            class_text_price.setText(price);
        }
    }
}
