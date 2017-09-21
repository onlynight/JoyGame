package com.github.onlynight.joygame;

import com.github.onlynight.joygame.base.BaseVDBFragmentActivity;
import com.github.onlynight.joygame.databinding.ActivityFragmentBaseBinding;

public class MainActivity extends BaseVDBFragmentActivity {

    private HomeFragment mFragment;

    @Override
    protected void onBind(ActivityFragmentBaseBinding dataBinding) {
        mFragment = new HomeFragment();
        attachFragment(mFragment);
    }

}
