package cn.beescm.login;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

import com.chenenyu.router.Router;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import cn.beescm.commonbusiness.base.BaseActivity;
import cn.beescm.commonbusiness.di.AppModule;
import cn.beescm.login.data.remote.bean.UserBean;
import cn.beescm.login.databinding.ActLoginBinding;
import cn.beescm.login.di.DaggerLoginComponent;
import cn.beescm.login.presenter.LoginPresenter;
import cn.beescm.login.view.LoginView;

/**
 * Created by zhangshaofang on 2017/6/30.
 */
public class LoginActivity extends BaseActivity<LoginView<UserBean>, ActLoginBinding, LoginPresenter> implements LoginView<UserBean> {

    @Override
    protected int getLayoutId() {
        return R.layout.act_login;
    }

    @Override
    protected void init() {
        mBinding.username.setText(mPresenter.getUserNameFromLocal());
        mBinding.password.setText(mPresenter.getPasswordFromLocal());
        RxTextView.textChanges(mBinding.username)
                .subscribe(charSequence -> mPresenter.checkInput(charSequence.toString(), mBinding.password.getText().toString()));
        RxTextView.textChanges(mBinding.password)
                .subscribe(charSequence -> mPresenter.checkInput(charSequence.toString(), mBinding.username.getText().toString()));
        RxView.clicks(mBinding.login).subscribe(v -> mPresenter.login(mBinding.username.getText().toString(), mBinding.password.getText().toString()));
    }

    @Override
    public void setupComponent() {
        DaggerLoginComponent.builder().appModule(new AppModule(getApplication()))
                .build().inject(this);
    }

    @Override
    public void canLogin(boolean canLogin) {
        if (canLogin) {
            mBinding.login.setEnabled(true);
            mBinding.login.setBackgroundColor(Color.GREEN);
        } else {
            mBinding.login.setEnabled(false);
            mBinding.login.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public void loginSuccess(UserBean user) {
        mPresenter.saveLoginInfo(user.getUsername(), user.getPassword());
        Log.e("showUser", user.toString());
        Router.build("com.weex.sample.index").go(this);
    }

    @Override
    public void showLoading() {
        showWaitDialog("加载中...");
    }

    @Override
    public void hideLoading() {
        dissmissWaitDialog();
    }

}
