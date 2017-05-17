package com.mislbd.ababil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mislbd.ababil.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {
   
    @Bind(R.id.backgroundImage)
    ImageView bgImage;

    @OnClick(R.id.register)
    public void register(){
        Intent i = new Intent(SignInActivity.this, RegisterActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.grow_from_middle,R.anim.shrink_to_middle);
    }

    @OnClick(R.id.sign_in)
    public void signIn(){
        Intent i = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.bottom_up, R.anim.nothing);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sing_in);

        ButterKnife.bind(this);

//        String backgroundUrl = "https://www.w3schools.com/css/img_forest.jpg";
//        setBackground(backgroundUrl);


    }

    private void setBackground( String backgroundUrl){
        if (backgroundUrl != null && !TextUtils.isEmpty(backgroundUrl)) {

            Glide
                    .with(this)
                    .load(backgroundUrl)
                    .placeholder(R.drawable.wall01)
                    .centerCrop()
                    .into(bgImage);
        }

    }
    }
