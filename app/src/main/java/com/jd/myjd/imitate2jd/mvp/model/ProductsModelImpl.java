package com.jd.myjd.imitate2jd.mvp.model;

import com.jd.myjd.imitate2jd.bean.ProductsBean;
import com.jd.myjd.imitate2jd.untils.RetrofitUnitl;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import server.ClassNewInstance;
import server.ProductAPi;

public class ProductsModelImpl {
    public void getdata(final ProductsModel productsModelListener, String keywords, int page){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        RetrofitUnitl.getInstance(ClassNewInstance.XQBASE,okHttpClient)
                .setCreate(ProductAPi.class)
                .GetProductsBean(keywords,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ProductsBean productsBean) {
                        productsModelListener.SuccessCallback(productsBean);
                    }
                });
    }
}
