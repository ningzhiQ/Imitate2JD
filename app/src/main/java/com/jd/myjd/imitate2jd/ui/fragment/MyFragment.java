package com.jd.myjd.imitate2jd.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.adapter.MyRecycleAdapter;
import com.jd.myjd.imitate2jd.bean.Mybean;
import com.jd.myjd.imitate2jd.ui.activity.LoginActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MyFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.home_linear_layout)
    LinearLayout homeLinearLayout;
    @BindView(R.id.recycle_view1)
    RecyclerView recycleView1;
    private MyRecycleAdapter myRecycleAdapter;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //登录
        homeLinearLayout.setOnClickListener(this);
        recycleView1.setLayoutManager(new GridLayoutManager(getActivity(),4));
        ArrayList<Mybean> list = new ArrayList<>();
        list.add(new Mybean(R.drawable.lianxi,"练习"));
        list.add(new Mybean(R.drawable.mydd,"钱包"));
        list.add(new Mybean(R.drawable.dp,"练习"));
        list.add(new Mybean(R.drawable.lingdang,"铃铛"));
        list.add(new Mybean(R.drawable.lianxi,"练习"));
        list.add(new Mybean(R.drawable.mydd,"钱包"));
        list.add(new Mybean(R.drawable.dp,"练习"));
        list.add(new Mybean(R.drawable.lingdang,"铃铛"));
        myRecycleAdapter = new MyRecycleAdapter(getActivity(), list);
        recycleView1.setAdapter(myRecycleAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_linear_layout:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }
}
