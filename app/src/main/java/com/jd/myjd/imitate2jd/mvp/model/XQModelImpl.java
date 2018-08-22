package com.jd.myjd.imitate2jd.mvp.model;

import com.jd.myjd.imitate2jd.bean.ClassXqBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import server.ClassNewInstance;
import server.ClassificationInters;

public class XQModelImpl {
    public void getdata(final XQModel xqModelListener, int pscid,int page){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ClassNewInstance.XQBASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ClassificationInters classificationInters = retrofit.create(ClassificationInters.class);
        classificationInters.getList(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassXqBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ClassXqBean classXqBean) {
                        xqModelListener.SuccessCallback(classXqBean);
                    }
                });
    }
}
