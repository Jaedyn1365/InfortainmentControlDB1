package com.instinctcoder.sqlitedbmultitbl.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.instinctcoder.sqlitedbmultitbl.app.App;
import com.instinctcoder.sqlitedbmultitbl.data.model.Channel;
import com.instinctcoder.sqlitedbmultitbl.data.model.ServiceProvider;
import com.instinctcoder.sqlitedbmultitbl.data.model.TimeZone;
import com.instinctcoder.sqlitedbmultitbl.data.model.Premiere;
import com.instinctcoder.sqlitedbmultitbl.data.Repo.ChannelRepo;
import com.instinctcoder.sqlitedbmultitbl.data.Repo.TimeZoneRepo;
import com.instinctcoder.sqlitedbmultitbl.data.Repo.ServiceProviderRepo;
import com.instinctcoder.sqlitedbmultitbl.data.Repo.PremiereRepo;


public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION =43;
    // Database Name
    private static final String DATABASE_NAME = "Premiere.db";
    private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper( ) {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        db.execSQL(ChannelRepo.createTable());
        db.execSQL(PremiereRepo.createTable());
        db.execSQL(TimeZoneRepo.createTable());
        db.execSQL(ServiceProviderRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Channel.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Premiere.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TimeZone.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ServiceProvider.TABLE);
        onCreate(db);
    }

}