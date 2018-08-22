package com.jd.myjd.imitate2jd.ui.activity;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.adapter.ImageAdapter;
import com.jd.myjd.imitate2jd.bean.AddCart;
import com.jd.myjd.imitate2jd.bean.ProductBean;
import com.jd.myjd.imitate2jd.mvp.presenter.AddCartPresenter;
import com.jd.myjd.imitate2jd.mvp.view.IAddCartView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClassXqPageActivity extends Activity implements IAddCartView {

    private TextView text_title;
    private TextView text_price;
    private TextView text_bargainPrice;
    private ViewPager viewPager;
    private Button btnjiaru;
    private List<ProductBean.DataBean> list;
    private ImageAdapter imageAdapter;
    private LinearLayout linearLayout;
    private List<ImageView> listshape;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    int currentItem = viewPager.getCurrentItem();
                    viewPager.setCurrentItem(currentItem+1);
                    handler.sendEmptyMessageDelayed(0,2000);
                    break;
            }
        }
    };
    private AddCartPresenter addCartPresenter;
    private int pid=2;
    private int uid=16886;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_xq_page);
        text_title = (TextView) findViewById(R.id.text_title);
        text_price = (TextView) findViewById(R.id.text_price);
        text_bargainPrice = (TextView) findViewById(R.id.text_bargainPrice);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        btnjiaru = (Button) findViewById(R.id.jiaruBtn);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        text_price.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        text_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线（删除线）
         text_price.getPaint().setAntiAlias(true);// 抗锯齿
        getData();
        //presenter
        addCartPresenter = new AddCartPresenter(this);
        //加入购物车
        btnjiaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* addCartPresenter.addCart("1",pid);*/
                addCartPresenter.addCart(uid,pid);
               Toast.makeText(ClassXqPageActivity.this,"加入成功",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.zhaoapi.cn/product/getProductDetail?pid=1")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override

            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //成功的返回 string只能使用一次
                // System.out.println("lalal:"+response.body().string());
                String json = response.body().string();
                Gson gson = new Gson();
                ProductBean productBean = gson.fromJson(json, ProductBean.class);
                if(list==null){
                    list = new ArrayList<>();
                }
                list.add(productBean.getData());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //设置控件显示
                        text_title.setText(list.get(0).getTitle());
                        text_price.setText("原价:"+ list.get(0).getPrice()+"");
                        text_bargainPrice.setText("优惠价:"+ list.get(0).getBargainPrice()+"");

                        initshape();
                        viewPager.setCurrentItem(100000);
                        setAdapter();
                        handler.sendEmptyMessageDelayed(0,2000);
                        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                                for (int i =0;i<listshape.size();i++){
                                    if(i==position%listshape.size()){
                                        listshape.get(i).setImageResource(R.drawable.shape02);
                                    }else{
                                        listshape.get(i).setImageResource(R.drawable.shape01);
                                    }
                                }
                            }

                            @Override
                            public void onPageSelected(int position) {

                            }

                            @Override

                            public void onPageScrollStateChanged(int state) {
                            }
                        });
                    }
                });
            }
        });
    }
    public void setAdapter(){

        if(imageAdapter==null) {

            imageAdapter = new ImageAdapter(ClassXqPageActivity.this, list);

            viewPager.setAdapter(imageAdapter);

        }else{

            imageAdapter.notifyDataSetChanged();

        }



    }
    //初始化小圆点的方法
    private void initshape(){
        //创建装着小圆点的集合
        listshape = new ArrayList<>();
        //清空布局和集合
        linearLayout.removeAllViews();
        listshape.clear();
        for (int i=0;i<3;i++){
            ImageView imageView = new ImageView(ClassXqPageActivity.this);
            if(i==0){
                //如果当前是第一页,就设置选中的图片
                imageView.setImageResource(R.drawable.shape02);
            }else{
                imageView.setImageResource(R.drawable.shape01);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(9,0,9,0);
            //添加到集合和布局里
            listshape.add(imageView);
            linearLayout.addView(imageView,layoutParams);
        }
    }

    @Override
    public void onResponse(AddCart addCart) {
        Log.e("TAG","成功");
        Toast.makeText(ClassXqPageActivity.this, addCart.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String error) {
        Log.e("TAG", "失败"+error.toString());
    }
   /* @OnClick(R.id.jiaruBtn)
    public void onViewClicked() {
        addCartPresenter.addCart("1",pid);
        Intent intent = new Intent(ClassXqPageActivity.this, CartsActivity.class);
        intent.putExtra("pid",pid);
        startActivity(intent);
    }*/
}
