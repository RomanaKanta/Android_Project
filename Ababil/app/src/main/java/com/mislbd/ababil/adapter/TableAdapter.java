package com.mislbd.ababil.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mislbd.ababil.R;
import com.mislbd.ababil.modelclass.HistoryItem;
import com.mislbd.ababil.modelclass.MiniStatementItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    private final ArrayList<MiniStatementItem> products;
    Context context;


    public TableAdapter(Context context, ArrayList<MiniStatementItem> categories) {
        this.products = categories;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ministatement_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final MiniStatementItem item = products.get(position);

            holder.txtDate.setText(item.getDate());
            holder.txtNarration.setText(item.getNarration());
            holder.txtAmount.setText(item.getAmount());
            holder.txtAccount.setText(item.getAcc_no());
            holder.txtInstalment.setText(item.getInstalment());

    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;


        @Bind(R.id.tra_date)
        TextView txtDate;
        @Bind(R.id.tra_amount)
        TextView txtAmount;
        @Bind(R.id.tra_narra)
        TextView txtNarration;
        @Bind(R.id.account_no)
        TextView txtAccount;
        @Bind(R.id.instalment)
        TextView txtInstalment;

        //        public ProductModelClass category;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mView = view;
        }

    }
}
