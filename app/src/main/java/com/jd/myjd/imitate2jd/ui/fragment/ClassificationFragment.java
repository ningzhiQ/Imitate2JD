package com.jd.myjd.imitate2jd.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.adapter.ErAdapter;
import com.jd.myjd.imitate2jd.adapter.ZuoAdapter;
import com.jd.myjd.imitate2jd.bean.Yean;
import com.jd.myjd.imitate2jd.bean.Zean;
import com.jd.myjd.imitate2jd.mvp.presenter.FenPresenter;
import com.jd.myjd.imitate2jd.mvp.view.IFenView;

public class ClassificationFragment extends Fragment implements IFenView {

    private FenPresenter presenter;
    private RecyclerView zrv;
    private ExpandableListView yev;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classification, container, false);
        //拿到P层
        presenter = new FenPresenter(this);
        presenter.ShowPer();
        //默认展示第一条
        presenter.FlShowYou(1);
        //找控件
        zrv = view.findViewById(R.id.zrv);
        yev = view.findViewById(R.id.yev);
        return view;
    }

    @Override

    public void onZuo(final Zean zean) {
        //线性布局
        zrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        //拿到适配器
        ZuoAdapter adapter= new ZuoAdapter(getActivity(),zean);
        zrv.setAdapter(adapter);
        //调用点击事件
        adapter.setOnItemClickListener(new ZuoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int id = zean.getData().get(position).getCid();
                presenter.FlShowYou(id);
            }
        });
    }

    @Override

    public void onYou(Yean yean) {

        //拿到适配器

        ErAdapter adapter = new ErAdapter(getActivity(),yean);

        yev.setAdapter(adapter);

        //父级列表默认全部展开

        int groupCount = yev.getCount();

        for (int i=0; i<groupCount; i++)
        {
            yev.expandGroup(i);
        }
    }
}
