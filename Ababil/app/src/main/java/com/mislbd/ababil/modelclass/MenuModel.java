package com.mislbd.ababil.modelclass;

/**
 * Created by tanvir-android on 10/4/16.
 */
public class MenuModel {

    String title;
    Integer icon;

    public MenuModel(String title, Integer icon) {
        this.title = title;
        this.icon = icon;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
