package cn.beescm.login.di;

import javax.inject.Singleton;

import cn.beescm.login.LoginActivity;
import dagger.Component;

/**
 * Created by zhangshaofang on 2017/6/30.
 */
@Singleton
@Component(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
