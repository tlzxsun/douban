package org.matteo.douban.module;

import org.matteo.douban.api.DoubanApi;
import org.matteo.douban.constant.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by matteo on 2016/4/13.
 */
@Module
public class InteractorModule {
    HttpUrl baseUrl = HttpUrl.parse(Constants.DOUBAN_API_URL);

    @Provides
    @Singleton
    DoubanApi provideDoubanApi(Retrofit retrofit) {
        return retrofit.create(DoubanApi.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(StringConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
