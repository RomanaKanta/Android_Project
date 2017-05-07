package com.mislbd.ababil.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.mislbd.ababil.R;
import com.mislbd.ababil.adapter.ViewPagerAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FragmentHome extends Fragment {

    @Bind(R.id.pager)
    ViewPager viewPager;

    @Bind(R.id.sliding_tab)
    SlidingTabLayout tabLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragmentView = inflater.inflate(R.layout.fragment_home,
                container, false);

        ButterKnife.bind(this, myFragmentView);

        ArrayList<String> tabItemsTitle = new ArrayList<>();
        tabItemsTitle.add(getActivity().getString(R.string.fav));
        tabItemsTitle.add(getActivity().getString(R.string.transfer));
        tabItemsTitle.add(getActivity().getString(R.string.bill_pay));

        setTabLayer(tabItemsTitle);

        return myFragmentView;
    }

    private void setTabLayer(ArrayList<String> tabItemsTitle) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), getChildFragmentManager(), tabItemsTitle);
        viewPager.setAdapter(adapter);

        tabLayout.setViewPager(viewPager);
        changeTabsFont(tabLayout);

    }

    private void changeTabsFont(SlidingTabLayout tabLayout) {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int k = 0; k < tabChildsCount; k++) {
                View tabViewChild = vgTab.getChildAt(k);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/ROBOTO-REGULAR.TTF"));
                }
            }
        }
    }
}
