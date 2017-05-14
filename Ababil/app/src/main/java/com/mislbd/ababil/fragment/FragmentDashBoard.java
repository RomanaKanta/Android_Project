package com.mislbd.ababil.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mislbd.ababil.R;
import com.mislbd.ababil.adapter.HistoryListAdapter;
import com.mislbd.ababil.modelclass.HistoryItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FragmentDashBoard extends Fragment {

    @Bind(R.id.recycler_view)
    RecyclerView historyList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragmentView = inflater.inflate(R.layout.dashboard_content,
                container, false);

        ButterKnife.bind(this, myFragmentView);

        setHistoryList();

        return myFragmentView;
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
//        final int gridMargin = getResources().getDimensionPixelOffset(R.dimen.grid_margin);
//        historyList.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
//                                       RecyclerView.State state) {
//                outRect.set(gridMargin, gridMargin, gridMargin, gridMargin);
//            }
//        });
//
//        historyList.setPadding(gridMargin, gridMargin, gridMargin, gridMargin);

        historyList.setAdapter(new HistoryListAdapter(getActivity(),array));



    }


}
