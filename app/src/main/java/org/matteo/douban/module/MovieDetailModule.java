package org.matteo.douban.module;

import org.matteo.douban.api.DoubanApi;
import org.matteo.douban.api.DoubanService;
import org.matteo.douban.bean.Movie;
import org.matteo.douban.interactors.MovieDetailInteractor;
import org.matteo.douban.interactors.MovieDetailInteractorImpl;
import org.matteo.douban.ui.detail.IMovieDetail;
import org.matteo.douban.ui.detail.MovieDetailPresenter;
import org.matteo.douban.ui.detail.MovieDetailPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by matteo on 2016/4/12.
 */
@Module
public class MovieDetailModule {

    private IMovieDetail movieDetail;

    public MovieDetailModule(IMovieDetail movieDetail) {
        this.movieDetail = movieDetail;
    }

    @Provides
    public IMovieDetail provideMovieDetail() {
        return movieDetail;
    }

    @Provides
    public MovieDetailPresenter provideMovieDetailPresenter(IMovieDetail movieDetail, MovieDetailInteractor getMovieDetailInteractor) {
        return new MovieDetailPresenterImpl(movieDetail, getMovieDetailInteractor);
    }

    @Provides
    MovieDetailInteractor provideMovieDetailInteractor(DoubanApi doubanApi) {
        return new MovieDetailInteractorImpl(doubanApi);
    }
}
