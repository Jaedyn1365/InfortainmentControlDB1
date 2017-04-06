package com.example.spsnyder.premieredatabase.Data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

import com.example.spsnyder.premieredatabase.App.App;
import com.example.spsnyder.premieredatabase.Data.Model.ChannelName;
import com.example.spsnyder.premieredatabase.Data.Model.PremiereName;
import com.example.spsnyder.premieredatabase.Data.Model.ServiceProvider;
import com.example.spsnyder.premieredatabase.Data.Model.TimeZone;
import com.example.spsnyder.premieredatabase.Data.Repo.ChannelNameRepo;
import com.example.spsnyder.premieredatabase.Data.Repo.PremiereNameRepo;
import com.example.spsnyder.premieredatabase.Data.Repo.ServiceProviderRepo;
import com.example.spsnyder.premieredatabase.Data.Repo.TimeZoneRepo;

public class DBHelper extends SQLiteOpenHelper  {
    //version number of the database, if updated version needs to change
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "PremiereDatabase";
    private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper() {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tables will be created here, most likely
        db.execSQL(ChannelNameRepo.createTable());
        db.execSQL(PremiereNameRepo.createTable());
        db.execSQL(ServiceProviderRepo.createTable());
        db.execSQL(TimeZoneRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        //Drops tables if they exist already
        db.execSQL("DROP TABLE IF EXISTS " + ChannelName.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PremiereName.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ServiceProvider.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TimeZone.TABLE);
        onCreate(db);
    }
}
