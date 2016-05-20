package org.matteo.douban.interactors;

import org.matteo.douban.api.DoubanApi;
import org.matteo.douban.bean.Movie;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by matteo on 2016/4/14.
 */
public class MovieDetailInteractorImpl implements MovieDetailInteractor {

    private DoubanApi doubanApi;

    public MovieDetailInteractorImpl(DoubanApi doubanApi) {
        this.doubanApi = doubanApi;
    }

    @Override
    public void getMovieDetail(String id, final MovieDetailCallback callback) {
        doubanApi.getMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Movie>() {
                    @Override
                    public void call(Movie movie) {
                        callback.getMovieDetail(movie);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    @Override
    public void getMoviePhotos(String id, MovieDetailCallback callback) {
        doubanApi.getMoviePhotos(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                });
    }
}
