package server;

import com.jd.myjd.imitate2jd.bean.AddCart;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

public interface IAddCartApi {
    @GET()
    Observable<AddCart> addCart(@Url String url, @Query("uid") int uid, @Query("pid") int pid);
}
