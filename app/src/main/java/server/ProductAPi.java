package server;

import com.jd.myjd.imitate2jd.bean.ProductsBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ProductAPi {
    @GET("product/searchProducts")
    Observable<ProductsBean>  GetProductsBean(@Query("keywords") String keywords, @Query("page") int page);
}
