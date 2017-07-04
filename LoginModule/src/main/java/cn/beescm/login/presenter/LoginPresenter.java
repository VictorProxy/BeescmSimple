package cn.beescm.login.presenter;

import cn.beescm.commonbusiness.data.local.PreferencesManager;
import cn.beescm.commonbusiness.data.remote.SimpleCallback;
import cn.beescm.commonbusiness.base.BasePresenter;
import cn.beescm.login.data.remote.bean.UserBean;
import cn.beescm.login.model.LoginModel;
import cn.beescm.login.view.LoginView;

/**
 * Created by zhangshaofang on 2017/6/30.
 */
public class LoginPresenter extends BasePresenter<LoginView<UserBean>> {

    private final LoginModel mLoginModel;
    private final PreferencesManager mPrefManager;

    public LoginPresenter(LoginModel loginModel, PreferencesManager preferencesManager) {
        this.mLoginModel = loginModel;
        this.mPrefManager = preferencesManager;
    }

    public void checkInput(String username, String password) {
        mViewRef.get().canLogin(mLoginModel.validUsername(username) && mLoginModel.validPassword(password));
    }

    public void login(String username, String password) {
        getView().showLoading();
        mLoginModel.login(username, password, new SimpleCallback<UserBean>() {
            @Override
            public void onNext(UserBean user) {
                if (getView() != null)
                    getView().loginSuccess(user);
            }

            @Override
            public void onComplete() {
                if (getView() != null)
                    getView().hideLoading();
            }
        });
    }

    public void saveLoginInfo(String username, String password) {
        mPrefManager.saveLoginInfo(username, password);
    }

    public String getUserNameFromLocal() {
        return mPrefManager.getUserName();
    }

    public String getPasswordFromLocal() {
        return mPrefManager.getPassword();
    }
}
