package com.mislbd.ababil.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mislbd.ababil.R;
import com.mislbd.ababil.modelclass.MenuModel;
import com.mislbd.ababil.widget.AnimatedExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;


public class ExpandableListAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

    private Context mContext;
    private ArrayList<MenuModel> mExpandableListHeader;
    private HashMap<MenuModel, ArrayList<String>> mExpandableListChild;
    private LayoutInflater mLayoutInflater;
    Typeface regular;
    Typeface bold;

    public ExpandableListAdapter(Context context, ArrayList<MenuModel> expandableListTitle,
                                 HashMap<MenuModel, ArrayList<String>> expandableListDetail) {
        mContext = context;
        mExpandableListHeader = expandableListTitle;
        mExpandableListChild = expandableListDetail;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        regular = Typeface.createFromAsset(context.getAssets(),
                "font/ROBOTO-REGULAR.TTF");
        bold = Typeface.createFromAsset(context.getAssets(),
                "font/ROBOTO-BOLD.TTF");
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return mExpandableListChild.get(mExpandableListHeader.get(listPosition)).get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item, null);
        }
        TextView expandedListChildView = (TextView) convertView
                .findViewById(R.id.list_child);
        expandedListChildView.setText(expandedListText);
        expandedListChildView.setTypeface(regular);
        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return mExpandableListChild.get(mExpandableListHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return mExpandableListHeader.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return mExpandableListHeader.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = mExpandableListHeader.get(listPosition).getTitle();
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listParentView = (TextView) convertView
                .findViewById(R.id.listTitle);


        listParentView.setText(listTitle);

        if (getChildrenCount(listPosition) > 0) {

            if (isExpanded) {
                listParentView.setTypeface(bold);
                listParentView.setCompoundDrawablesWithIntrinsicBounds(mExpandableListHeader.get(listPosition).getIcon(), 0,
                        R.mipmap.ic_keyboard_arrow_down_white_24dp, 0);
            } else {
                // If group is not expanded then change the text back into normal
                // and change the icon
                listParentView.setTypeface(regular);
                listParentView.setCompoundDrawablesWithIntrinsicBounds(mExpandableListHeader.get(listPosition).getIcon(), 0,
                        R.mipmap.ic_keyboard_arrow_right_white_24dp, 0);
            }
        } else {
            listParentView.setTypeface(regular);
            listParentView.setCompoundDrawablesWithIntrinsicBounds(0, 0, mExpandableListHeader.get(listPosition).getIcon(), 0);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
