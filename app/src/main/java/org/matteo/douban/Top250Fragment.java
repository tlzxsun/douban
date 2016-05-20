package org.matteo.douban;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.matteo.douban.api.DoubanService;
import org.matteo.douban.bean.Subject;
import org.matteo.douban.bean.Top250;
import org.matteo.douban.ui.detail.MovieDetailActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by matteo on 2015/6/11.
 */
public class Top250Fragment extends BaseFragment {

    RecyclerView mRecyclerView;
    RecyclerAdapter mRecyclerAdapter;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    public static Top250Fragment newInstance(){
        Top250Fragment fragment = new Top250Fragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(getActivity());
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerAdapter = new RecyclerAdapter();
        mRecyclerView.setAdapter(mRecyclerAdapter);
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
                        mRecyclerAdapter.setSubjects(result.getSubjects());
                    }
                });
    }

    class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{

        public Subject[] subjects = new Subject[]{};

        public void setSubjects(Subject[] subjects) {
            this.subjects = subjects;
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.item_movie_grid, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Subject subject = getItem(position);
            holder.tvTitle.setText(subject.getTitle());
            holder.ivImage.setImageURI(Uri.parse(subject.getImages().getLarge()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieDetailActivity.showMovieDetailActivity(getActivity(), subject);
                }
            });
        }

        @Override
        public int getItemCount() {
            return subjects.length;
        }

        public Subject getItem(int position) {
            return subjects[position];
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView ivImage;
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = (SimpleDraweeView) itemView.findViewById(R.id.iv_image);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
