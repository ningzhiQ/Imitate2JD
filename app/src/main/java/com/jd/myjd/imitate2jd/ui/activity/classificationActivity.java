package com.jd.myjd.imitate2jd.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.adapter.MyXqAdapter;
import com.jd.myjd.imitate2jd.bean.ClassXqBean;
import com.jd.myjd.imitate2jd.mvp.presenter.XQPResenterImpl;
import com.jd.myjd.imitate2jd.mvp.view.XQView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class classificationActivity extends Activity implements XQView, View.OnClickListener {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.pull_refush_view)
    PullToRefreshScrollView pullRefushView;
    private XQPResenterImpl resenter;
    private int pscid=1;
    private int page=1;
    private boolean b=false;
    private ImageView class_image_replace;
    private ImageView class_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        ButterKnife.bind(this);
        Fresco.initialize(this);
        class_image_replace = findViewById(R.id.class_image_replace);
        class_back = findViewById(R.id.class_back);
        pullRefushView.setMode(PullToRefreshBase.Mode.BOTH);
        recycleView.setLayoutManager(new LinearLayoutManager(classificationActivity.this,LinearLayoutManager.VERTICAL,false));
        resenter = new XQPResenterImpl(this);
        resenter.getdata(pscid,page);
        pullRefushView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                page=1;
                resenter.getdata(pscid,page);
                pullRefushView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                page++;
                resenter.getdata(pscid,page);
                pullRefushView.onRefreshComplete();
            }
        });
        class_image_replace.setOnClickListener(this);
        class_back.setOnClickListener(this);
    }

    @Override
    public void SuccessCallback(ClassXqBean vbean) {
        final List<ClassXqBean.DataBean> data = vbean.getData();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MyXqAdapter myXqAdapter = new MyXqAdapter(classificationActivity.this,data);
                recycleView.setAdapter(myXqAdapter);
                pullRefushView.onRefreshComplete();
            }
        });
    }

    @Override
    public void FailerCallback(int code) {

    }

    //切换
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.class_image_replace:
                if (b == false) {
                    recycleView.setLayoutManager(new GridLayoutManager(classificationActivity.this, 2));
                    b = true;
                    class_image_replace.setImageResource(R.drawable.kind_grid);
                } else {
                    recycleView.setLayoutManager(new LinearLayoutManager(classificationActivity.this,LinearLayoutManager.VERTICAL,false));
                    b = false;
                    class_image_replace.setImageResource(R.drawable.kind_liner);
                }
                break;
                case R.id.class_back:
                    finish();
                    break;
        }

    }
}
