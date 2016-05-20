package org.matteo.douban.request;

import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.matteo.douban.DoubanApplication;

/**
 * Created by matteo on 2015/6/25.
 */
public class ImageLoadUtil {

    public static void init(Context context){
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .diskCache(new UnlimitedDiscCache(context.getExternalCacheDir()))
                .build();
        ImageLoader.getInstance().init(configuration);
    }

    public static void loadImage(String url, ImageLoadingListener listener){
        ImageLoader.getInstance().loadImage(url, listener);
    }
}
