package com.github.onlynight.joygame.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

/**
 * Created by lion on 2017/4/10.
 */

public abstract class BaseVDBActivity<VDB extends ViewDataBinding> extends BaseActivity {

    protected VDB mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        onBind(mDataBinding);
    }

    protected abstract void onBind(VDB dataBinding);

    @LayoutRes
    public abstract int getLayoutRes();
}
