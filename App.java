package com.example.spsnyder.premieredatabase.App;


import android.app.Application;
import android.content.Context;

import com.example.spsnyder.premieredatabase.Data.DBHelper;
import com.example.spsnyder.premieredatabase.Data.DatabaseManager;


public class App extends Application {
    private static Context context;
    private static DBHelper dbHelper;

    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DBHelper();
        DatabaseManager.initializerInstance(dbHelper);
    }

    public static Context getContext(){
        return context;
    }
}
