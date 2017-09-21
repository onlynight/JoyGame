package com.github.onlynight.joygame.base;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.github.onlynight.joygame.R;
import com.github.onlynight.joygame.databinding.ActivityFragmentBaseBinding;

/**
 * Created by lion on 2017/9/21.
 */

public abstract class BaseVDBFragmentActivity extends BaseVDBActivity<ActivityFragmentBaseBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_fragment_base;
    }

    protected void attachFragment(BaseFragment fragment, @IdRes int frameId) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    protected void attachFragment(BaseFragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.layoutFragment, fragment);
        transaction.commit();
    }
}
