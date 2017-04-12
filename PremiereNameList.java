package com.example.spsnyder.premieredatabase.Data.Model;


public class PremiereNameList {
    private String premiereTitle;
    private String premiereGenre;
    private String premiereCategory;
    private String channelName;
    private String premiereChannel;
    private String timeZone;

    public String getPremiereInfo() {
        return premiereInfo;
    }

    public void setPremiereInfo(String premiereInfo){
        this.premiereInfo = premiereInfo;
    }

    private String premiereInfo;

    public String getPremiereTitle() {
        return premiereTitle;
    }

    public void setPremiereTitle(String premiereTitle){
        this.premiereTitle = premiereTitle;
    }

    public String getPremiereGenre() {
        return premiereGenre;
    }

    public void setPremiereGenre(String premiereGenre){
        this.premiereGenre = premiereGenre;
    }

    public String getPremiereCategory(){
        return premiereCategory;
    }

    public void setPremiereCategory(String premiereCategory){
        this.premiereCategory = premiereCategory;
    }

    public String getChannelName(){
        return channelName;
    }

    public void setChannelName(String channelName){
        this.channelName = channelName;
    }

    public String getPremiereChannel() {
        return premiereChannel;
    }

    public void setPremiereChannel(String premiereChannel){
        this.premiereChannel = premiereChannel;
    }

    public String getTimeZone(){
        return timeZone;
    }

    public void setTimeZone(String timeZone){
        this.timeZone = timeZone;
    }
}
