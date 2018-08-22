package com.jd.myjd.imitate2jd.untils;

import com.google.gson.JsonObject;
import com.jd.myjd.imitate2jd.api.JDApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import server.LoginInterface;

public class RetrofitUtils {
    private static  RetrofitUtils RetrofitUtils;
    private LoginInterface loginInterface;

    public static RetrofitUtils getInstance() {
        if (RetrofitUtils != null) {
            return RetrofitUtils;
        }else{

            return new RetrofitUtils();
        }
    }

    private RetrofitUtils() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(JDApi.BaseApi)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        loginInterface = retrofit.create(LoginInterface.class);

    }

    //异步方法
    public void async(Observable<JsonObject> observable, Subscriber<JsonObject> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public LoginInterface getApiserver(){
        return loginInterface;
    }
}
