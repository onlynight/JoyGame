package com.github.onlynight.joygame.base;

import android.databinding.ViewDataBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lion on 2017/9/21.
 */

public abstract class BaseVDBTemplateAdapter<Model, VDB extends ViewDataBinding> extends BaseVDBAdapter<VDB> {

    protected List<Model> mData;

    public BaseVDBTemplateAdapter() {
        mData = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addData(Model data) {
        if (mData != null) {
            mData.add(data);
        }
    }

    public void setData(List<Model> data) {
        mData = data;
    }

    public void clearData() {
        if (mData != null) {
            mData.clear();
        }
    }
}
