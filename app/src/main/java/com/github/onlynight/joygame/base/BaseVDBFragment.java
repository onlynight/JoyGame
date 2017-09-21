package com.github.onlynight.joygame.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.onlynight.joygame.R;

/**
 * Created by lion on 2017/9/21.
 */

public abstract class BaseVDBFragment<VDB extends ViewDataBinding> extends BaseFragment {

    protected VDB mDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        onBind(mDataBinding);
        return mDataBinding.getRoot();
    }

    protected abstract void onBind(VDB dataBinding);

    protected void initToolbar(VDB dataBinding) {
        initToolbar(dataBinding, true);
    }

    protected void initToolbar(VDB dataBinding, boolean setDisplayAsHome) {
        Toolbar toolbar = dataBinding.getRoot().findViewById(R.id.toolbar);

        if (toolbar != null) {
            ((AppCompatActivity) (getActivity())).setSupportActionBar(toolbar);
            if (setDisplayAsHome) {
                ((AppCompatActivity) (getActivity())).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    protected void setTitle(String title) {
        getActivity().setTitle(title);
    }

    protected abstract int getLayoutRes();

}
