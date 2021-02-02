package com.earthquake;

/*
* Class for EarthquakeInfo objects from JSON objects returned by the api
* Contains setter and getter methods for all attributes
*/
public class EarthquakeInfo {
    private String id;
    private Double magnitude;
    private String date;
    private String depth;
    private String source;
    private String longitude;
    private String latitude;

    public void setId(String id) {
        this.id = id;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }

    public String getDepth() {
        return depth;
    }

    public String getSource() {
        return source;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }
}
