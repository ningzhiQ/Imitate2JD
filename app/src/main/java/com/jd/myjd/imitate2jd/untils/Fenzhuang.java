package com.jd.myjd.imitate2jd.untils;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import server.ClassNewInstance;

public class Fenzhuang {
    private static final String TAG = "Fenzhuang";
    private static String BaseUrl = ClassNewInstance.XQBASE;
    private static OkHttpClient.Builder okHttpbuilder = new OkHttpClient.Builder();
    ;
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpbuilder.build())
                    .baseUrl(BaseUrl);

    /**
     * 修改baseurl的网址
     *
     * @param url
     */
    public static void upDataBasrUrl(String url) {
        BaseUrl = url;
    }

    /**
     * 设置拦截器
     *
     * @param interceptor
     */
    public static void setInterceptor(Interceptor interceptor) {

        okHttpbuilder.addNetworkInterceptor(interceptor);
    }


    public static <S> S createService(Class<S> serviceClass) {
        Retrofit build = builder.build();
        return build.create(serviceClass);
    }
   /* public static Subscription Zhuce(String Password, String Name, Subscriber<RegestBean> subscriber) {
        Retrofit build = builder.build();
        LoginInterface rxjavaService = build.create(LoginInterface.class);
        Subscription subscribe = rxjavaService.getRegest(Name, Password)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(subscriber);
        Log.d(TAG, "Zhuce: "+Name);
        return subscribe;
    }*/

/*    public static Subscription Login(String Password, String Name, Subscriber<LoginBean> subscriber) {
        Retrofit build = builder.build();
        GetMeLoginOrReg rxjavaService = build.create(GetMeLoginOrReg.class);
        return rxjavaService.getLogin(Name, Password)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(subscriber);
    }*/
}
