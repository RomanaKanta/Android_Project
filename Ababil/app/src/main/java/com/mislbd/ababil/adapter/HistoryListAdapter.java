package com.mislbd.ababil.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mislbd.ababil.R;
import com.mislbd.ababil.modelclass.HistoryItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {

    private final ArrayList<HistoryItem> products;
    Context context;


    public HistoryListAdapter(Context context, ArrayList<HistoryItem> categories) {
        this.products = categories;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final HistoryItem item = products.get(position);

            holder.txtType.setText(item.getType());
            holder.txtTime.setText(item.getTime());
            holder.txtAmount.setText(item.getAmount());
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;


        @Bind(R.id.tran_title)
        TextView txtType;
        @Bind(R.id.tran_time)
        TextView txtTime;
        @Bind(R.id.tran_amount)
        TextView txtAmount;

        //        public ProductModelClass category;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mView = view;
        }

    }
}
