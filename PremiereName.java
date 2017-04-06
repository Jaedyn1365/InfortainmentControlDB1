package com.example.spsnyder.premieredatabase.Data.Model;


public class PremiereName {

    public static final String TAG = PremiereName.class.getSimpleName();
    public static final String TABLE = "PremiereName";

    public static final String KEY_Premiere_Id = "PremiereID";
    public static final String KEY_Premiere_Title = "PremiereTitle";
    public static final String KEY_Premiere_Info = "PremiereInformation";
    public static final String KEY_Premiere_Genre = "PremiereGenre";
    public static final String KEY_Premiere_Category = "PremiereCategory";

    private String premiereId;
    private String premiereTitle;
    private String premiereInfo;
    private String premiereGenre;
    private String premiereCategory;

    public String getPremiereCategory() {
        return premiereCategory;
    }

    public void setPremiereCategory(String premiereCategory){
        this.premiereCategory = premiereCategory;
    }

    public String getPremiereGenre() {
        return premiereGenre;
    }

    public void setPremiereGenre(String premiereGenre){
        this.premiereGenre = premiereGenre;
    }

    public String getPremiereInfo(){
        return premiereInfo;
    }

    public void setPremiereInfo(String premiereInfo){
        this.premiereInfo = premiereInfo;
    }

    public String getPremiereTitle(){
        return premiereTitle;
    }

    public void setPremiereTitle(String premiereTitle){
        this.premiereTitle = premiereTitle;
    }

    public String getPremiereId(){
        return premiereId;
    }

    public void setPremiereId(String premiereId){
        this.premiereId = premiereId;
    }
}
