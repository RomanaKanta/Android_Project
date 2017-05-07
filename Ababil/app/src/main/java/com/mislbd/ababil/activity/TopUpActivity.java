package com.mislbd.ababil.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mislbd.ababil.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopUpActivity extends AppCompatActivity {

    @OnClick(R.id.close)
    public void close(){
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.bottom_down);
    }

    @OnClick(R.id.done)
    public void done(){
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.bottom_down);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.bottom_down);
    }
}
