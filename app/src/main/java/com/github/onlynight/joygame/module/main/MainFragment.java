package com.github.onlynight.joygame.module.main;

import android.support.design.widget.TabLayout;

import com.github.onlynight.joygame.R;
import com.github.onlynight.joygame.base.BaseVDBFragment;
import com.github.onlynight.joygame.databinding.FragmentMainBinding;
import com.github.onlynight.joygame.module.main.adapter.MainFragmentAdapter;

/**
 * Created by lion on 2017/9/21.
 */

public class MainFragment extends BaseVDBFragment<FragmentMainBinding> implements TabLayout.OnTabSelectedListener {

    private MainFragmentAdapter mPagerAdapter;

    @Override
    protected void onBind(FragmentMainBinding dataBinding) {
        initToolbar(dataBinding, false);
        setTitle("Home");

        mPagerAdapter = new MainFragmentAdapter(getChildFragmentManager());
        dataBinding.viewPager.setAdapter(mPagerAdapter);

        dataBinding.bottomTabLayout.addOnTabSelectedListener(this);
    }

    private void changePage(int page) {
        mDataBinding.viewPager.setCurrentItem(page);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        changePage(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
}
