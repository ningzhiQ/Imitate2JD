package server;

import com.google.gson.JsonObject;
import com.jd.myjd.imitate2jd.bean.RegestBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface LoginInterface {
    //https://www.zhaoapi.cn/user/login?mobile=12345678901&password=123456
    public static final String Base="https://www.zhaoapi.cn/";

    //登录模块
    @POST("user/login")
    Observable<JsonObject> getLogin(@Query("mobile") String mobile, @Query("password") String password);
    //https://www.zhaoapi.cn/user/reg
    @POST("user/reg")
    Call<RegestBean> getRegest(@Query("mobile") String mobile, @Query("password") String password);
    //首页api
    //https://www.zhaoapi.cn/ad/getAd
    @POST("ad/getAd")
    Observable<JsonObject> getFirstPage();
}
