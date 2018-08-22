package com.jd.myjd.imitate2jd.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.adapter.My_X_ListView;
import com.jd.myjd.imitate2jd.bean.SelectBean;
import com.jd.myjd.imitate2jd.bean.UpdateBean;
import com.jd.myjd.imitate2jd.mvp.presenter.Shopp_Presenter;
import com.jd.myjd.imitate2jd.mvp.view.Shopp_Contract;

import java.util.List;

public class ShoppingFragment extends Fragment implements Shopp_Contract.View{
    private Shopp_Presenter shopp_presenter;
    private ExpandableListView e_list_view;
    private ImageView back3;
    private TextView price;
    private CheckBox check;
    private boolean ischeck = false;
    private View view;
    private My_X_ListView adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        e_list_view = view.findViewById(R.id.e_list_view);
        back3 = view.findViewById(R.id.back3);
        price = view.findViewById(R.id.price);
        check = view.findViewById(R.id.check);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shopp_presenter = new Shopp_Presenter(this,"16886","0812C82F990D6A64276DE9303BA497F5");
        shopp_presenter.GetShoppSelect();
        shopp_presenter.GetShoppAdd("1");
        e_list_view.setAdapter(adapter);
        Log.i("aaa",e_list_view.toString());
        //初始化控件
        initview();

    }

    private void initview() {
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ischeck) {
                    adapter.selected(ischeck);
                    ischeck = false;
                    check.setChecked(ischeck);
                } else {
                    adapter.selected(ischeck);
                    ischeck = true;
                    check.setChecked(ischeck);
                }
            }
        });
    }

    @Override
    public void GetShoppAddBean(UpdateBean updateBean) {
        Toast.makeText(getActivity(), updateBean.getMsg(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void GetShoppSelectBean(SelectBean selectBean) {
        List<SelectBean.DataBean> data = selectBean.getData();
        Log.i("cc",data+"");
        adapter = new My_X_ListView(data, getActivity(), new My_X_ListView.Callback() {
            @Override
            public void GoodCart(int countMoney, int countNum) {
                price.setText("小计：" + countMoney);
                check.setText("已选:" + countNum);
            }
        });
        e_list_view.setGroupIndicator(null);

        adapter.setCallbackUpdate(new My_X_ListView.CallbackUpdate() {
            @Override
            public void getadd(String pid) {
                shopp_presenter.GetShoppAdd(pid);
            }

            @Override
            public void getdelete(String pid) {
                shopp_presenter.GetShoppDelete(pid);
            }

            @Override
            public void getupdate(String sellerid, String pid, String selected, String num) {
                shopp_presenter.GetShoppUpdate(sellerid,pid,selected,num);
            }
        });


        int count = e_list_view.getCount();
        for (int i = 0; i < count; i++) {
            e_list_view.expandGroup(i);
        }
    }
}
