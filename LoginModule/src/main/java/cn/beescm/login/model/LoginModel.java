package cn.beescm.login.model;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import cn.beescm.commonbusiness.data.remote.ExceptionSubscriber;
import cn.beescm.commonbusiness.data.remote.SimpleCallback;
import cn.beescm.commonbusiness.data.remote.model.BaseResponseFunc;
import cn.beescm.login.data.remote.LoginService;
import cn.beescm.login.data.remote.bean.UserBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhangshaofang on 2017/6/30.
 */
public class LoginModel {

    private final LoginService loginService;

    private final Application application;

    public LoginModel(LoginService apiService, Application application) {
        this.loginService = apiService;
        this.application = application;
    }

    public void login(String username, String password, SimpleCallback<UserBean> simpleCallback) {
        loginService.login(username, password)
                .flatMap(new BaseResponseFunc<>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ExceptionSubscriber<UserBean>(simpleCallback, application));
    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }

    public boolean validPassword(String password) {
        return !TextUtils.isEmpty(password);
    }
}
