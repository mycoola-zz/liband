package com.liband.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.liband.interfaces.adapterViewModel;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

class AppAdapter<T extends adapterViewModel> extends RecyclerView.Adapter<AppAdapter.ViewHolder> {

    private final List<? extends T> list;

    public AppAdapter(List<? extends T> list) {
        this.list = list;
    }

    public static class ViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {
        private final V v;

        ViewHolder(V v) {
            super(v.getRoot());
            this.v = v;
        }

        V getBinding() {
            return v;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).layoutId();
    }

    @Override
    public AppAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding bind = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
        return new ViewHolder<>(bind);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final T model = list.get(position);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}