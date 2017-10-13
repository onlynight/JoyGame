package com.github.onlynight.joygame.module.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.github.onlynight.joygame.module.game.GameFragment;
import com.github.onlynight.joygame.module.me.MeFragment;
import com.github.onlynight.joygame.module.news.NewsFragment;
import com.github.onlynight.joygame.module.talk.TalkFragment;

/**
 * Created by lion on 2017/10/11.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private Fragment[] mFragments = {new NewsFragment(), new TalkFragment(),
            new GameFragment(), new MeFragment()};

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

}
