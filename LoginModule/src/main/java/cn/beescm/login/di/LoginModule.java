package cn.beescm.login.di;

import android.app.Application;

import javax.inject.Singleton;

import cn.beescm.commonbusiness.data.local.PreferencesManager;
import cn.beescm.commonbusiness.di.ApiModule;
import cn.beescm.commonbusiness.di.AppModule;
import cn.beescm.login.data.remote.LoginService;
import cn.beescm.login.model.LoginModel;
import cn.beescm.login.presenter.LoginPresenter;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by zhangshaofang on 2017/6/30.
 */
@Module(includes = {AppModule.class, ApiModule.class})
public class LoginModule {
    @Provides
    @Singleton
    public LoginService provideApiService(Retrofit restAdapter) {
        return restAdapter.create(LoginService.class);
    }

    @Provides
    @Singleton
    public String provideBaseUrl() {
        return LoginService.SERVER_URL;
    }

    @Provides
    @Singleton
    public LoginModel provideApiManager(Application application, LoginService loginService) {
        return new LoginModel(loginService, application);
    }

    @Provides
    LoginPresenter provideLoginPresenter(LoginModel apiManager, PreferencesManager preferencesManager) {
        return new LoginPresenter(apiManager, preferencesManager);
    }
}
