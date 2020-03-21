package com.example.bsmr.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bsmr.DateVideoPlayer;
import com.example.bsmr.R;
import com.example.bsmr.SubjectActivity;
import com.example.bsmr.model.PlaceNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private List<PlaceNames> placelNameList = null;
    private ArrayList<PlaceNames> arraylist;

    public ListViewAdapter(Context context, List<PlaceNames> placelNameList) {
        mContext = context;
        this.placelNameList = placelNameList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<PlaceNames>();
        this.arraylist.addAll(placelNameList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return placelNameList.size();
    }

    @Override
    public PlaceNames getItem(int position) {
        return placelNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(placelNameList.get(position).getPlaceName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(mContext, DateVideoPlayer.class);
                mContext.startActivity(j);
            }
        });
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        placelNameList.clear();
        if (charText.length() == 0) {
            placelNameList.addAll(arraylist);
        } else {
            for (PlaceNames wp : arraylist) {
                if (wp.getPlaceName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    placelNameList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
