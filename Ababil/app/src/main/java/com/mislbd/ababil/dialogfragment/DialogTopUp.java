package com.mislbd.ababil.dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.mislbd.ababil.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogTopUp extends DialogFragment {

    @OnClick(R.id.close)
    public void closeDialog() {
        dismiss();
    }



    @OnClick(R.id.done)
    public void done(){
        dismiss();
    }

    public void onResume() {
        super.onResume();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay()
                .getMetrics(displaymetrics);
        int ht = displaymetrics.heightPixels;
        getDialog().getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = getDialog().getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = (int) ht;
        getDialog().getWindow().setAttributes(lp);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_top_up, container,
                false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(
                android.R.color.white);
        getDialog().getWindow().setGravity(Gravity.CENTER);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.AnimationBottomUpDown;

        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
