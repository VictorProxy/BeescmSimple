package cn.beescm.commonbusiness.data.remote;

/**
 * Created by zhangshaofang on 2017/6/30
 */
public interface SimpleCallback<T> {
    void onNext(T t);

    void onComplete();
}
