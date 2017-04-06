package com.example.spsnyder.premieredatabase.Data.Repo;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.spsnyder.premieredatabase.Data.DatabaseManager;
import com.example.spsnyder.premieredatabase.Data.Model.ServiceProvider;

public class ServiceProviderRepo {

    private ServiceProvider serviceProvider;

    public ServiceProviderRepo(){

        serviceProvider = new ServiceProvider();
    }

    public static String createTable(){
        return "CREATE TABLE " + ServiceProvider.TABLE + "("
                + ServiceProvider.KEY_Provider_Id + " TEXT PRIMARY KEY, "
                + ServiceProvider.KEY_Provider_Name + " TEXT, "
                + ServiceProvider.KEY_Channel_Number + " TEXT)";
    }

    public int insert(ServiceProvider serviceProvider) {
        int serviceProviderId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(ServiceProvider.KEY_Provider_Id, serviceProvider.getProviderId());
        values.put(ServiceProvider.KEY_Provider_Name, serviceProvider.getProviderName());
        values.put(ServiceProvider.KEY_Channel_Number, serviceProvider.getChannelNumber());

        serviceProviderId=(int)db.insert(ServiceProvider.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        return serviceProviderId;

    }

    public void delete() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(ServiceProvider.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
