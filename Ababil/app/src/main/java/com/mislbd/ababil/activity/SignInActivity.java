package com.mislbd.ababil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mislbd.ababil.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {


    @OnClick(R.id.register)
    public void register(){
        Intent i = new Intent(SignInActivity.this, RegisterActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sing_in);

        ButterKnife.bind(this);

    }



    @Override
    public void onBackPressed() {

            finish();
            overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);

    }


}
