package org.matteo.douban.api;

import org.matteo.douban.bean.ArrayResult;
import org.matteo.douban.bean.Movie;
import org.matteo.douban.bean.Subject;
import org.matteo.douban.bean.Top250;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by matteo on 2016/4/7.
 */
public interface DoubanApi {

    @GET("v2/movie/subject/{id}")
    Observable<Movie> getMovie(@Path("id") String id);

    @GET("v2/movie/weekly")
    Observable<String> getWeekly();

    @GET("v2/movie/top250")
    Observable<Top250> getTop250();

    @GET("v2/movie/subject/{id}/photos")
    Observable<String> getMoviePhotos(@Path("id") String id);

    @GET("v2/movie/search")
    Observable<String> searchByTag(@Query("tag") String tag);

    @GET("v2/movie/search")
    Observable<ArrayResult<Subject>> searchByQ(@Query("q") String q);

    @GET
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<String> token(@Url String url);

    @POST
    Observable<String> refreshToken(@Url String url);
}
