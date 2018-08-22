package com.jd.myjd.imitate2jd.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jd.myjd.imitate2jd.bean.ProductBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class ImageAdapter extends PagerAdapter {
    Context context;
    List<ProductBean.DataBean> list;
    public ImageAdapter(Context context, List<ProductBean.DataBean> list) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        String images = list.get(0).getImages();
        String[] split = images.split("\\|");
        ImageLoader.getInstance().displayImage(split[position%split.length],imageView);
        container.addView(imageView);
        return imageView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
