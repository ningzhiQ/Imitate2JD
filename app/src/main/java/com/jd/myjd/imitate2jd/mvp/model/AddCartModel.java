package com.jd.myjd.imitate2jd.mvp.model;

import com.jd.myjd.imitate2jd.bean.AddCart;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import server.AddCartInstance;
import server.IAddCartApi;

public class AddCartModel {
    public Observable<AddCart> addCart(String url, int uid, int pid) {
     /*   return RetrofitManager.getDefault().create(IAddCartApi.class).addCart("http://www.zhaoapi.cn/product/addCart", uid, pid);*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AddCartInstance.CartUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IAddCartApi iAddCartApi = retrofit.create(IAddCartApi.class);
        Observable<AddCart> cart = iAddCartApi.addCart("http://www.zhaoapi.cn/product/addCart", uid, pid);
        return cart;
    }
}
