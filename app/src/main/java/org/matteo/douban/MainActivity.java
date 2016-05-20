package org.matteo.douban;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.matteo.douban.ui.search.SearchActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    List<String> mPageTitles;

    ImageView mIvAvatar;
    TextView mTvNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void initView() {

        mPageTitles = new ArrayList<>();
        mPageTitles.add(getString(R.string.now_playing));
        mPageTitles.add(getString(R.string.weekly));

        mToolbar = (Toolbar) this.findViewById(R.id.tool_bar);
        mDrawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.abc_action_bar_home_description, R.string.abc_action_bar_home_description);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) this.findViewById(R.id.navigation_view);
        mIvAvatar = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.iv_avatar);
        mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.showLoginActivity(MainActivity.this);
            }
        });
        mTvNickname = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.tv_nickname);
        mTabLayout = (TabLayout) this.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) this.findViewById(R.id.view_pager);
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        setSupportActionBar(mToolbar);

        mNavigationView.setNavigationItemSelectedListener(naviListener);
        mTabLayout.addTab(mTabLayout.newTab().setText(mPageTitles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mPageTitles.get(1)));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private NavigationView.OnNavigationItemSelectedListener naviListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_info_details:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.menu_share:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.menu_agenda:
                    mViewPager.setCurrentItem(2);
                    break;
            }
            mDrawerLayout.closeDrawer(mNavigationView);
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_info_details:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.menu_share:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.menu_agenda:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.search:
                SearchActivity.showSearchActivity(MainActivity.this, mToolbar);
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return Top250Fragment.newInstance();
            }
            return RecommendMovieFragment.newInstance();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mPageTitles.get(position);
        }

        @Override
        public int getCount() {
            return mPageTitles.size();
        }
    }
}
