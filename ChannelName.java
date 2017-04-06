package com.example.spsnyder.premieredatabase.Data.Model;



public class ChannelName {

    public static final String TAG = ChannelName.class.getSimpleName();
    public static final String TABLE = "ChannelName";
    //Labels on Table Columns
    public static final String KEY_ChannelID = "ChannelId";
    public static final String KEY_ChannelName = "Name";

    private String channelId;
    private String channelName;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId){
        this.channelId = channelId;
    }

    public String getChannelName(){
        return channelName;
    }

    public void setChannelName(String ChannelName){
        this.channelName = channelName;
    }
}
