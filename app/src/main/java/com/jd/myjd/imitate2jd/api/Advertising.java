package com.jd.myjd.imitate2jd.api;

import com.jd.myjd.imitate2jd.bean.AdvertisingBean;
import com.jd.myjd.imitate2jd.bean.CatagoryBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Advertising {
    @GET("ad/getAd")
    Observable<AdvertisingBean> Get();

    @GET("product/getCatagory?")
    Observable<CatagoryBean> GetCatagory(@Query("token") String token);
}
