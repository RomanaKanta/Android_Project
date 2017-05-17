package com.mislbd.ababil.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mislbd.ababil.R;
import com.mislbd.ababil.utils.FaceView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VarifyActivity extends AppCompatActivity {

    @Bind(R.id.backgroundImage)
    ImageView bgImage;

    @OnClick(R.id.go_sign_in)
    public void gotoSignUp(){
        Intent i = new Intent(VarifyActivity.this, SignInActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @OnClick(R.id.sign_up)
    public void signUp(){
        Intent i = new Intent(VarifyActivity.this, MainActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition(R.anim.zoom_enter,
                R.anim.zoom_exit);
    }

    @OnClick(R.id.btn_back)
    public  void back(){
        finish();
        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
    }

    @Bind(R.id.faceView)
    FaceView faceView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varify);

        ButterKnife.bind(this);

        faceView.startAnim();


//        String backgroundUrl = "https://www.w3schools.com/css/img_forest.jpg";
//
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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
    }

}
