package com.mislbd.ababil.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mislbd.ababil.R;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        toolbar = (Toolbar) findViewById(R.id.toolbar) ;
//        title = (TextView) findViewById(R.id.tootlbarTitle) ;
//        setActionBar();

//        register = (Button) findViewById(R.id.registre);
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegisterActivity.this, VarifyActivity.class);
//                startActivity(i);
//                overridePendingTransition(R.anim.push_left_in,
//                        R.anim.push_left_out);
//                finish();
//            }
//        });
    }

//    private void setActionBar() {
//
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("");
//
//        title.setText("Registration");
//    }

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
