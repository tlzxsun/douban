package org.matteo.douban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.matteo.douban.api.DoubanService;
import org.matteo.douban.bean.Top250;
import org.matteo.douban.ui.detail.MovieDetailActivity;
import org.matteo.douban.util.LogUtil;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by matteo on 2015/6/11.
 */
public class RecommendMovieFragment extends BaseFragment {

    RecyclerView mRecyclerView;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    public static RecommendMovieFragment newInstance(){
        RecommendMovieFragment fragment = new RecommendMovieFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(getActivity());
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerView.setAdapter(new RecyclerAdapter());
        return mRecyclerView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DoubanService.getDouApi().getTop250()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Top250>() {
                    @Override
                    public void call(Top250 result) {
                        LogUtil.e("top250", result.getTitle());
                    }
                });
    }

    class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
//            ProgressButton progressButton = new ProgressButton(getActivity());
//            progressButton.setLayoutParams(new RecyclerView.LayoutParams(48, 128));
//            progressButton.setBackgroundColor(Color.BLUE);
            return new ViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText("position:" + position);
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieDetailActivity.showMovieDetailActivity(getActivity());
                }
            });
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
