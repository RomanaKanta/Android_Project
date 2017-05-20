package com.mislbd.ababil.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mislbd.ababil.R;
import com.mislbd.ababil.modelclass.AccountModel;
import com.mislbd.ababil.modelclass.HistoryItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.ViewHolder> {

    private final ArrayList<AccountModel> products;
    Context context;


    public AccountListAdapter(Context context, ArrayList<AccountModel> categories) {
        this.products = categories;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final AccountModel item = products.get(position);

            holder.txtTitle.setText(item.getTitle());
            holder.txtCount.setText(item.getCount());
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;


        @Bind(R.id.account_icon)
        ImageView accIcon;
        @Bind(R.id.account_title)
        TextView txtTitle;
        @Bind(R.id.count)
        TextView txtCount;

        //        public ProductModelClass category;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mView = view;
        }

    }
}
