package com.mislbd.ababil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.mislbd.ababil.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingUpActivity extends AppCompatActivity {

@OnClick(R.id.btn_login)
public void login(){
    Intent i = new Intent(SingUpActivity.this, LoginActivity.class);
    startActivity(i);
    overridePendingTransition(R.anim.push_left_in,
            R.anim.push_left_out);
}


    @OnClick(R.id.btn_reg)
    public void register(){
        Intent i = new Intent(SingUpActivity.this, RegisterActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sing_up);

        ButterKnife.bind(this);

    }



    @Override
    public void onBackPressed() {

            finish();
            overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);


    }


}
