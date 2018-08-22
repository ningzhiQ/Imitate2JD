package com.jd.myjd.imitate2jd.ui.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.adapter.MyHomeAdapter;
import com.jd.myjd.imitate2jd.bean.AdvertisingBean;
import com.jd.myjd.imitate2jd.mvp.presenter.HomePresenterImpl;
import com.jd.myjd.imitate2jd.mvp.view.HomeView;
import com.jd.myjd.imitate2jd.ui.activity.HomeSearchActivity;
import com.sunfusheng.marqueeview.MarqueeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements HomeView, XRecyclerView.LoadingListener, View.OnClickListener {

    @BindView(R.id.xrecycle)
    XRecyclerView xrecycle;
    Unbinder unbinder;
    @BindView(R.id.home_back)
    ImageView homeBack;
    @BindView(R.id.home_search2)
    ImageView homeSearch2;
    @BindView(R.id.home_edit_search)
    EditText homeEditSearch;
    @BindView(R.id.class_image_xx)
    ImageView classImageXx;
    @BindView(R.id.home_relative_layout)
    RelativeLayout homeRelativeLayout;
    private LinearLayout home_linear_layout;
    private HomePresenterImpl presenter;
    private MarqueeView marqueeView;
    private int mDistanceY = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        //  marqueeView =view.findViewById(R.id.marqueeView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrecycle.setPullRefreshEnabled(true);
        xrecycle.setLoadingMoreEnabled(true);
        xrecycle.setLoadingListener(this);
        xrecycle.setLayoutManager(linearLayoutManager);
        presenter = new HomePresenterImpl(this);
        presenter.getdata();
        homeRelativeLayout.setOnClickListener(this);
        xrecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                int toolbarHeight = homeEditSearch.getBottom();
                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    homeEditSearch.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                } else {
                    //将标题栏的颜色设置为完全不透明状态
                    homeEditSearch.setBackgroundResource(R.color.white);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {

        xrecycle.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        xrecycle.loadMoreComplete();
    }

    @Override
    public void SuccessCallback(AdvertisingBean vbean) {
        MyHomeAdapter myHomeAdapter = new MyHomeAdapter(vbean, getActivity());
        xrecycle.setAdapter(myHomeAdapter);
    }

    @Override
    public void FailerCallback(int code) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_relative_layout:
                startActivity(new Intent(getActivity(), HomeSearchActivity.class));
                break;
        }
    }
}
