package com.example.spsnyder.studentdb.app;


import android.app.Application;
import android.content.Context;

import com.example.spsnyder.studentdb.Data.DBHelper;
import com.example.spsnyder.studentdb.Data.DatabaseManager;


public class  App extends Application {
    private static Context context;
    private static DBHelper dbHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DBHelper();
        DatabaseManager.initializeInstance(dbHelper);

    }

    public static Context getContext(){
        return context;
    }

}