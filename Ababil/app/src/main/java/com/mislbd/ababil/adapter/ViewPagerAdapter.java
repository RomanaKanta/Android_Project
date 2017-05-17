package com.mislbd.ababil.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mislbd.ababil.fragment.FragmentReport;

import java.util.ArrayList;

/**
 * Created by tanvir-android on 8/11/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String > tabItemsTitle ;
    Context context;

    public ViewPagerAdapter(Context context,FragmentManager fragmentManager, ArrayList<String > ItemsTitle) {
        super(fragmentManager);
        this.context = context;
        this.tabItemsTitle = ItemsTitle;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return tabItemsTitle.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {

        if (position==0) {
            return FragmentReport.newInstance();
        }else if (position==1){
            return FragmentReport.newInstance();
        }else if (position==2){
            return FragmentReport.newInstance();
        }else {
            return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return tabItemsTitle.get(position);
//        Typeface font = Typeface.createFromAsset(context.getAssets(), "font/Lato-Bold.ttf");
//        String title = tabItemsTitle[position];
//
//        SpannableString styled = new SpannableString(title);
//        styled.setSpan(new CustomTypefaceSpan("" , font), 0, styled.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//
//        return styled;

    }

}
