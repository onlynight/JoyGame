package com.github.onlynight.joygame;

import com.github.onlynight.joygame.base.BaseVDBTemplateAdapter;
import com.github.onlynight.joygame.data.AppBarData;
import com.github.onlynight.joygame.databinding.ItemAppBarViewBinding;

/**
 * Created by lion on 2017/9/21.
 */

public class AppBarAdapter extends BaseVDBTemplateAdapter<AppBarData, ItemAppBarViewBinding> {

    @Override
    protected void onBind(ViewHolder<ItemAppBarViewBinding> holder, int position) {
        AppBarData data = mData.get(position);
        ItemAppBarViewBinding dataBinding = holder.dataBinding;
        dataBinding.imgIcon.setImageResource(data.getIconRes());
        dataBinding.textTitle.setText(data.getTitle());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_app_bar_view;
    }

}
