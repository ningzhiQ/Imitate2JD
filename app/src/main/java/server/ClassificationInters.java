package server;

import com.jd.myjd.imitate2jd.bean.ClassXqBean;
import com.jd.myjd.imitate2jd.bean.Yean;
import com.jd.myjd.imitate2jd.bean.Zean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ClassificationInters {
    /**

     * 左面接口

     */

    @GET("product/getCatagory")
    Observable<Zean> Zuo();

    /**

     * 右面接口

     */

    @GET("product/getProductCatagory")

    Observable<Yean> You(@Query("cid") int cid);

    //商品详情
    @GET("product/getProducts")
    Observable<ClassXqBean> getList(@Query("pscid") int pscid);
}
