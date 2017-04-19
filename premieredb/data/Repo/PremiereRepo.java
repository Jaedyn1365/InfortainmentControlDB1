package com.instinctcoder.sqlitedbmultitbl.data.Repo;



        import android.content.ContentValues;
        import android.database.sqlite.SQLiteDatabase;

        import com.instinctcoder.sqlitedbmultitbl.data.DatabaseManager;
        import com.instinctcoder.sqlitedbmultitbl.data.model.Premiere;


public class PremiereRepo {

    private Premiere premiere;

    public PremiereRepo(){

        premiere = new Premiere();

    }


    public static String createTable(){
        return " CREATE TABLE " + Premiere.TABLE  + " ( "
                + Premiere.KEY_PremID  + " TEXT PRIMARY KEY , "
                + Premiere.KEY_PremTitle + " TEXT , "
                + Premiere.KEY_PremGenre  + " TEXT , "
                + Premiere.KEY_PremCategory  + " TEXT , "
                + Premiere.KEY_PremInfo + " TEXT ) ";
    }



    public void insert(Premiere premiere) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Premiere.KEY_PremID, premiere.getPremiereId());
        values.put(Premiere.KEY_PremTitle, premiere.getPremiereTitle());
        values.put(Premiere.KEY_PremGenre, premiere.getPremiereGenre());
        values.put(Premiere.KEY_PremCategory, premiere.getPremiereCategory());
        values.put(Premiere.KEY_PremInfo, premiere.getPremiereInfo());


        // Inserting Row
        db.insert(Premiere.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Premiere.TABLE, null,null);
        DatabaseManager.getInstance().closeDatabase();
    }





}