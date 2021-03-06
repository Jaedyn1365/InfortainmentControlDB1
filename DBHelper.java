package com.example.spsnyder.studentdb.Data;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.spsnyder.studentdb.Data.Model.Channel;
import com.example.spsnyder.studentdb.Data.Model.TimeZone;
import com.example.spsnyder.studentdb.app.App;
import com.example.spsnyder.studentdb.Data.Model.Premiere;
import com.example.spsnyder.studentdb.Data.Model.ServiceProvider;
import com.example.spsnyder.studentdb.Data.Repo.CourseRepo;
import com.example.spsnyder.studentdb.Data.Repo.MajorRepo;
import com.example.spsnyder.studentdb.Data.Repo.StudentCourseRepo;
import com.example.spsnyder.studentdb.Data.Repo.StudentRepo;


public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION =8;
    // Database Name
    private static final String DATABASE_NAME = "sqliteDBMultiTbl.db";
    private static final String TAG = DBHelper.class.getSimpleName().toString();

    public DBHelper( ) {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        db.execSQL(CourseRepo.createTable());
        db.execSQL(StudentRepo.createTable());
        db.execSQL(MajorRepo.createTable());
        db.execSQL(StudentCourseRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + TimeZone.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Premiere.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Channel.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ServiceProvider.TABLE);
        onCreate(db);
    }

}