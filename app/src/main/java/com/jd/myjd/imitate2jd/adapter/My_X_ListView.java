package com.jd.myjd.imitate2jd.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jd.myjd.imitate2jd.R;
import com.jd.myjd.imitate2jd.bean.SelectBean;

import java.util.List;

public class My_X_ListView extends BaseExpandableListAdapter{
    private List<SelectBean.DataBean> list;
    private Context context;
    private Callback callback;
    private int countMoney;
    private int countNum;
    private CallbackUpdate callbackUpdate;

    public My_X_ListView(List<SelectBean.DataBean> list, Context context, Callback callback) {
        this.list = list;
        this.context = context;
        this.callback = callback;

    }

    public void setCallbackUpdate(CallbackUpdate callbackUpdate) {
        this.callbackUpdate = callbackUpdate;
    }

    public void setList(List<SelectBean.DataBean> list) {
        list.clear();
        this.list = list;
        notifyDataSetChanged();
    }

    public void selected(boolean ischecked) {
        for (SelectBean.DataBean li : list) {
            List<SelectBean.DataBean.ListBean> list1 = li.getList();
            for (SelectBean.DataBean.ListBean l : list1) {
                if (ischecked) {
                    l.setSelected(0);

                } else {
                    l.setSelected(1);
                }
            }
        }
        notifyDataSetChanged();

    }

    public void MoneyAndNum() {
        countMoney = 0;
        countNum = 0;
        if (list == null) {
            return;
        }
        for (SelectBean.DataBean li : list) {
            List<SelectBean.DataBean.ListBean> list2 = li.getList();
            for (SelectBean.DataBean.ListBean l : list2) {
                if (l.getSelected() == 1) {
                    countMoney += (l.getNum() * l.getBargainPrice());
                    countNum += l.getNum();
                }
            }

        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        MoneyAndNum();
        callback.GoodCart(countMoney, countNum);
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return list.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderOne holderOne = null;
        if (view == null) {
            view = View.inflate(context, R.layout.parent_item, null);
            holderOne = new ViewHolderOne();
            holderOne.text_parent_name = view.findViewById(R.id.text_parent_name);
            view.setTag(holderOne);

        } else {
            holderOne = (ViewHolderOne) view.getTag();
        }
        holderOne.text_parent_name.setText(list.get(i).getSellerName() );

        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {

        ViewHolderTwo holderTwo = null;
        if (view == null) {
            holderTwo = new ViewHolderTwo();
            view = View.inflate(context, R.layout.child_item1, null);
            holderTwo.good_cart_count = view.findViewById(R.id.good_cart_count);
            holderTwo.good_cart_image = view.findViewById(R.id.good_cart_image);
            holderTwo.good_cart_jia = view.findViewById(R.id.good_cart_jia);
            holderTwo.good_cart_rb = view.findViewById(R.id.good_cart_rb);
            holderTwo.good_cart_jian = view.findViewById(R.id.good_cart_jian);
            holderTwo.good_cart_title = view.findViewById(R.id.good_cart_title);
            holderTwo.good_cart_price = view.findViewById(R.id.good_cart_price);
            holderTwo.good_cart_price2 = view.findViewById(R.id.good_cart_price2);
            holderTwo.good_cart_delete=view.findViewById(R.id.good_cart_delete);
            view.setTag(holderTwo);
        } else {
            holderTwo = (ViewHolderTwo) view.getTag();
        }

        holderTwo.good_cart_title.setText(list.get(i).getList().get(i1).getTitle());
        Glide.with(context).load(list.get(i).getList().get(i1).getImages().split("\\|")[0]).into(holderTwo.good_cart_image);
        holderTwo.good_cart_price.setText(list.get(i).getList().get(i1).getPrice() + "");
        holderTwo.good_cart_price2.setText(list.get(i).getList().get(i1).getBargainPrice() + "");
        holderTwo.good_cart_price2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holderTwo.good_cart_count.setText(list.get(i).getList().get(i1).getNum() + "");
        final String sellerid=list.get(i).getSellerid();
        final String pid= String.valueOf(list.get(i).getList().get(i1).getPid());
        final String num= String.valueOf(list.get(i).getList().get(i1).getNum());
        final int selected=list.get(i).getList().get(i1).getSelected();

        holderTwo.good_cart_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = list.get(i).getList().get(i1).getNum();
                num1++;
                list.get(i).getList().get(i1).setNum(num1);
                notifyDataSetChanged();


               // callbackUpdate.getadd(pid+"");
            }
        });
        holderTwo.good_cart_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = list.get(i).getList().get(i1).getNum();

                if (num > 1) {
                    num--;
                    callbackUpdate.getupdate(sellerid,pid,selected +"",""+num);
                } else {
                    Toast.makeText(context, "不能在小了", Toast.LENGTH_SHORT).show();
                    num = 0;
                }
                list.get(i).getList().get(i1).setNum(num);
                notifyDataSetChanged();
            }
        });
        if (list.get(i).getList().get(i1).getSelected() == 0) {
            holderTwo.good_cart_rb.setChecked(false);
        } else if (list.get(i).getList().get(i1).getSelected() == 1) {
            holderTwo.good_cart_rb.setChecked(true);
        }
        holderTwo.good_cart_rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = list.get(i).getList().get(i1).getSelected();
                if (selected == 1) {
                    callbackUpdate.getupdate(sellerid,pid,1 +"",""+num);
                    //  list.get(i).getList().get(i1).setSelected(0);
                } else if (selected == 0) {
                    callbackUpdate.getupdate(sellerid,pid,0+"",""+num);
                    //   list.get(i).getList().get(i1).setSelected(1);
                }
                notifyDataSetChanged();
            }
        });
        holderTwo.good_cart_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                callbackUpdate.getdelete(pid);
                Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class ViewHolderOne {
        private TextView text_parent_name;
    }
    class ViewHolderTwo {
        private CheckBox good_cart_rb;
        private TextView good_cart_title;
        private TextView good_cart_price;
        private TextView good_cart_price2;
        private ImageView good_cart_image;
        private TextView good_cart_jia;
        private TextView good_cart_count;
        private TextView good_cart_jian;
        private Button good_cart_delete;
    }
    public interface Callback {
        void GoodCart(int countMoney, int countNum);
    }
    public interface CallbackUpdate{
        //添加
        void getadd(String pid);

        //更新

        //删除
        void getdelete(String pid);

        void getupdate(String sellerid, String pid, String selected, String num);
    }
}
