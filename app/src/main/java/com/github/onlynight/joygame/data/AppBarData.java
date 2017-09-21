package com.github.onlynight.joygame.data;

/**
 * Created by lion on 2017/9/21.
 */

public class AppBarData {

    private int iconRes = -1;
    private String title;

    public AppBarData() {
    }

    public AppBarData(int iconRes, String title) {
        this.iconRes = iconRes;
        this.title = title;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
