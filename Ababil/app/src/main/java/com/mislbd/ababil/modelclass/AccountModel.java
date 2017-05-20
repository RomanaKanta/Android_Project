package com.mislbd.ababil.modelclass;

/**
 * Created by tanvir-android on 10/4/16.
 */
public class AccountModel {

    String title;
    Integer icon;
    String count;

    public AccountModel(Integer icon, String title, String count) {
        this.icon = icon;
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
