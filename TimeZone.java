package com.example.spsnyder.premieredatabase.Data.Model;



public class TimeZone {

    public static final String TAG = TimeZone.class.getSimpleName();
    public static final String TABLE = "TimeZone";

    public static final String KEY_Time_Id = "TimeId";
    public static final String KEY_Time_Zone = "TimeZone";
    public static final String KEY_Time_Stamp = "TimeStamp";
    public static final String KEY_Air_Time = "AirTime";

    private String timeId;
    private String timeZone;
    private String timeStamp;
    private String airTime;

    public String getAirTime() {
        return airTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId){
        this.timeId = timeId;
    }
}
