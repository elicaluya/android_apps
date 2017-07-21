package edu.uoregon.ecaluya.tide_appv3;

import java.util.ArrayList;

/**
 * Created by elijahcaluya on 7/20/17.
 */

public class TideItems extends ArrayList<TideItem> {
    // Default Serial ID
    private static final long serialVersionUID = 1L;

    public String stationName = null;
    public String stationID = null;
    public String longitude = null;
    public String latitude = null;

    public void setStationName(String name){this.stationName = name;}
    public String getStationName(){return this.stationName;}

    public void setStationID(String ID){this.stationID = ID;}
    public String getStationID(){return this.stationID;}

    public void setLongitude(String lon){this.longitude = lon;}
    public String getLongitude(){return this.longitude;}

    public void setLatitude(String lat){this.latitude = lat;}
    public String getLatitude(){return this.latitude;}

}
