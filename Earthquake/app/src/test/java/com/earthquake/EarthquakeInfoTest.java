package com.earthquake;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class EarthquakeInfoTest {

    EarthquakeInfo ei;
    String expectedSource = "US";
    String expectedLatitude = "38.322";
    String expectedLongitude = "142.369";
    String expectedDepth = "24.4";
    String expectedDate = "2011-03-11 04:46:23";
    String expectedID = "c0001xgp";
    Double expectedMagnitude = 8.8;

    ArrayList<EarthquakeInfo> eqlist = new ArrayList<>();


    // Testing setter and getter methods of EarthquakeInfo class
    @Test
    public void testEarthquakeInfoMethods (){
        ei = new EarthquakeInfo();
        ei.setSource(expectedSource);
        ei.setLatitude(expectedLatitude);
        ei.setLongitude(expectedLongitude);
        ei.setDepth(expectedDepth);
        ei.setDate(expectedDate);
        ei.setId(expectedID);
        ei.setMagnitude(expectedMagnitude);

        assertEquals(expectedSource, ei.getSource());
        assertEquals(expectedLatitude, ei.getLatitude());
        assertEquals(expectedLongitude, ei.getLongitude());
        assertEquals(expectedDepth, ei.getDepth());
        assertEquals(expectedDate, ei.getDate());
        assertEquals(expectedID, ei.getId());
        assertEquals(expectedMagnitude, ei.getMagnitude());
    }


    // Testing methods for RecyclerViewAdapter class
    @Test
    public void testAdapter() {
        MainActivity mainActivity = new MainActivity();
        populate(eqlist);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mainActivity, eqlist);

        // Checking that there are three objects in the adapter
        assertEquals(3, recyclerViewAdapter.getItemCount());
        assertNotNull(recyclerViewAdapter.getItem(1));

        // Check that we can pull the first item in the adapter and that it is valid
        EarthquakeInfo e = (EarthquakeInfo) recyclerViewAdapter.getItem(0);
        assertEquals(expectedSource, e.getSource());

        // Checking that getItemId() works
        assertEquals(0, recyclerViewAdapter.getItemId(0));
        assertEquals(1, recyclerViewAdapter.getItemId(1));
        assertEquals(2, recyclerViewAdapter.getItemId(2));
    }


    // Testing that RecyclerViewAdapter methods will throw IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBounds(){
        MainActivity mainActivity = new MainActivity();
        ArrayList<EarthquakeInfo> list = new ArrayList<>();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mainActivity, eqlist);

        // Both calls below should throw IndexOutOfBoundsException since the list is empty
        EarthquakeInfo e = (EarthquakeInfo) recyclerViewAdapter.getItem(0);
        long idTest = recyclerViewAdapter.getItemId(0);
    }


    // Helper method to populate list with same 3 EarthquakeInfo objects for testing
    private void populate(ArrayList<EarthquakeInfo> list) {
        eqlist.clear();
        ei = new EarthquakeInfo();
        ei.setSource(expectedSource);
        ei.setLatitude(expectedLatitude);
        ei.setLongitude(expectedLongitude);
        ei.setDepth(expectedDepth);
        ei.setDate(expectedDate);
        ei.setId(expectedID);
        ei.setMagnitude(expectedMagnitude);

        // Only populate list with three items for testing
        for (int i = 0; i < 3; i++) {
            list.add(ei);
        }
    }
}
