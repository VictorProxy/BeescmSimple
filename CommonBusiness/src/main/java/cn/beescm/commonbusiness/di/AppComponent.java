package cn.beescm.commonbusiness.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhangshaofang on 2017/6/30
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
}
