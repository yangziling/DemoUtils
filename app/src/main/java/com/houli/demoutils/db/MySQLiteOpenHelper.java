package com.houli.demoutils.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by stone on 2018/4/7.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "user.db";
    private static final int VERSION = 1;

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库
        db.execSQL("create table person (_id integer primary key autoincrement, " +
                "name char(10), phone char(20), money integer(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //数据库升级
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
