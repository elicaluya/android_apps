package com.earthquake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<EarthquakeInfo> list;

    public CustomAdapter(Context context, ArrayList<EarthquakeInfo> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        }
        LinearLayout item_list;
        TextView coordinates, datetime, magnitude, depth;

        item_list = (LinearLayout) convertView.findViewById(R.id.item_list);
        coordinates = (TextView) convertView.findViewById(R.id.coordinates);
        datetime = (TextView) convertView.findViewById(R.id.datetime);
        magnitude = (TextView) convertView.findViewById(R.id.magnitude);
        depth = (TextView) convertView.findViewById(R.id.depth);

        Double mag = list.get(position).getMagnitude();
        magnitude.setText(Double.toString(mag));
        coordinates.setText("Location: " + list.get(position).getLatitude() + ", " + list.get(position).getLongitude()
                + " (" + list.get(position).getSource().toUpperCase() + ")");
        datetime.setText("Time: " + list.get(position).getDate());
        depth.setText("Depth: " + list.get(position).getDepth());


        if (mag >= 8.0){
            item_list.setBackgroundColor(Color.parseColor("#f498ad"));
            magnitude.setTypeface(null, Typeface.BOLD);
            coordinates.setTypeface(null, Typeface.BOLD);
        }
        else {
            item_list.setBackgroundColor(Color.parseColor("#07000000"));
            magnitude.setTypeface(null, Typeface.NORMAL);
            coordinates.setTypeface(null, Typeface.NORMAL);
        }

        return convertView;
    }
}
