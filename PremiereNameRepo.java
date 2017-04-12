package com.example.spsnyder.premieredatabase.Data.Repo;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.spsnyder.premieredatabase.Data.DatabaseManager;
import com.example.spsnyder.premieredatabase.Data.Model.ChannelName;
import com.example.spsnyder.premieredatabase.Data.Model.PremiereName;
import com.example.spsnyder.premieredatabase.Data.Model.ServiceProvider;
import com.example.spsnyder.premieredatabase.Data.Model.TimeZone;
import com.example.spsnyder.premieredatabase.Data.Model.PremiereNameList;

import java.util.ArrayList;
import java.util.List;

public class PremiereNameRepo {
    private final String TAG = PremiereNameRepo.class.getSimpleName().toString();

    private PremiereName premiereName;

    public PremiereNameRepo() {
        premiereName = new PremiereName();
    }

    public static String createTable() {
        return "CREATE TABLE " +PremiereName.TABLE + "("
                + PremiereName.KEY_Premiere_Id + "PRIMARY KEY, "
                + PremiereName.KEY_Premiere_Title + "TEXT "
                + PremiereName.KEY_Premiere_Category + "TEXT "
                + PremiereName.KEY_Premiere_Genre + "TEXT "
                + PremiereName.KEY_Premiere_Info + "TEXT) ";
    }

    public void insert(TimeZone timeZone) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(PremiereName.KEY_Premiere_Id, premiereName.getPremiereId());
        values.put(PremiereName.KEY_Premiere_Title, premiereName.getPremiereTitle());
        values.put(PremiereName.KEY_Premiere_Category, premiereName.getPremiereCategory());
        values.put(PremiereName.KEY_Premiere_Genre, premiereName.getPremiereGenre());
        values.put(PremiereName.KEY_Premiere_Info, premiereName.getPremiereInfo());

        db.insert(PremiereName.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void delete() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(PremiereName.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<PremiereNameList> getPremiereName() {

        PremiereNameList premiereNameList = new PremiereNameList();
        List<PremiereNameList> premiereNameLists = new ArrayList<PremiereNameList>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery = " Select Premiere. " + PremiereName.KEY_Premiere_Id
                + ", Premiere. " + PremiereName.KEY_Premiere_Title
                + ", Genre. " + PremiereName.KEY_Premiere_Genre
                + ", Category. " + PremiereName.KEY_Premiere_Category
                + ", Information. " + PremiereName.KEY_Premiere_Info
                + ", Channel Name. " + ChannelName.KEY_ChannelName
                + ", Channel Number. " + ServiceProvider.KEY_Channel_Number
                + ", Air Time. " + TimeZone.KEY_Air_Time
                + ", From " + PremiereName.TABLE + " Premiere "
                + " Inner Join " + ChannelName.TABLE + ChannelName.KEY_ChannelID + ServiceProvider.TABLE + ServiceProvider.KEY_Provider_Id + TimeZone.TABLE + TimeZone.KEY_Time_Id;
        Log.d(TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                premiereNameList = new PremiereNameList();
                premiereNameList.setPremiereTitle(cursor.getString(cursor.getColumnIndex((PremiereName.KEY_Premiere_Title))));
                premiereNameList.setPremiereGenre(cursor.getString(cursor.getColumnIndex(PremiereName.KEY_Premiere_Genre)));
                premiereNameList.setPremiereCategory(cursor.getString(cursor.getColumnIndex(PremiereName.KEY_Premiere_Category)));
                premiereNameList.setPremiereInfo(cursor.getString(cursor.getColumnIndex(PremiereName.KEY_Premiere_Info)));
                premiereNameList.setPremiereChannel(cursor.getString(cursor.getColumnIndex(ChannelName.KEY_ChannelName)));
                premiereNameList.setPremiereChannel(cursor.getString(cursor.getColumnIndex(ServiceProvider.KEY_Channel_Number)));
                premiereNameList.setTimeZone(cursor.getString(cursor.getColumnIndex(TimeZone.KEY_Air_Time)));

                premiereNameLists.add(premiereNameList);
            }while (cursor.moveToNext());
        }

        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return premiereNameLists;

    }

}
