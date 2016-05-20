package org.matteo.douban;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONException;
import org.json.JSONObject;
import org.matteo.douban.bean.Movie;
import org.matteo.douban.component.AppComponent;
import org.matteo.douban.constant.Constants;
import org.matteo.douban.util.LogUtil;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by matteo on 2015/6/11.
 */
public class LoginActivity extends BaseActivity {

    public static final String TAG = LoginActivity.class.getSimpleName();

    @Bind(R.id.webview)
    WebView mWebView;
    @Bind(R.id.tool_bar)
    Toolbar mToolbar;

    public static void showLoginActivity(Activity activity){
        Uri uri = Uri.parse("https://www.douban.com/service/auth2/auth")
                .buildUpon().appendQueryParameter("client_id", Constants.API_KEY)
                .appendQueryParameter("redirect_uri", Constants.REDIRECT_URL)
                .appendQueryParameter("response_type", "code").build();
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra("url", uri.toString());
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initComponent() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initUI() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                LogUtil.d(TAG, url);
                if(url.startsWith(Constants.REDIRECT_URL)){
                    String code = Uri.parse(url).getQueryParameter("code");
                    String error = Uri.parse(url).getQueryParameter("error");
                    if(TextUtils.isEmpty(error)) {
                        showProgressDialog("login..");
                        Uri uri = Uri.parse(Constants.DOUBAN_OAUTH2_URL).buildUpon()
                                .appendPath("token")
                                .appendQueryParameter("client_id", Constants.API_KEY)
                                .appendQueryParameter("client_secret", Constants.APE_SECRET)
                                .appendQueryParameter("redirect_uri", Constants.REDIRECT_URL)
                                .appendQueryParameter("grant_type", "authorization_code")
                                .appendQueryParameter("code", code).build();
                        DoubanApplication.get(LoginActivity.this).component().getDoubanApi()
                                .token(uri.toString())
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Action1<String>() {
                                    @Override
                                    public void call(String string) {
                                        try {
                                            JSONObject result = new JSONObject(string);
                                            String access_token = result.optString("access_token");
                                            String refresh_token = result.optString("refresh_token");
                                            if(!TextUtils.isEmpty(access_token) && !TextUtils.isEmpty(refresh_token)) {
                                                DoubanApplication.get(LoginActivity.this).userManager().saveToken(access_token, refresh_token);
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        dismissProgressDialog();
                                    }
                                }, new Action1<Throwable>() {
                                    @Override
                                    public void call(Throwable throwable) {
                                        throwable.printStackTrace();
                                        dismissProgressDialog();
                                    }
                                });
                    }
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        mWebView.loadUrl(getIntent().getStringExtra("url"));
    }
}
