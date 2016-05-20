package org.matteo.douban.request;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by matteo on 2015/4/7.
 */
public class GsonUtil {
    private static Gson mGson = new Gson();

    public static <T>T fromJson(String json, Type type){
        return mGson.fromJson(json, type);
    }

    public static String toJson(Object object) {
        return mGson.toJson(object);
    }
}
