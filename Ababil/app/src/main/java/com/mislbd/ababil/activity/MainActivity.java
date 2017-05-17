package com.mislbd.ababil.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import com.mislbd.ababil.R;
import com.mislbd.ababil.adapter.CustomSpinnerAdapter;
import com.mislbd.ababil.adapter.ExpandableListAdapter;
import com.mislbd.ababil.fragment.FragmentDashBoard;
import com.mislbd.ababil.modelclass.MenuModel;
import com.mislbd.ababil.widget.AnimatedExpandableListView;
import com.mislbd.ababil.widget.CustomTypefaceSpan;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.nav_view)
    NavigationView navigationView;

    @Bind(R.id.dashboard)
    Spinner typeSpinner;

    @Bind(R.id.navList)
    AnimatedExpandableListView mExpandableListView;

    private ExpandableListAdapter mExpandableListAdapter;
    private ArrayList<MenuModel> mExpandableListHeader;
    private HashMap<MenuModel, ArrayList<String>> mExpandableListChild;


    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();
        setAppBar();
        initTypeSpinner();

        setFragment(R.string.fav, new FragmentDashBoard());
    }


    private void setFragment(int pageTitle, Fragment fragment) {

//        title.setText(pageTitle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }

    private void setAppBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

//        title.setText(R.string.dash);


        prepareListData();
        addDrawerItems();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


    }

    private void initTypeSpinner() {

        // Spinner Drop down elements
        ArrayList<String> languages = new ArrayList<String>();
        languages.add("Dashboard");
        languages.add("Account 1");
        languages.add("Account 2");
        languages.add("Account 3");

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this, languages);
        typeSpinner.setAdapter(customSpinnerAdapter);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

//                Toast.makeText(parent.getContext(), "Android Custom Spinner Example Output..." + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
            overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);

        }
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(),
                "font/ROBOTO-REGULAR.TTF");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }


    /*
    * Preparing the list data
    */
    private void prepareListData() {


        mExpandableListHeader = new ArrayList<MenuModel>();
        mExpandableListChild = new HashMap<MenuModel, ArrayList<String>>();

        // Adding child data
        mExpandableListHeader.add(new MenuModel("REPORT", 0));
        mExpandableListHeader.add(new MenuModel("TOOLS", 0));
        mExpandableListHeader.add(new MenuModel("SETTINGS", 0));
        mExpandableListHeader.add(new MenuModel("GET CONNECTED", 0));
        mExpandableListHeader.add(new MenuModel("LOGOUT", R.mipmap.ic_power_settings_new_white_24dp));


        // Adding child data
        ArrayList<String> report = new ArrayList<String>();
        report.add("Daily Report");
        report.add("Monthly Report");
        report.add("Trends");

        ArrayList<String> toolArray = new ArrayList<String>();
        toolArray.add("Loan Calculator");
        toolArray.add("ATM Calculator");

        ArrayList<String> settingArray = new ArrayList<String>();
        settingArray.add("Primary Account");
        settingArray.add("Layout");
        settingArray.add("Security");

        ArrayList<String> connectArray = new ArrayList<String>();
        connectArray.add("Call Customer Care");
        connectArray.add("Application Form");
        connectArray.add("Give Feedback");


        mExpandableListChild.put(mExpandableListHeader.get(0), report);
        mExpandableListChild.put(mExpandableListHeader.get(1), toolArray); // Header, Child data
        mExpandableListChild.put(mExpandableListHeader.get(2), settingArray);
        mExpandableListChild.put(mExpandableListHeader.get(3), connectArray);
        mExpandableListChild.put(mExpandableListHeader.get(4), new ArrayList<String>());
    }

    private void addDrawerItems() {

        mExpandableListAdapter = new ExpandableListAdapter(this, mExpandableListHeader, mExpandableListChild);
        mExpandableListView.setAdapter(mExpandableListAdapter);
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (mExpandableListChild.get(mExpandableListHeader.get(groupPosition))
                        .size() == 0) {

                    drawer.closeDrawer(GravityCompat.START);

                    Intent i = new Intent(MainActivity.this, SignInActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.zoom_enter,
                            R.anim.zoom_exit);

                } else {

                    if (mExpandableListView.isGroupExpanded(groupPosition)) {
                        mExpandableListView.collapseGroupWithAnimation(groupPosition);
                    } else {
                        mExpandableListView.expandGroupWithAnimation(groupPosition);
                    }
                }
                return true;
            }
        });


        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String selectedItem = ((ArrayList) (mExpandableListChild.get(mExpandableListHeader.get(groupPosition))))
                        .get(childPosition).toString();
//                Toast.makeText(HomeActivity.this, "" + selectedItem, Toast.LENGTH_SHORT).show();

                drawer.closeDrawer(GravityCompat.START);

                if (groupPosition == 0) {

                    Intent i = new Intent(MainActivity.this, ReportActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.zoom_enter,
                            R.anim.push_left_out);
                }

                return false;
            }
        });
    }
}
