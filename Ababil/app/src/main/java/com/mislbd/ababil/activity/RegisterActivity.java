package com.mislbd.ababil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mislbd.ababil.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @Bind(R.id.backgroundImage)
    ImageView bgImage;

    @OnClick(R.id.btn_next)
    public void Next() {
        Intent i = new Intent(RegisterActivity.this, VarifyActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
    }

    @OnClick(R.id.go_sign_in)
    public void gotoSignUp() {
        finish();
        overridePendingTransition(R.anim.grow_from_middle, R.anim.shrink_to_middle);
    }

    @OnClick(R.id.back)
    public void back() {
        finish();
        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

//        String backgroundUrl = "https://www.w3schools.com/css/img_forest.jpg";
//
//        setBackground(backgroundUrl);


    }

    private void setBackground(String backgroundUrl) {
        if (backgroundUrl != null && !TextUtils.isEmpty(backgroundUrl)) {

            Glide
                    .with(this)
                    .load(backgroundUrl)
                    .placeholder(R.drawable.wall01)
                    .centerCrop()
                    .into(bgImage);
        }

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
