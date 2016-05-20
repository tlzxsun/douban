package org.matteo.douban.ui.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import org.matteo.douban.BaseActivity;
import org.matteo.douban.DoubanApplication;
import org.matteo.douban.R;
import org.matteo.douban.bean.Subject;
import org.matteo.douban.component.DaggerMovieSearchComponent;
import org.matteo.douban.module.MovieSearchModule;
import org.matteo.douban.ui.MovieListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by matteo on 2016/5/19.
 */
public class SearchActivity extends BaseActivity implements IMovieSearch{

    @Bind(R.id.tool_bar)
    Toolbar toolbar;
    @Bind(R.id.search_view)
    SearchView searchView;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    MovieListAdapter adapter;
    @Inject
    MovieSearchPresenter movieSearchPresenter;

    public static void showSearchActivity(Activity activity, View view) {
        Intent intent = new Intent(activity, SearchActivity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                view, "search");
        activity.startActivity(intent, activityOptions.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchView.onActionViewExpanded();
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                finish();
                return true;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                movieSearchPresenter.search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MovieListAdapter(this, recyclerView);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_search;
    }

    @Override
    protected void initComponent() {
        DaggerMovieSearchComponent.builder()
                .appComponent(DoubanApplication.get(this).component())
                .movieSearchModule(new MovieSearchModule(this))
                .build()
                .inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();;
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSearchResult(List<Subject> subjects) {
        adapter.setItems(subjects);
    }
}
