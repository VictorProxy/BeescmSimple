package cn.beescm.commonbusiness.data.remote;

import android.app.Application;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 错误统一处理
 * Created by zhangshaofang on 2017/6/30
 */
public class ExceptionSubscriber<T> implements Observer<T> {

    private SimpleCallback<T> simpleCallback;
    private Application application;

    public ExceptionSubscriber(SimpleCallback simpleCallback, Application application) {
        this.simpleCallback = simpleCallback;
        this.application = application;
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(application, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (simpleCallback != null)
            simpleCallback.onComplete();
    }

    @Override
    public void onComplete() {
        if (simpleCallback != null)
            simpleCallback.onComplete();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        if (simpleCallback != null)
            simpleCallback.onNext(t);
    }
}
