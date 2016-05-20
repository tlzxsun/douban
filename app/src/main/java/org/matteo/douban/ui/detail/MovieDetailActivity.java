package org.matteo.douban.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ms.square.android.etsyblur.Blur;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.Serializable;

import org.matteo.douban.BaseActivity;
import org.matteo.douban.DoubanApplication;
import org.matteo.douban.R;
import org.matteo.douban.bean.Movie;
import org.matteo.douban.bean.Subject;
import org.matteo.douban.component.DaggerMovieDetailComponent;
import org.matteo.douban.module.MovieDetailModule;
import org.matteo.douban.request.ImageLoadUtil;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by matteo on 2015/6/12.
 */
public class MovieDetailActivity extends BaseActivity implements IMovieDetail{

    public static final String TAG = MovieDetailActivity.class.getSimpleName();

    @Bind(R.id.tool_bar)
    Toolbar mToolbar;

    @Bind(R.id.collapsing_tool_bar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Bind(R.id.iv_background)
    ImageView mIvBackground;

    @Bind(R.id.iv_cover)
    ImageView mIvCover;

    @Bind(R.id.tv_artist)
    TextView tvArtist;
    @Bind(R.id.tv_summary)
    TextView tvSummary;

    @Inject
    MovieDetailPresenter mMovieDetailPresenter;

    public static void showMovieDetailActivity(Activity activity){
        Intent intent = new Intent(activity, MovieDetailActivity.class);
        activity.startActivity(intent);
    }

    public static void showMovieDetailActivity(Activity activity, Subject subject) {
        Intent intent = new Intent(activity, MovieDetailActivity.class);
        intent.putExtra(Subject.class.getSimpleName(), (Serializable) subject);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
        initData();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void initComponent() {
        DaggerMovieDetailComponent.builder()
                .appComponent(DoubanApplication.get(this).component())
                .movieDetailModule(new MovieDetailModule(this))
                .build()
                .inject(this);
    }

    private void initData() {
        Subject subject = (Subject) getIntent().getSerializableExtra(Subject.class.getSimpleName());
        initSubject(subject);
        mMovieDetailPresenter.getMovieDetail(subject.getId());
        mMovieDetailPresenter.getMoviePhotos(subject.getId());
    }

    private void initSubject(Subject subject) {
        mCollapsingToolbarLayout.setTitle(subject.getTitle());
        ImageLoadUtil.loadImage(subject.getImages().getLarge(), new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                mIvCover.setImageBitmap(loadedImage);
                mIvBackground.setImageBitmap(Blur.apply(MovieDetailActivity.this, loadedImage));
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }

    private void initMovie(Movie movie) {
        mCollapsingToolbarLayout.setTitle(movie.getTitle());
        tvArtist.setText(movie.getArtists());
        tvSummary.setText(movie.getSummary());
        ImageLoadUtil.loadImage(movie.getImages().getLarge(), new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                mIvCover.setImageBitmap(loadedImage);
                mIvBackground.setImageBitmap(Blur.apply(MovieDetailActivity.this, loadedImage));
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }

    private void initUI() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initMovieDetail(Movie movie) {
        initMovie(movie);
    }

    @Override
    public void initMoviePhotos() {

    }
}
