package com.github.onlynight.joygame.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by lion on 2017/9/21.
 */

public abstract class BaseVDBAdapter<VDB extends ViewDataBinding> extends BaseAdapter {

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder<VDB> holder = null;
        if (view == null) {
            holder = new ViewHolder<>();
            holder.dataBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(viewGroup.getContext()), getLayoutRes(), viewGroup, false);
            view = holder.dataBinding.getRoot();
            view.setTag(holder);
        } else {
            holder = (ViewHolder<VDB>) view.getTag();
            view = holder.dataBinding.getRoot();
        }
        onBind(holder, i);
        return view;
    }

    protected abstract void onBind(ViewHolder<VDB> holder, int position);

    protected abstract int getLayoutRes();

    protected class ViewHolder<T> {
        public T dataBinding;
    }
}
