package com.earthquake;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;


@RunWith(AndroidJUnit4.class)
public class EarthquakeInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);

    MainActivity ma;


    // Testing that all of the views get populated when running the main activity
    @Test
    public void testActivity(){
        ma = mainActivity.getActivity();

        RecyclerView rv = (RecyclerView) ma.findViewById(R.id.earthquake_list);

        LayoutInflater inflater = ma.getLayoutInflater();
        View itemList = inflater.inflate(R.layout.item_list, null);

        TextView mag = (TextView) itemList.findViewById(R.id.magnitude);
        TextView coord = (TextView) itemList.findViewById(R.id.coordinates);
        TextView date = (TextView) itemList.findViewById(R.id.datetime);
        TextView depth = (TextView) itemList.findViewById(R.id.depth);

        View dialogLayout = inflater.inflate(R.layout.image_layout, null);
        ImageView eqImage = (ImageView) dialogLayout.findViewById(R.id.eq_image);
        TextView dialogMag = (TextView) dialogLayout.findViewById(R.id.dialog_mag);

        // Checking that all of the views get filled after running the main activity
        assertNotNull("mainActivity is null", ma);
        assertNotNull("RecyclerView is null", rv);
        assertNotNull("Magnitude TextView is null", mag);
        assertNotNull("Coordinates TextView is null", coord);
        assertNotNull("Date TextView is null", date);
        assertNotNull("Depth TextView is null", depth);
        assertNotNull("Earthquake Image is null", eqImage);
        assertNotNull("Magnitude in dialog is null", dialogMag);
    }
}
