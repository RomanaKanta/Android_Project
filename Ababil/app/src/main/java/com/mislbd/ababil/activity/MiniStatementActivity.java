package com.mislbd.ababil.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mislbd.ababil.R;
import com.mislbd.ababil.adapter.CustomSpinnerAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MiniStatementActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tootlbarTitle)
    TextView title;

    @Bind(R.id.acc_no)
    Spinner accSpinner;

    @OnClick(R.id.submit)
    public void submit(){
        Intent i = new Intent(MiniStatementActivity.this, StatementTableActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_statement);

        ButterKnife.bind(this);

        setActionBar();
        initTypeSpinner();

    }


    private void setActionBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        title.setText("Mini Statement");

    }

    private void initTypeSpinner() {

        // Spinner Drop down elements
        ArrayList<String> accArray = new ArrayList<String>();
        accArray.add("Account Number");
        accArray.add("XXXXXXXXXXXXXX");
        accArray.add("XXXXXXXXXXXXXX");
        accArray.add("XXXXXXXXXXXXXX");

        CustomSpinnerAdapter customSpinnerAdapter=new CustomSpinnerAdapter(this,accArray);
        accSpinner.setAdapter(customSpinnerAdapter);
        accSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:

                finish();
                overridePendingTransition(R.anim.nothing, R.anim.bottom_down);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.bottom_down);
    }
}
