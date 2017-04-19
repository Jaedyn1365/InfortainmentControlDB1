package com.instinctcoder.sqlitedbmultitbl.data.model;

public class Premiere {
    public static final String TAG = Premiere.class.getSimpleName();
    public static final String TABLE = "Premiere";

    // Labels Table Columns names
    public static final String KEY_PremID = "PremiereId";
    public static final String KEY_PremTitle = "Title";
    public static final String KEY_PremGenre = "Genre";
    public static final String KEY_PremCategory = "Category";
    public static final String KEY_PremInfo = "Information";

    private String premiereId ;
    private String premiereTitle;
    private String premiereGenre;
    private String premiereCategory;
    private String premiereInfo;



    public String getPremiereId() { return premiereId;}

    public void setPremiereId(String premiereId) { this.premiereId = premiereId;}

    public String getPremiereTitle() { return premiereTitle;}

    public void setPremiereTitle(String premiereTitle) { this.premiereTitle = premiereTitle;}

    public String getPremiereGenre() { return premiereGenre;}

    public void setPremiereGenre(String premiereGenre) { this.premiereGenre = premiereGenre;}

    public String getPremiereCategory() { return premiereCategory;}

    public void setPremiereCategory(String premiereCategory) { this.premiereCategory = premiereCategory;}

    public String getPremiereInfo() { return premiereInfo;}

    public void setPremiereInfo(String premiereInfo) { this.premiereInfo = premiereInfo;}

}