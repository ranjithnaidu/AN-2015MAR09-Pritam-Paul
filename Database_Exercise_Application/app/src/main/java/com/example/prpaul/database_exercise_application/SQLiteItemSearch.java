package com.example.prpaul.database_exercise_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by prpaul on 4/17/2015.
 */
public class SQLiteItemSearch extends SQLiteOpenHelper {

    private static final String DB_NAME = "Products.db";
    private static final int DB_VERSION_NUMBER = 1;
    private static final String DB_TABLE_NAME = "itemsearch";
    private static final String DB_COLUMN_1_NAME = "item_name";

    private static final String DB_CREATE_SCRIPT = "create table "+ DB_TABLE_NAME + " (_id integer primary key autoincrement, item_name text not null);)";

    private SQLiteDatabase sqliteDBInstance;


    public SQLiteItemSearch(Context context) {

        super(context, DB_NAME, null, DB_VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDBInstance) {

        //sqliteDBInstance = this.getWritableDatabase();
        sqliteDBInstance.execSQL(DB_CREATE_SCRIPT);

        //this.sqliteDBInstance=sqliteDBInstance;
    }

    public void insertitemSearch(String ItemBrandName) {
        /*ContentValues contentValues = new ContentValues();
        contentValues.put(DB_COLUMN_1_NAME, ItemBrandName);
        //Log.i(this.toString() + " - insertitmSearch", "Inserting: "+ ItemBrandName);
        return this.sqliteDBInstance.insert(DB_TABLE_NAME, null,contentValues);*/

        sqliteDBInstance = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_1_NAME,ItemBrandName);
        sqliteDBInstance.insert(DB_TABLE_NAME, null, values);

        sqliteDBInstance.close();

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String[] getAllItemFilter() {

       // Cursor cursor = this.sqliteDBInstance.query(DB_TABLE_NAME, new String[] { DB_COLUMN_1_NAME }, null,null, null, null, null);
        sqliteDBInstance = this.getReadableDatabase();
        String select_query = "select * from "+DB_TABLE_NAME;
        Cursor cursor = sqliteDBInstance.rawQuery(select_query, null);

        if (cursor.getCount() > 0) {
            String[] str = new String[cursor.getCount()];
            int i = 0;

            while (cursor.moveToNext()) {
                str[i] = cursor.getString(cursor.getColumnIndex(DB_COLUMN_1_NAME));
                i++;
            }
            return str;
        } else {
            return new String[] {};
        }
    }
}


