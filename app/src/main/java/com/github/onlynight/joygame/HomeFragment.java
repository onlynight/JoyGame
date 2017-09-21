package com.github.onlynight.joygame;

import com.github.onlynight.joygame.base.BaseVDBFragment;
import com.github.onlynight.joygame.data.AppBarData;
import com.github.onlynight.joygame.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lion on 2017/9/21.
 */

public class HomeFragment extends BaseVDBFragment<FragmentHomeBinding> {

    private List<AppBarData> mAppBarData;
    private AppBarAdapter mAdapter;

    @Override
    protected void onBind(FragmentHomeBinding dataBinding) {
        initToolbar(dataBinding, false);
        setTitle("Home");

        mAppBarData = new ArrayList<>();

        AppBarData home = new AppBarData();
        home.setIconRes(R.mipmap.ic_launcher);
        home.setTitle("资讯");
        mAppBarData.add(home);

        AppBarData community = new AppBarData();
        community.setIconRes(R.mipmap.ic_launcher);
        community.setTitle("社区");
        mAppBarData.add(community);

        AppBarData game = new AppBarData();
        game.setIconRes(R.mipmap.ic_launcher);
        game.setTitle("游戏");
        mAppBarData.add(game);

        AppBarData me = new AppBarData();
        me.setIconRes(R.mipmap.ic_launcher);
        me.setTitle("我的");
        mAppBarData.add(me);

        mAdapter = new AppBarAdapter();
        mAdapter.setData(mAppBarData);

        dataBinding.appBarView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

}
