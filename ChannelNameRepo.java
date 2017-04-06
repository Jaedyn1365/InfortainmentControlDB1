package com.example.spsnyder.premieredatabase.Data.Repo;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.spsnyder.premieredatabase.Data.DatabaseManager;
import com.example.spsnyder.premieredatabase.Data.Model.ChannelName;

public class ChannelNameRepo {

    private ChannelName channelName;

    public ChannelNameRepo(){
        channelName = new ChannelName();
    }


    public static String createTable(){
        return "CREATE TABLE " + ChannelName.TABLE + "("
                + ChannelName.KEY_ChannelID + " PRIMARY KEY, "
                +ChannelName.KEY_ChannelName + " TEXT )";
    }

    public int insert(ChannelName channelName){
        int channelId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(ChannelName.KEY_ChannelID, channelName.getChannelId());
        values.put(ChannelName.KEY_ChannelName, channelName.getChannelName());

        channelId=(int)db.insert(ChannelName.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return channelId;
    }

    public void delete() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(ChannelName.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
