package org.matteo.douban.request;

import android.net.Uri;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;

/**
 * Created by matteo on 2015/6/25.
 */
public class RequestManager {

    public static final String DOUBAN_API = "http://api.douban.com";

    public static void getMovieDetail(String id, Callback callback){
        Request request = new Request.Builder().url(Uri.parse(DOUBAN_API).buildUpon()
                    .appendEncodedPath("/v2/movie/subject/" + id).build().toString())
                .build();
        OkHttpUtil.enqueue(request, callback);
    }
}
