package org.matteo.douban.ui;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matteo on 2016/5/20.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

    List<T> items = new ArrayList<>();
    Activity activity;
    RecyclerView recyclerView;

    public BaseAdapter (Activity activity, RecyclerView recyclerView) {
        this.activity = activity;
        this.recyclerView = recyclerView;
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(T item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position, List<Object> payloads) {
//        super.onBindViewHolder(holder, position, payloads);
        holder.onBindViewHolder(holder, position, payloads);
    }
}
