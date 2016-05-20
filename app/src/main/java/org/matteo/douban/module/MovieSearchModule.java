package org.matteo.douban.module;

import org.matteo.douban.api.DoubanApi;
import org.matteo.douban.interactors.MovieSearchInteractor;
import org.matteo.douban.interactors.MovieSearchInteractorImpl;
import org.matteo.douban.ui.search.IMovieSearch;
import org.matteo.douban.ui.search.MovieSearchPresenter;
import org.matteo.douban.ui.search.MovieSearchPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by matteo on 2016/5/19.
 */
@Module
public class MovieSearchModule {

    private IMovieSearch iMovieSearch;

    public MovieSearchModule(IMovieSearch iMovieSearch) {
        this.iMovieSearch = iMovieSearch;
    }

    @Provides IMovieSearch provideIMoiveSearch() {
        return iMovieSearch;
    }

    @Provides
    public MovieSearchPresenter provideMovieSearchPresenter(IMovieSearch iMovieSearch, MovieSearchInteractor movieSearchInteractor) {
        return new MovieSearchPresenterImpl(iMovieSearch, movieSearchInteractor);
    }

    @Provides
    public MovieSearchInteractor provideMovieSearchInteractor(DoubanApi doubanApi) {
        return new MovieSearchInteractorImpl(doubanApi);
    }


}
