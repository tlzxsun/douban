package org.matteo.douban.ui;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.matteo.douban.R;
import org.matteo.douban.bean.Subject;
import org.matteo.douban.ui.detail.MovieDetailActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by matteo on 2016/5/20.
 */
public class MovieListAdapter extends BaseAdapter<Subject>{


    public MovieListAdapter(Activity activity, RecyclerView recyclerView) {
        super(activity, recyclerView);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBindViewHolder(holder, position, null);
    }

    class ViewHolder extends BaseViewHolder{

        @Bind(R.id.iv_image)
        SimpleDraweeView image;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_actor)
        TextView tvActor;
        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position, List<Object> payloads) {
            Subject subject = getItem(position);
            image.setImageURI(Uri.parse(subject.getImages().getLarge()));
            tvTitle.setText(subject.getTitle());
        }

        @Override
        public void onItemClick() {
            super.onItemClick();
            MovieDetailActivity.showMovieDetailActivity(activity, getItem(getAdapterPosition()));
        }
    }
}
