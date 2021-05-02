package com.miczon.task3_maps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dbhelper extends SQLiteOpenHelper {

    private Context context;

    public Dbhelper(Context context) {
        super( context, Util.DATABASE, null, Util.DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String CREATE_TABLE = "CREATE TABLE " + Util.DATABASE_TABLE+"("
                 +Util.KEY_ID+" INTEGER PRIMARY KEY, "
                 +Util.KEY_ADDRESS+" TEXT "
                 + ")";
            db.execSQL( CREATE_TABLE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS address_table");
        onCreate(db);
    }


    public void saveData(String Address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( Util.KEY_ADDRESS,Address );
        db.insert( Util.DATABASE_TABLE,null,values );
        db.close();
    }

    //GET ALL DATA FROM TABLE
    public List<Model> getData(){
        String selectQuery = "SELECT  * FROM " + Util.DATABASE_TABLE;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String[] data      = null;
        List<Model> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getString(0));
                model.setAddress(cursor.getString(1));
                list.add(model);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
