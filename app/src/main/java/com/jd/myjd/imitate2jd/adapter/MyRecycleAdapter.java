package com.jd.myjd.imitate2jd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.bean.Mybean;

import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.TextHolder>{
    private Context context;
    private List<Mybean> list;

    public MyRecycleAdapter(Context context, List<Mybean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_item, parent, false);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {
        Integer image = list.get(position).getImage();
        String name = list.get(position).getName();
        holder.bindText(image,name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{

        public TextView text_view;
        public ImageView image_view;

        public TextHolder(View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image_view);
            text_view = itemView.findViewById(R.id.text_view);
        }

        public void bindText(Integer image, String name) {
            image_view.setImageResource(image);
            text_view.setText(name);
        }
    }
}
