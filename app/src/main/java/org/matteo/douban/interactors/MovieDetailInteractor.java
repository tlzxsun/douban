package org.matteo.douban.interactors;

import org.matteo.douban.bean.Movie;

/**
 * Created by matteo on 2016/4/14.
 */
public interface MovieDetailInteractor {

    void getMovieDetail(String id, MovieDetailCallback callback);

    void getMoviePhotos(String id, MovieDetailCallback callback);

    interface MovieDetailCallback{
        void getMovieDetail(Movie movie);

        void getMoviePhotos();
    }
}
