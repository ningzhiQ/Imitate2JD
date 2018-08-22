package com.jd.myjd.imitate2jd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.bean.AdvertisingBean;
import com.jd.myjd.imitate2jd.bean.CatagoryBean;
import com.jd.myjd.imitate2jd.ui.activity.ClassXqPageActivity;
import com.jd.myjd.imitate2jd.widget.MyRecycle;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyHomeAdapter extends RecyclerView.Adapter{

    private AdvertisingBean bean;
    private Context context;
    private List<CatagoryBean.DataBean> dataBeans;
    public MyHomeAdapter(AdvertisingBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    public void setCatagoryList(List<CatagoryBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 1;
        } else if (position == 1) {
            if (dataBeans != null){
                return 2;
            }
            return 3;
        } else if (position == 2) {
            return 3;
        } else if (position == 3) {
            return 4;
        }
        return 4;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 1:
                View view = LayoutInflater.from(context).inflate(R.layout.fg_homeitem_banner, parent, false);
                holder = new ViewHolderBanner(view);
                break;
            case 2:
                View view1 = LayoutInflater.from(context).inflate(R.layout.fg_home_fenlei, parent, false);
                holder = new ViewHolderFenLei(view1);
                break;
            case 3:
                View view2 = LayoutInflater.from(context).inflate(R.layout.fg_homeitem_liurecy, parent, false);
                holder = new ViewHolderLiushi(view2);
                break;
           case 4:
                View view3 = LayoutInflater.from(context).inflate(R.layout.fg_homeitem_recy, parent, false);
                holder = new ViewHolderRecy(view3);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderBanner) {
            List<AdvertisingBean.DataBean> data = bean.getData();
            ArrayList<String> title = new ArrayList<>();
            ArrayList<String> imgurl = new ArrayList<>();
            for (AdvertisingBean.DataBean databean : data) {
                title.add(databean.getTitle());
                imgurl.add(databean.getIcon());
            }
            ((ViewHolderBanner) holder).itemXbanner.setData(imgurl, title);
            ((ViewHolderBanner) holder).itemXbanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(context).load((String) model).into((ImageView) view);
                }
            });
            ((ViewHolderBanner) holder).itemXbanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, Object model, int position) {
                    Intent intent = new Intent(context, ClassXqPageActivity.class);
                    context.startActivity(intent);
                }
            });
        } else if (holder instanceof ViewHolderLiushi) {
            AdvertisingBean.MiaoshaBean miaosha = bean.getMiaosha();
            ((ViewHolderLiushi) holder).indexLiushiTime.setText(miaosha.getTime());
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL);
            ((ViewHolderLiushi) holder).indexLiushiRecy.setLayoutManager(staggeredGridLayoutManager);
            List<AdvertisingBean.MiaoshaBean.ListBeanX> ListBeanX = miaosha.getList();
            homeFg_itemliuhsi_Adapter indexFg_itemliuhsi_adapter = new homeFg_itemliuhsi_Adapter(context, ListBeanX);
            ((ViewHolderLiushi) holder).indexLiushiRecy.setAdapter(indexFg_itemliuhsi_adapter);
        } else if (holder instanceof ViewHolderRecy) {
            AdvertisingBean.TuijianBean tuijian = bean.getTuijian();
            List<AdvertisingBean.TuijianBean.ListBean> list = tuijian.getList();
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
            ((ViewHolderRecy) holder).indexitemReRecy.setLayoutManager(staggeredGridLayoutManager);
            home_recyitemAdapter home_recyitemAdapter = new home_recyitemAdapter(context, list);
            ((ViewHolderRecy) holder).indexitemReRecy.setAdapter(home_recyitemAdapter);
        } else if (holder instanceof ViewHolderFenLei) {
           /* ArrayList<ArrayList<CatagoryBean.DataBean>> arrayLists = new ArrayList<>();
            ArrayList<CatagoryBean.DataBean> dataBeans =null;
            for ( int i = 0; i < dataBeans.size();i++) {
                if ((i % 8) == 0){
                    arrayLists.add(dataBeans);
                    dataBeans = new ArrayList<>();
                }
                dataBeans.add(dataBeans.get(i));
            }
            ArrayList<RecyclerView> recyclerViews = new ArrayList<>();
            for (ArrayList<CatagoryBean.DataBean> ll : arrayLists){
                View inflate = LayoutInflater.from(context).inflate(R.layout.fg_fenlei_recyle, ((ViewHolderFenLei) holder).fgIndexFenlei, false);
                RecyclerView recy = inflate.findViewById(R.id.fg_fenlei_rrrr);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
                recy.setLayoutManager(gridLayoutManager);
                if (ll == null){
                    continue;
                }
                index_fenlei_adapter index_fenlei_adapter = new index_fenlei_adapter(ll, context);
                recy.setAdapter(index_fenlei_adapter);
                recyclerViews.add(recy);*/
            }
           /* index_viewpage_adapter index_viewpage_adapter = new index_viewpage_adapter(recyclerViews);
            ((ViewHolderFenLei) holder).fgIndexFenlei.setAdapter(index_viewpage_adapter);*/

    }



    @Override
    public int getItemCount() {
        return 4;
    }
    static class ViewHolderBanner extends RecyclerView.ViewHolder {
        @BindView(R.id.item_xbanner)
        XBanner itemXbanner;

        ViewHolderBanner(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderLiushi extends RecyclerView.ViewHolder {
        @BindView(R.id.index_liushi_recy)
        RecyclerView indexLiushiRecy;
        @BindView(R.id.index_liushi_title)
        TextView indexLiushiTitle;
        @BindView(R.id.index_liushi_time)
        TextView indexLiushiTime;


        ViewHolderLiushi(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static class ViewHolderRecy extends RecyclerView.ViewHolder {
        //        @BindView(R.id.indexitem_re_recy)
        MyRecycle indexitemReRecy;
        //        @BindView(R.id.indexitem_retitl)
        TextView indexitemRetitl;

        ViewHolderRecy(View view) {
            super(view);
            indexitemReRecy = view.findViewById(R.id.indexitem_re_recy);
            indexitemRetitl = view.findViewById(R.id.indexitem_retitl);
//            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderFenLei extends RecyclerView.ViewHolder {
        @BindView(R.id.fg_index_fenlei)
        ViewPager fgIndexFenlei;

        ViewHolderFenLei(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
