package edu.uoregon.ecaluya.tide_appv2;

/**
 * Created by elijahcaluya on 7/16/17.
 */

public class TideItem {

    private String date = null;
    private String day = null;
    private String time = null;
    private String pred_in_ft = null;
    private String pred_in_cm = null;
    private String highlow = null;


    public void setDate(String date){this.date = date;}
    public String getDate(){return date;}

    public void setDay(String day){this.day = day;}
    public String getDay(){return day;}

    public void setTime(String time){this.time = time;}
    public String getTime(){return time;}

    public void setPredInFt(String ft){this.pred_in_ft = ft;}
    public String getPred_in_ft(){return pred_in_ft;}

    public void setPredInCm(String cm){this.pred_in_cm = cm;}
    public String getPred_in_cm(){return pred_in_cm;}

    public void setHighLow(String hl){this.highlow = hl;}
    public String getHighlow(){return highlow;}
}
