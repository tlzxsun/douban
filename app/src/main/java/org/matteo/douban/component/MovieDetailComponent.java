package org.matteo.douban.component;

import org.matteo.douban.ActivityScope;
import org.matteo.douban.ui.detail.MovieDetailActivity;
import org.matteo.douban.module.MovieDetailModule;

import dagger.Component;

/**
 * Created by matteo on 2016/4/12.
 */
@Component(
        dependencies = {
                AppComponent.class
        },
        modules = {
                MovieDetailModule.class
        }
)
@ActivityScope
public interface MovieDetailComponent {

    void inject(MovieDetailActivity activity);
}
