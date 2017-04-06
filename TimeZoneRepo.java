package com.example.spsnyder.premieredatabase.Data.Repo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.spsnyder.premieredatabase.Data.DatabaseManager;
import com.example.spsnyder.premieredatabase.Data.Model.TimeZone;

public class TimeZoneRepo {

    private TimeZone timeZone;

    public TimeZoneRepo() {
        timeZone = new TimeZone();
    }

    public static String createTable(){
        return "CREATE TABLE " + TimeZone.TABLE  + "("
                + TimeZone.KEY_Time_Id + " PRIMARY KEY, "
                + TimeZone.KEY_Time_Zone + " TEXT "
                + TimeZone.KEY_Time_Stamp + " TEXT "
                + TimeZone.KEY_Air_Time + " TEXT) ";
    }

    public void insert(TimeZone timeZone) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(TimeZone.KEY_Time_Id, timeZone.getTimeId());
        values.put(TimeZone.KEY_Time_Zone, timeZone.getTimeZone());
        values.put(TimeZone.KEY_Time_Stamp, timeZone.getTimeStamp());
        values.put(TimeZone.KEY_Air_Time, timeZone.getAirTime());

        db.insert(TimeZone.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void delete() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TimeZone.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
