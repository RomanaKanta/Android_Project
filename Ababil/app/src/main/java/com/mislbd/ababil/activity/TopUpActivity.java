package com.mislbd.ababil.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.mislbd.ababil.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopUpActivity extends AppCompatActivity {

    @OnClick(R.id.btn_back)
    public void close(){
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.bottom_down);
    }

    @OnClick(R.id.btn_done)
    public void done(){
        finish();
        overridePendingTransition(R.anim.zoom_enter,
                R.anim.zoom_exit);
    }

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tootlbarTitle)
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        ButterKnife.bind(this);

        setActionBar();
    }


    private void setActionBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        title.setText("Mobile Top-Up");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:

                finish();
                overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
    }
}
