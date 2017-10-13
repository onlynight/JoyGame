package com.github.onlynight.joygame.module.main;

import com.github.onlynight.joygame.base.BaseVDBFragmentActivity;
import com.github.onlynight.joygame.databinding.ActivityFragmentBaseBinding;

public class MainActivity extends BaseVDBFragmentActivity {

    private MainFragment mFragment;

    @Override
    protected void onBind(ActivityFragmentBaseBinding dataBinding) {
        mFragment = new MainFragment();
        attachFragment(mFragment);
    }

}
