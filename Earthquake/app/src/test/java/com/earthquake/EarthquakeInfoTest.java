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


    // Testing methods for CustomAdapter class
    @Test
    public void testAdapter() {
        MainActivity mainActivity = new MainActivity();
        populate(eqlist);
        CustomAdapter customAdapter = new CustomAdapter(mainActivity, eqlist);

        // Checking that there are three objects in the adapter
        assertEquals(3, customAdapter.getCount());
        assertNotNull(customAdapter.getItem(1));

        // Check that we can pull the first item in the adapter and that it is valid
        EarthquakeInfo e = (EarthquakeInfo) customAdapter.getItem(0);
        assertEquals(expectedSource, e.getSource());

        // Check that getItemId is valid
        assertEquals(0, customAdapter.getItemId(0));
    }


    // Testing that CustomerAdapter methods will throw IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBounds(){
        MainActivity mainActivity = new MainActivity();
        ArrayList<EarthquakeInfo> list = new ArrayList<>();
        CustomAdapter customAdapter = new CustomAdapter(mainActivity, eqlist);

        // Both calls below should throw IndexOutOfBoundsException since the list is empty
        EarthquakeInfo e = (EarthquakeInfo) customAdapter.getItem(0);
        long idTest = customAdapter.getItemId(0);
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
