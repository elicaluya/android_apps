package edu.uoregon.ecaluya.tide_appv3;

/**
 * Created by elijahcaluya on 7/20/17.
 */

public class TideItem {

    private String date = null;
    private String time = null;
    private String pred = null;
    private String type = null;


    public void setDate(String date){this.date = date;}
    public String getDate(){return date;}


    public void setTime(String time){this.time = time;}
    public String getTime(){return time;}

    public void setPred(String ft){this.pred = ft;}
    public String getPred(){return pred;}


    public void setType(String hl){this.type = hl;}
    public String getType(){return type;}
}
