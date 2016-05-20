package org.matteo.douban.component;

import org.matteo.douban.DoubanApplication;
import org.matteo.douban.api.DoubanApi;
import org.matteo.douban.api.UserManager;
import org.matteo.douban.module.AppModule;
import org.matteo.douban.module.InteractorModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by matteo on 2016/4/12.
 */
@Component(
        modules = {
                AppModule.class,
                InteractorModule.class
        }
)
@Singleton
public interface AppComponent {
        void inject(DoubanApplication app);
        DoubanApi getDoubanApi();
}
