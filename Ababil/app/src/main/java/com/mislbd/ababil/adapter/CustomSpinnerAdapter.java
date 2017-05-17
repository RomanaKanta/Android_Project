package com.mislbd.ababil.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;

import com.mislbd.ababil.R;
import com.mislbd.ababil.widget.AppTextViewRegular;

import java.util.ArrayList;

/**
 * Created by Romana on 5/4/17.
 */
public class CustomSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    private final Context activity;
    private ArrayList<String> asr;

    public CustomSpinnerAdapter(Context context,ArrayList<String> asr) {
        this.asr=asr;
        activity = context;
    }



    public int getCount()
    {
        return asr.size();
    }

    public Object getItem(int i)
    {
        return asr.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }



    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        AppTextViewRegular txt = new AppTextViewRegular(activity);
        txt.setPadding(20, 20, 20, 20);
        txt.setTextSize(18);
        txt.setGravity(Gravity.CENTER_VERTICAL);
        txt.setText(asr.get(position));
        txt.setTextColor(Color.parseColor("#ffffff"));
        return  txt;
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        AppTextViewRegular txt = new AppTextViewRegular(activity);
        txt.setGravity(Gravity.CENTER);
//        txt.setPadding(16, 16, 16, 16);
        txt.setTextSize(18);
        txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_keyboard_arrow_down_white_24dp, 0);
        txt.setText(asr.get(i));
        txt.setTextColor(Color.parseColor("#ffffff"));
        return  txt;
    }

}