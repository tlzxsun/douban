package org.matteo.douban.module;

import org.matteo.douban.DoubanApplication;
import org.matteo.douban.api.UserManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by matteo on 2016/5/6.
 */
@Module
public class AppModule {

    DoubanApplication app;

    public AppModule(DoubanApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public UserManager provideUserManager(DoubanApplication app) {
        return new UserManager(app);
    }

    @Provides
    @Singleton
    public DoubanApplication provideDoubanApplication() {
        return this.app;
    }
}
