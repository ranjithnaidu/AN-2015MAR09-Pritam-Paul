package com.example.prpaul.todo_application.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "Tasks.db";
    private static final int DB_VERSION_NUMBER = 1;
    private static final String DB_TABLE_NAME = "EachTask";
    private static final String DB_COLUMN_1_NAME = "task_name";
    private static final String DB_COLUMN_2_NAME = "task_desc";
    private static final String DB_COLUMN_3_NAME = "task_date";

    private static final String DB_CREATE_SCRIPT = "create table "+ DB_TABLE_NAME +
            " (_id integer primary key autoincrement, "
            + DB_COLUMN_1_NAME+" text not null, " +
            DB_COLUMN_2_NAME+" text not null, " +
            DB_COLUMN_3_NAME+" text not null);";

    private SQLiteDatabase sqliteDBInstance;

    public DatabseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDBInstance) {
        sqliteDBInstance.execSQL(DB_CREATE_SCRIPT);
    }

    public void insertTask(String name, String desc, String dateSelected) {

        sqliteDBInstance = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_1_NAME,name);
        values.put(DB_COLUMN_2_NAME,desc);
        values.put(DB_COLUMN_3_NAME,dateSelected);
        sqliteDBInstance.insert(DB_TABLE_NAME, null, values);

        sqliteDBInstance.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
