package com.mislbd.ababil.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.mislbd.ababil.R;
import com.mislbd.ababil.adapter.HistoryListAdapter;
import com.mislbd.ababil.adapter.TableAdapter;
import com.mislbd.ababil.modelclass.HistoryItem;
import com.mislbd.ababil.modelclass.MiniStatementItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StatementTableActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    RecyclerView tableItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement_table);
        ButterKnife.bind(this);

        setTableData();

    }


    private  void setTableData(){

        ArrayList<MiniStatementItem> array = new ArrayList<>();
        array.add(new MiniStatementItem("10/02/2017", "1000", "transfer", "xxxxxxxxx", "---------"));
        array.add(new MiniStatementItem("10/02/2017", "1000", "transfer", "xxxxxxxxx", "---------"));
        array.add(new MiniStatementItem("10/02/2017", "1000", "transfer", "xxxxxxxxx", "---------"));
        array.add(new MiniStatementItem("10/02/2017", "1000", "transfer", "xxxxxxxxx", "---------"));
        array.add(new MiniStatementItem("10/02/2017", "1000", "transfer", "xxxxxxxxx", "---------"));
        array.add(new MiniStatementItem("10/02/2017", "1000", "transfer", "xxxxxxxxx", "---------"));

        tableItems.setLayoutManager(new GridLayoutManager(this, 1));

        tableItems.setAdapter(new TableAdapter(this,array));

    }

}
