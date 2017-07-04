package cn.beescm.commonbusiness.di;

import android.app.Application;

import cn.beescm.commonbusiness.data.local.PreferencesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangshaofang on 2017/6/30
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public PreferencesManager provideSharedPreferences() {
        return new PreferencesManager(application);
    }


}
