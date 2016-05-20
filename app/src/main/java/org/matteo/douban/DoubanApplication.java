package org.matteo.douban;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.matteo.douban.api.UserManager;
import org.matteo.douban.component.AppComponent;
import org.matteo.douban.component.DaggerAppComponent;
import org.matteo.douban.module.AppModule;
import org.matteo.douban.request.ImageLoadUtil;
import org.matteo.douban.util.UIUtil;

import javax.inject.Inject;

/**
 * Created by matteo on 2015/6/25.
 */
public class DoubanApplication extends Application{

    private AppComponent appComponent;

    @Inject
    UserManager userManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ImageLoadUtil.init(this);
        UIUtil.init(this);
        setupComponent();
    }

    private void setupComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public static DoubanApplication get(Context context) {
        return (DoubanApplication) context.getApplicationContext();
    }

    public AppComponent component() {
        return appComponent;
    }

    public UserManager userManager() {
        return userManager;
    }
}
