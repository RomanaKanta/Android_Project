package com.mislbd.ababil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VarifyActivity extends AppCompatActivity {

    @OnClick(R.id.btn_done)
    public void done(){
        Intent i = new Intent(VarifyActivity.this, MainActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
    }

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tootlbarTitle)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varify);

        ButterKnife.bind(this);
        setActionBar();
    }

    private void setActionBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        title.setText("Verification");
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
