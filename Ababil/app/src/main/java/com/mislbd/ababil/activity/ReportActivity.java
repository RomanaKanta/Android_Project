package com.mislbd.ababil.activity;

import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.mislbd.ababil.R;
import com.mislbd.ababil.adapter.ViewPagerAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ReportActivity extends AppCompatActivity {



    @Bind(R.id.pager)
    ViewPager viewPager;

    @Bind(R.id.sliding_tab)
    SlidingTabLayout tabLayout;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tootlbarTitle)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);

        setActionBar();

        ArrayList<String> tabItemsTitle = new ArrayList<>();
        tabItemsTitle.add("Daily");
        tabItemsTitle.add("Weekly");
        tabItemsTitle.add("Monthly");

        setTabLayer(tabItemsTitle);

    }
    private void setActionBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        title.setText("Report");
    }

    private void setTabLayer(ArrayList<String> tabItemsTitle) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(ReportActivity.this, getSupportFragmentManager(), tabItemsTitle);
        viewPager.setAdapter(adapter);

        tabLayout.setViewPager(viewPager);
        tabLayout.setCurrentTab(1);
        changeTabsFont(tabLayout);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:

                finish();
                overridePendingTransition(R.anim.nothing, R.anim.push_right_in);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.push_right_in);
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
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(this.getAssets(), "font/ROBOTO-REGULAR.TTF"));
                }
            }
        }
    }
}
