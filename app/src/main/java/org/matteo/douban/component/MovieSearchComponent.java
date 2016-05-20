package org.matteo.douban.component;

import org.matteo.douban.ActivityScope;
import org.matteo.douban.module.MovieSearchModule;
import org.matteo.douban.ui.search.SearchActivity;

import dagger.Component;

/**
 * Created by matteo on 2016/5/19.
 */
@Component(
        dependencies = {
                AppComponent.class
        },
        modules = {
                MovieSearchModule.class
        }
)
@ActivityScope
public interface MovieSearchComponent {

    void inject(SearchActivity activity);
}
