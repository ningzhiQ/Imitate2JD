package com.jd.myjd.imitate2jd.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.adapter.GoodsAdapter;
import com.jd.myjd.imitate2jd.bean.ProductsBean;
import com.jd.myjd.imitate2jd.mvp.presenter.ProductsPresenterImpl;
import com.jd.myjd.imitate2jd.mvp.view.ProductsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsActivity extends Activity implements ProductsView, View.OnClickListener {

    @BindView(R.id.Products_recy)
    RecyclerView ProductsRecy;
    @BindView(R.id.Products_img)
    ImageView ProductsImg;
    private ProductsPresenterImpl presenter;
    private String keywords="手机";
    private int page=1;
    private boolean b=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ButterKnife.bind(this);
        Fresco.initialize(this);
        ProductsRecy.setLayoutManager(new LinearLayoutManager(GoodsActivity.this,LinearLayoutManager.VERTICAL,false));
        presenter = new ProductsPresenterImpl(this);
        presenter.getdata(keywords,page);
        ProductsImg.setOnClickListener(this);
    }

    @Override
    public void SuccessCallback(ProductsBean vbean) {
        final List<ProductsBean.DataBean> data = vbean.getData();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GoodsAdapter goodsAdapter = new GoodsAdapter(GoodsActivity.this, data);
                ProductsRecy.setAdapter(goodsAdapter);
            }
        });
    }

    @Override
    public void FailerCallback(int code) {

    }

    @Override
    public void onClick(View v) {
        if (b == false) {
            ProductsRecy.setLayoutManager(new LinearLayoutManager(GoodsActivity.this, LinearLayoutManager.VERTICAL, false));
            b = true;
            ProductsImg.setImageResource(R.drawable.man_04_pressed);
        } else {
            ProductsRecy.setLayoutManager(new GridLayoutManager(GoodsActivity.this,2));
            b = false;
            ProductsImg.setImageResource(R.drawable.man_04_none);
        }
    }
}
