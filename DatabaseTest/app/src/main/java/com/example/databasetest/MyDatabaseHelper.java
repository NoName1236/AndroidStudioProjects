package com.example.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 李辉 on 2018/12/14.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK=" create table Book("
    +"id integer primary key autoincrement,"
    +"author text,price real,"
    +"pages integer,name text)";
    public static final String CREATE_CATEGORY=" create table Category("
            +"id integer primary key autoincrement,"
            +"category_name text,"
            +"category_code integer)";
    public static final String ADD_DATA="insert into Book("
    +"name,author,pages,price) values(?,?,?,?)";
    private Context mContext;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);//建表Book
        db.execSQL(CREATE_CATEGORY);//建表Category
       // Toast.makeText(mContext,"Create succeed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
    public void myInsert(SQLiteDatabase db)
    {
        db.execSQL(ADD_DATA,new String[]{"The Da Vinci code","Dan brown","454","16.96"});
        db.execSQL(ADD_DATA,new String[]{"The lost of symbol","Dan brown","510","19.95"});
    }
    public void myUpdate(SQLiteDatabase db)
    {
        db.execSQL("update Book set price = ? where name = ?",new String[]{"10.99","The Da Vinci code"});
    }
    public void myDelete(SQLiteDatabase db)
    {
        db.execSQL("delete from Book where pages > ?",new String[]{"500"});
    }
    public void myQuery(SQLiteDatabase db)
    {
        db.rawQuery("select * from Book",null);
    }
}
