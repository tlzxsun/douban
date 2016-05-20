package org.matteo.douban.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by matteo on 2016/5/20.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick();
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClick();
                return true;
            }
        });
    }

    public abstract void onBindViewHolder(BaseViewHolder holder, int position, List<Object> payloads);

    public void onItemClick() {

    }

    public void onItemLongClick() {

    }
}
