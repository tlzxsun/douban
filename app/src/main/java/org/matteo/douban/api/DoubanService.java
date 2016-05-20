package org.matteo.douban.api;

import org.matteo.douban.constant.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by matteo on 2016/4/7.
 */
public class DoubanService {

    private Retrofit mRetrofit;

    static class SingletonHolder {
        static DoubanService douService = new DoubanService();
    }

    public DoubanService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.DOUBAN_API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static DoubanService getInstance() {
        return SingletonHolder.douService;
    }

    public static DoubanApi getDouApi() {
        return getInstance().mRetrofit.create(DoubanApi.class);
    }
}
