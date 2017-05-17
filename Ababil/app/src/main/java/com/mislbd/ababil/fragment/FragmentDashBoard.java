package com.mislbd.ababil.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.mislbd.ababil.R;
import com.mislbd.ababil.activity.CommonInputActivity;
import com.mislbd.ababil.activity.MiniStatementActivity;
import com.mislbd.ababil.activity.TopUpActivity;
import com.mislbd.ababil.adapter.HistoryListAdapter;
import com.mislbd.ababil.modelclass.HistoryItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentDashBoard extends Fragment {

    @Bind(R.id.recycler_view)
    RecyclerView historyList;

    @Bind(R.id.backgroundImage)
    ImageView bgImage;

    @Bind(R.id.balance_layer)
    RelativeLayout balanceLayer;

    @OnClick(R.id.top_up)
    public void topUp(){
        Intent i = new Intent(getActivity(), TopUpActivity.class);
        startActivity(i);
        getActivity(). overridePendingTransition(R.anim.zoom_enter,
                R.anim.zoom_exit);
    }

    @OnClick(R.id.mini_statement)
    public void miniStatement(){
        Intent i = new Intent(getActivity(), MiniStatementActivity.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.bottom_up,
                R.anim.nothing);
    }


    @OnClick(R.id.receive)
    public void receive(){
        Intent i = new Intent(getActivity(), CommonInputActivity.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.push_left_in,
                R.anim.nothing);
    }


    @OnClick(R.id.transfer)
    public void transfer(){
        Intent i = new Intent(getActivity(), CommonInputActivity.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.push_left_in,
                R.anim.nothing);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragmentView = inflater.inflate(R.layout.dashboard_content,
                container, false);

        ButterKnife.bind(this, myFragmentView);

        // for dynamic background
        //        String backgroundUrl = "https://www.w3schools.com/css/img_forest.jpg";
        //        setBackground(backgroundUrl);

        setHistoryList();

        return myFragmentView;
    }



    private void setBackground( String backgroundUrl){
        if (backgroundUrl != null && !TextUtils.isEmpty(backgroundUrl)) {

            Glide
                    .with(getActivity())
                    .load(backgroundUrl)
                    .placeholder(R.drawable.wall01)
                    .centerCrop()
                    .into(bgImage);
        }

    }


    private  void setHistoryList(){

        ArrayList<HistoryItem> array = new ArrayList<>();
        array.add(new HistoryItem("Mobile Top-Up", "6 May 11:45 AM" , "50 TK"));
        array.add(new HistoryItem("Mobile Top-Up", "6 May 11:45 AM" , "100 TK"));
        array.add(new HistoryItem("Utility Bill", "6 May 11:45 AM" , "1150 TK"));
        array.add(new HistoryItem("Receive Money", "6 May 11:45 AM" , "5000 TK"));
        array.add(new HistoryItem("Mobile Top-Up", "6 May 11:45 AM" , "50 TK"));
        array.add(new HistoryItem("Mobile Top-Up", "6 May 11:45 AM" , "100 TK"));
        array.add(new HistoryItem("Utility Bill", "6 May 11:45 AM" , "1150 TK"));
        array.add(new HistoryItem("Receive Money", "6 May 11:45 AM" , "5000 TK"));

        historyList.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        historyList.setAdapter(new HistoryListAdapter(getActivity(),array));

    }


}
