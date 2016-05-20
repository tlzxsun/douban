package org.matteo.douban.api;


import android.content.Context;
import android.content.SharedPreferences;

import org.matteo.douban.DoubanApplication;
import org.matteo.douban.bean.User;

/**
 * Created by matteo on 2016/5/6.
 */
public class UserManager {

    public static final String TAG = UserManager.class.getSimpleName();

    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String douban_user_id;
    private String douban_user_name;

    private User user;
    private SharedPreferences token;

    public UserManager(DoubanApplication application) {
        token = application.getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    public void saveToken(String access_token, String refresh_token) {
        token.edit().putString("access_token", access_token).putString("refresh_token", refresh_token).commit();
    }

}
