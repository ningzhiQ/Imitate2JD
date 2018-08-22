package com.jd.myjd.imitate2jd.mvp.model;

import com.jd.myjd.imitate2jd.bean.SelectBean;
import com.jd.myjd.imitate2jd.bean.UpdateBean;
import com.jd.myjd.imitate2jd.mvp.view.Shopp_Contract;
import com.jd.myjd.imitate2jd.untils.Fenzhuang;

import okhttp3.logging.HttpLoggingInterceptor;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import server.ShoppApi;

public class Shopp_Model implements Shopp_Contract.Model{
    @Override
    public void GetShoppAdd(String uid, String pid, String token, final ModelData data) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Fenzhuang.setInterceptor(httpLoggingInterceptor);
        ShoppApi service = Fenzhuang.createService(ShoppApi.class);
        service.getAdd(uid,pid,token)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Observer<UpdateBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UpdateBean updateBean) {
                        data.getadd(updateBean);

                    }
                });
    }

    @Override
    public void GetShoppSelect(String uid, String token, final ModelData data) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Fenzhuang.setInterceptor(httpLoggingInterceptor);
        ShoppApi service = Fenzhuang.createService(ShoppApi.class);
        service.getSelect(uid,token)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Observer<SelectBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SelectBean selectBean) {
                        data.getSelect(selectBean);
                    }
                });
    }

    @Override
    public void GetShoppUpdate(String uid, String selleridm, String pid, String selected, String num, final ModelData data) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Fenzhuang.setInterceptor(httpLoggingInterceptor);
        ShoppApi service = Fenzhuang.createService(ShoppApi.class);
        service.getUpdate(uid,selleridm,pid,selected,num)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Observer<UpdateBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UpdateBean updateBean) {
                        data.getadd(updateBean);
                    }
                });

    }

    @Override
    public void GetShoppDelete(String uid, String pid, String token, final ModelData data) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Fenzhuang.setInterceptor(httpLoggingInterceptor);
        ShoppApi service = Fenzhuang.createService(ShoppApi.class);
        service.getDelete(uid,pid,token)
                . subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Observer<UpdateBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UpdateBean updateBean) {
                        data.getadd(updateBean);
                    }
                });
    }
}
