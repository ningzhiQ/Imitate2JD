package com.jd.myjd.imitate2jd.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.bean.Carts;
import com.jd.myjd.imitate2jd.widget.MyAddSubView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

public class MAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Carts.DataBean> list;
    private final DisplayImageOptions options;
    public MAdapter(Context context, List<Carts.DataBean> list) {
        this.context = context;
        this.list = list;
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片色彩模式
                .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放模式
                .build();
    }




    @Override

    public int getGroupCount() {
        return list == null ? 0 : list.size();
    }
    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getList() == null ? 0 : list.get(i).getList().size();
    }
    @Override
    public Object getGroup(int i) {
        return null;
    }
    @Override
    public Object getChild(int i, int i1) {
        return null;
    }
    @Override
    public long getGroupId(int i) {
        return 0;
    }
    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        ParentViewHolder parentHolder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.cart_parent_item_layout, null);
            parentHolder = new ParentViewHolder();
            parentHolder.seller_ck = (CheckBox) view.findViewById(R.id.seller_ck);
            parentHolder.seller_name_tv = (TextView) view.findViewById(R.id.seller_name_tv);
            view.setTag(parentHolder);
        } else {
            parentHolder = (ParentViewHolder) view.getTag();
        }
        parentHolder.seller_name_tv.setText(list.get(i).getSellerName());
        boolean currentSellerAllProductSelected = isCurrentSellerAllProductSelected(i);
        parentHolder.seller_ck.setChecked(currentSellerAllProductSelected);
        parentHolder.seller_ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onCartListChangeListener != null){
                    onCartListChangeListener.onSellerCheckedChange(i);
                }
            }
        });
        return view;
    }

    //判断当前商家所有商品是否被选中
    public boolean isCurrentSellerAllProductSelected(int i) {
        Carts.DataBean dataBean = list.get(i);
        List<Carts.DataBean.ListBean> list1 = dataBean.getList();
        //List<Carts.DataBean.ListBean> list = this.list.get(i).getList();
        for (Carts.DataBean.ListBean listBean : list1) {
            if (listBean.getSelected() == 0) {
                return false;
            }
        }
        return true;
    }
    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        Carts.DataBean dataBean = list.get(i);
        List<Carts.DataBean.ListBean> list = dataBean.getList();
        Carts.DataBean.ListBean listBean = list.get(i1);
        ChildViewHolder childHolder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.cart_child_item_layout, null);
            childHolder = new ChildViewHolder();
            childHolder.child_ck = (CheckBox) view.findViewById(R.id.child_ck);
            childHolder.product_icon_iv = (ImageView) view.findViewById(R.id.product_icon_iv);
            childHolder.product_title_name_tv = (TextView) view.findViewById(R.id.product_title_name_tv);
            childHolder.product_price_tv = (TextView) view.findViewById(R.id.product_price_tv);
            childHolder.add_remove_view = (MyAddSubView) view.findViewById(R.id.add_remove_view);
            view.setTag(childHolder);
        } else {
            childHolder = (ChildViewHolder) view.getTag();
        }
        //商品名称
        childHolder.product_title_name_tv.setText(listBean.getTitle());
        //商品单价
        childHolder.product_price_tv.setText(listBean.getPrice() + "");
        String[] strings = listBean.getImages().split("\\|");
        ImageLoader.getInstance().displayImage(strings[0],childHolder.product_icon_iv,options);
        childHolder.child_ck.setChecked(listBean.getSelected() == 1);
        childHolder.child_ck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onCartListChangeListener != null){
                    onCartListChangeListener.onProductCheckedChange(i,i1);
                }
            }
        });
        childHolder.add_remove_view.setNum(listBean.getNum());
        childHolder.add_remove_view.setOnNumChangerListener(new MyAddSubView.OnNumChangerListener() {
            @Override
            public void onNumChange(int number) {
                if(onCartListChangeListener != null){
                    onCartListChangeListener.onProductNumberChange(i,i1,number);
                }
            }
        });
        return view;
    }
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    //所有商品是否被选中

    public boolean isAllProductsSelected() {



        for (int i = 0; i < list.size(); i++) {

            Carts.DataBean dataBean = list.get(i);



            List<Carts.DataBean.ListBean> list = dataBean.getList();



            for (int j = 0; j < list.size(); j++) {



                if (list.get(j).getSelected() == 0) {



                    return false;



                }



            }

        }

        return true;

    }





    //计算总价
    public float calculateTotalPrice(){
        float totalPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            Carts.DataBean dataBean = list.get(i);
            List<Carts.DataBean.ListBean> list = dataBean.getList();
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j).getSelected() == 1){
                    float price = (float) list.get(j).getPrice();
                    int num = list.get(j).getNum();
                    totalPrice += price * num;
                }
            }
        }
        return totalPrice;
    }
   public int calculateTotalNumber(){
        int totalNumber = 0;
        for (int i = 0; i < list.size(); i++) {
            Carts.DataBean dataBean = list.get(i);
            List<Carts.DataBean.ListBean> list = dataBean.getList();
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j).getSelected() == 1){
                    int num = list.get(j).getNum();
                    totalNumber += num;
                }

            }
        }
        return totalNumber;
    }
    //当商家得checkbox被点击得时候调用，设置当前商家得所有商品得状态
    public void changeCurrentSellerAllProductsStatus(int i, boolean isSelected){
        Carts.DataBean dataBean = list.get(i);
        List<Carts.DataBean.ListBean> list = dataBean.getList();
        for (int j = 0; j < list.size(); j++) {
            Carts.DataBean.ListBean listBean = list.get(j);
            listBean.setSelected(isSelected ? 1 : 0);
        }
    }
    //当商品得checkbox被点击得时候调用，改变当前商品状态
    public void changeCurrentProductStatus(int i, int i1){
        Carts.DataBean dataBean = list.get(i);
        List<Carts.DataBean.ListBean> list = dataBean.getList();
        Carts.DataBean.ListBean listBean = list.get(i1);
        listBean.setSelected(listBean.getSelected() == 0 ? 1 : 0);
    }
    //当加减器被点击得时候调用，改变当前商品得数量
    public void changeCurrentProductNumber(int i, int i1, int number){
        Carts.DataBean dataBean = list.get(i);
        List<Carts.DataBean.ListBean> list = dataBean.getList();
        Carts.DataBean.ListBean listBean = list.get(i1);
        listBean.setNum(number);
    }
    //设置所有商品得状态
    public void changeAllProductsStatus(boolean selected){
        for (int i = 0; i < list.size(); i++) {
            Carts.DataBean dataBean = list.get(i);
            List<Carts.DataBean.ListBean> list = dataBean.getList();
            for (int j = 0; j < list.size(); j++) {
                list.get(j).setSelected(selected ? 1 : 0);
            }
        }
    }
    class ParentViewHolder {
        public CheckBox seller_ck;
        public TextView seller_name_tv;
    }
    class ChildViewHolder {
        public CheckBox child_ck;
        public ImageView product_icon_iv;
        public TextView product_title_name_tv;
        public TextView product_price_tv;
        public MyAddSubView add_remove_view;
    }
    private OnCartListChangeListener onCartListChangeListener;
    public void setOnCartListChangeListener(OnCartListChangeListener onCartListChangeListener){
        this.onCartListChangeListener = onCartListChangeListener;
    }
    public interface OnCartListChangeListener{
        void onSellerCheckedChange(int i);
        void onProductCheckedChange(int i, int i1);
        void onProductNumberChange(int i, int i1, int number);
    }
}
