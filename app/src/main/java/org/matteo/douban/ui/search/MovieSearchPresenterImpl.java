package org.matteo.douban.ui.search;

import android.util.Log;

import org.matteo.douban.api.DoubanApi;
import org.matteo.douban.bean.Subject;
import org.matteo.douban.interactors.MovieDetailInteractor;
import org.matteo.douban.interactors.MovieSearchInteractor;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by matteo on 2016/5/19.
 */
public class MovieSearchPresenterImpl implements MovieSearchPresenter{

    private IMovieSearch iMovieSearch;
    private MovieSearchInteractor movieSearchInteractor;

    public MovieSearchPresenterImpl(IMovieSearch iMovieSearch, MovieSearchInteractor movieSearchInteractor) {
        this.iMovieSearch = iMovieSearch;
        this.movieSearchInteractor = movieSearchInteractor;
    }

    @Override
    public void search(String q) {
        movieSearchInteractor.search(q, new MovieSearchInteractor.MovieSearchCallback() {
            @Override
            public void getSearchResult(List<Subject> subjects) {
                iMovieSearch.onSearchResult(subjects);
            }
        });
    }
}
