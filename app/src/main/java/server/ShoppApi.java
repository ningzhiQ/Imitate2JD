package server;

import com.jd.myjd.imitate2jd.bean.SelectBean;
import com.jd.myjd.imitate2jd.bean.UpdateBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ShoppApi {
    public static final String BATH="https://www.zhaoapi.cn/";

    /**
     * 添加购物车
     * uid 用户id
     * pid
     * token
     */
    @GET("product/addCart")
    Observable<UpdateBean> getAdd(@Query("uid") String uid, @Query("pid") String pid, @Query("token")
            String token);

    /**
     * 查询购物车
     * uid 用户id
     * pid
     * token
     */

    @GET("product/getCarts")
    Observable <SelectBean> getSelect(@Query("uid")  String pid, @Query("token")
            String token);

    /**
     * 更新购物车
     *uid=168971
     * sellerid=1
     * pid=1
     * selected=0
     * num=10
     */
    @GET("product/updateCarts")
    Observable <UpdateBean> getUpdate(@Query("uid") String uid,@Query("sellerid") String sellerid,@Query("pid")
            String pid,@Query("selected") String selected,@Query("num") String num);

    /**
     * 删除购物车
     * uid 用户id
     * pid
     * token
     */
    @GET("product/deleteCart")
    Observable <UpdateBean> getDelete(@Query("uid") String uid,@Query("pid") String pid,@Query("token")
            String token);
}
