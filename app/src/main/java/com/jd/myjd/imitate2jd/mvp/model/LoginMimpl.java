package com.jd.myjd.imitate2jd.mvp.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jd.myjd.imitate2jd.bean.LoginBean;
import com.jd.myjd.imitate2jd.untils.RetrofitUtils;

import rx.Subscriber;

public class LoginMimpl {

    public  void login(final LoginModel loginModelLis,String path,String uname,String upwd ) {
        RetrofitUtils.getInstance().async(RetrofitUtils.getInstance().getApiserver().getLogin(uname, upwd), new Subscriber<JsonObject>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(JsonObject jsonObject) {
                LoginBean loginBean = new Gson().fromJson(jsonObject, LoginBean.class);
                loginModelLis.ModelNewsSuccess(loginBean);

            }
        });
    }

}
