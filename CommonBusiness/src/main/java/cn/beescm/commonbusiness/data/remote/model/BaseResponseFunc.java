package cn.beescm.commonbusiness.data.remote.model;


import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by zhangshaofang on 2017/6/30
 */
public class BaseResponseFunc<T> implements Function<BaseResponse<T>, Observable<T>> {
    @Override
    public Observable<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
        //遇到非200错误统一处理,将BaseResponse转换成您想要的对象
//        Thread.sleep(3000);
        if (tBaseResponse.getStatus_code() != 200) {
            return Observable.error(new Throwable(tBaseResponse.getStatus_msg()));
        } else {
            return Observable.just(tBaseResponse.getData());
        }
    }
}
