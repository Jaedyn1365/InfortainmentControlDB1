package com.example.spsnyder.premieredatabase.Data.Repo;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.spsnyder.premieredatabase.Data.DatabaseManager;
import com.example.spsnyder.premieredatabase.Data.Model.PremiereName;
import com.example.spsnyder.premieredatabase.Data.Model.TimeZone;

public class PremiereNameRepo {

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
}
