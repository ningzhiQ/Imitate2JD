package com.jd.myjd.imitate2jd.mvp.model;

import com.jd.myjd.imitate2jd.api.Advertising;
import com.jd.myjd.imitate2jd.api.Api;
import com.jd.myjd.imitate2jd.bean.AdvertisingBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeModelImpl {
    public void getdata(final HomeModel homeModelListener){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Api.login)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        Advertising advertising = build.create(Advertising.class);
        advertising.Get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AdvertisingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AdvertisingBean advertisingBean) {

                        homeModelListener.SuccessCallback(advertisingBean);
                    }
                });
    }
}
