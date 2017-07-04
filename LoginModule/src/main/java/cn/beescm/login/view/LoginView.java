package cn.beescm.login.view;

import cn.beescm.commonbusiness.base.BaseView;

/**
 * Created by zhangshaofang on 2017/6/30.
 */
public interface LoginView<T> extends BaseView {
    void canLogin(boolean canLogin);

    void loginSuccess(T t);
}
