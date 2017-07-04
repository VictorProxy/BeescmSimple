package cn.beescm.login.data.remote;

import cn.beescm.commonbusiness.data.remote.model.BaseResponse;
import cn.beescm.login.data.remote.bean.UserBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangshaofang on 2017/6/30.
 */
public interface LoginService {

    String SERVER_URL = "http://192.168.105.33:3000/";

    @GET("users")
    Observable<BaseResponse<UserBean>> login(@Query("username") String username, @Query("password") String password);
}
