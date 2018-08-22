package com.jd.myjd.imitate2jd.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jd.myjd.imitate2jd.R;

//自定义加减器
public class MyAddSubView extends LinearLayout implements View.OnClickListener {
    private TextView add_tv;
    private TextView product_number_tv;
    private TextView sub_tv;
    private int num=1;

    public MyAddSubView(Context context) {
        this(context, null);
    }
    public MyAddSubView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = inflate(context, R.layout.add_remove_view_layout, this);
        sub_tv = view.findViewById(R.id.sub_tv);
        product_number_tv = view.findViewById(R.id.product_number_tv);
        add_tv = view.findViewById(R.id.add_tv);
        sub_tv.setOnClickListener(this);
        add_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sub_tv:
                if (num > 1) {
                    --num;
                    product_number_tv.setText(num + "");
                    if (onNumChangerListener != null) {
                        onNumChangerListener.onNumChange(num);
                    } else {
                        Toast.makeText(getContext(), "商品数量不能小于1", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.add_tv:
                ++num;
                product_number_tv.setText(num + "");
                if (onNumChangerListener != null) {
                    onNumChangerListener.onNumChange(num);
                }
                break;
        }
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        product_number_tv.setText(num + "");
    }
    private OnNumChangerListener onNumChangerListener;
    public void setOnNumChangerListener(OnNumChangerListener onNumChangerListener) {
        this.onNumChangerListener = onNumChangerListener;
    }
    public interface OnNumChangerListener {
        void onNumChange(int number);
    }
}
