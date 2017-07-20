package edu.uoregon.ecaluya.tide_appv2;

import java.util.ArrayList;

/**
 * Created by elijahcaluya on 7/16/17.
 */

public class TideItems extends ArrayList<TideItem>{
    // Default Serial ID
    private static final long serialVersionUID = 1L;

    public String stationName = null;

    public void setStationName(String name){this.stationName = name;}
    public String getStationName(){return this.stationName;}

}
