package com.github.onlynight.appbarview;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

/**
 * Created by lion on 2017/9/21.
 */

public class AppBarView extends LinearLayout {

    private BaseAdapter mAdapter;

    private DataSetObserver mDataSetObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setAdapter(mAdapter);
        }

        @Override
        public void onInvalidated() {
            super.onInvalidated();
        }
    };

    public AppBarView(Context context) {
        super(context);
        initView();
    }

    public AppBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AppBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @RequiresApi(21)
    public AppBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public void setAdapter(BaseAdapter adapter) {
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }

        this.mAdapter = adapter;

        if (mAdapter != null) {
            mAdapter.registerDataSetObserver(mDataSetObserver);
        }

        if (mAdapter != null) {
            removeAllViews();
            int count = mAdapter.getCount();
            for (int i = 0; i < count; i++) {
                View itemView = mAdapter.getView(i, null, this);
                addView(itemView);
            }
        }

        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int count = mAdapter.getCount();
        int width = (int) (MeasureSpec.getSize(widthMeasureSpec) / (float) count);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        for (int i = 0; i < count; i++) {
            View itemView = getChildAt(i);
            ViewGroup.LayoutParams params = itemView.getLayoutParams();
            params.width = width;
            params.height = height;
            itemView.setLayoutParams(params);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int left = 0;
        int top = 0;

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            MarginLayoutParams layoutParams =
                    (MarginLayoutParams) child.getLayoutParams();

            int width = child.getMeasuredWidth() + layoutParams.leftMargin
                    + layoutParams.rightMargin;
            int height = child.getMeasuredHeight() + layoutParams.topMargin
                    + layoutParams.bottomMargin;
            child.layout(left, top, left + width, top + height);
            left += width;
        }
    }
}
