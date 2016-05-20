package org.matteo.douban.ui.detail;

import org.matteo.douban.bean.Movie;
import org.matteo.douban.interactors.MovieDetailInteractor;

/**
 * Created by matteo on 2016/4/13.
 */
public class MovieDetailPresenterImpl implements MovieDetailPresenter, MovieDetailInteractor.MovieDetailCallback{

    private MovieDetailInteractor getMovieDetailInteractor;
    private IMovieDetail iMovieDetail;

    public MovieDetailPresenterImpl(IMovieDetail movieDetail, MovieDetailInteractor getMovieDetailInteractor) {
        this.iMovieDetail = movieDetail;
        this.getMovieDetailInteractor = getMovieDetailInteractor;
    }

    @Override
    public void getMovieDetail(String id) {
        getMovieDetailInteractor.getMovieDetail(id, this);
    }

    @Override
    public void getMoviePhotos(String id) {
        getMovieDetailInteractor.getMoviePhotos(id, this);
    }

    @Override
    public void getMovieDetail(Movie movie) {
        iMovieDetail.initMovieDetail(movie);
    }

    @Override
    public void getMoviePhotos() {
        iMovieDetail.initMoviePhotos();
    }
}
