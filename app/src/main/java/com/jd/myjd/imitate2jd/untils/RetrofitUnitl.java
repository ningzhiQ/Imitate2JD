package com.jd.myjd.imitate2jd.untils;

import com.jd.myjd.imitate2jd.api.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUnitl {
    private static  Retrofit mRetrofit;

    private String baseUrl;

    OkHttpClient client;

    private static RetrofitUnitl mRetrofitManager;
    private static String BaseUrl = Api.login;
    private static OkHttpClient.Builder okHttpbuilder = new OkHttpClient.Builder();

    private RetrofitUnitl(String baseUrl,OkHttpClient client){

        this.baseUrl=baseUrl;

        this.client=client;

        initRetrofit();

    }

    public static synchronized RetrofitUnitl getInstance(String baseUrl,OkHttpClient client){

        if (mRetrofitManager == null){

            mRetrofitManager = new RetrofitUnitl(baseUrl,client);

        }

        return mRetrofitManager;

    }

    private void initRetrofit() {

        mRetrofit = new Retrofit.Builder()

                .baseUrl(baseUrl)

                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                .client(client)

                .build();

    }


    public <T> T setCreate(Class<T> reqServer) {

        return mRetrofit.create(reqServer);

    }
}
