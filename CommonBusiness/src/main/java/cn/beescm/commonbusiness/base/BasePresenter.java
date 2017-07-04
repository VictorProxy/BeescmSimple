package cn.beescm.commonbusiness.base;

import java.lang.ref.WeakReference;

/**
 * Created by zhangshaofang on 2017/6/30
 */
public abstract class BasePresenter<T> {
    /**
     * 当内存不足可释放内存
     */
    protected WeakReference<T> mViewRef;

    /**
     * bind p view v
     *
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 解除管理
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected T getView() {
        return mViewRef.get();
    }
}
