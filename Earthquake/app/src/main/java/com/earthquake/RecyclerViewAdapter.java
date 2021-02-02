package com.earthquake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/*
* Need to implement an adapter to the RecyclerView so that we can populate it and set up click listeners
* */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<EarthquakeInfo> data;
    private ItemClickListener itemClickListener;


    public RecyclerViewAdapter(Context context, List<EarthquakeInfo> data) {
        this.data = data;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
    }


    // This method will inflate the layout we have for each item
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    // onBindViewHolder will bind our data to its respective TextView
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Double mag = data.get(position).getMagnitude();
        holder.magnitude.setText(String.format("%s", Double.toString(mag)));
        holder.coordinates.setText(String.format("Location: %s, %s (%s)", data.get(position).getLatitude(), data.get(position).getLongitude(), data.get(position).getSource().toUpperCase()));
        holder.datetime.setText(String.format("Time: %s", data.get(position).getDate()));
        holder.depth.setText(String.format("Depth: %s", data.get(position).getDepth()));

        // Make background red and some text bold if magnitude is greater than or equal to 8 to distinguish it from others
        if (mag >= 8.0){
            holder.magnitude.setBackgroundColor(Color.parseColor("#f498ad"));
            holder.magnitude.setTypeface(null, Typeface.BOLD);
            holder.coordinates.setTypeface(null, Typeface.BOLD);
        }
        else {
            holder.magnitude.setBackgroundColor(Color.parseColor("#cfcfcf"));
            holder.magnitude.setTypeface(null, Typeface.NORMAL);
            holder.coordinates.setTypeface(null, Typeface.NORMAL);
        }
    }

    // Method for getting the total number of items
    @Override
    public int getItemCount() {
        return data.size();
    }


    /*
    * This class is created so that it can store and recycle views as they are scrolled off screen
    * */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView magnitude;
        TextView coordinates;
        TextView datetime;
        TextView depth;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            magnitude = itemView.findViewById(R.id.magnitude);
            coordinates = itemView.findViewById(R.id.coordinates);
            datetime = itemView.findViewById(R.id.datetime);
            depth = itemView.findViewById(R.id.depth);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    // Used for retrieving data at specific click position
    EarthquakeInfo getItem(int id){
        return data.get(id);
    }

    // Sets up itemClickListener so that click events will be caught
    void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    // Interface created so that the parent activity will implement to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
