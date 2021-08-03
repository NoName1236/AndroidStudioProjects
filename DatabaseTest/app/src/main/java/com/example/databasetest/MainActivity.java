package com.example.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.getWritableDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                // db.insert("Book", null, values);

                values.clear();
                values.put("name", "The lost of Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                //db.insert("Book", null, values);
                db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", new String[]{"The Da Vinci code", "Dan brown", "454", "16.96"});
                db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", new String[]{"The lost of symbol", "Dan brown", "510", "19.95"});
            }
        });
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                //db.update("Book",values,"name = ?",new String[]{"The Da Vinci Code"});
                db.execSQL("update Book set price = ? where name = ?", new String[]{"10.99", "The Da Vinci code"});
            }
        });
        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                //db.delete("Book","author = ?",new String[]{"Dan Brown"});
                db.execSQL("delete from Book where pages > ?", new String[]{"500"});

            }
        });
        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getReadableDatabase();
                /**
                 Cursor cursor=db.query("Book",null,null,null,null,null,null);
                 if (cursor.moveToFirst())
                 {
                 do {
                 String name = cursor.getString(cursor.getColumnIndex("name"));
                 String author = cursor.getString(cursor.getColumnIndex("author"));
                 int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                 double price = cursor.getDouble(cursor.getColumnIndex("price"));
                 Log.d("MainActivity", "book name is " + name);
                 Log.d("MainActivity", "book author is " + author);
                 Log.d("MainActivity", "book pages is " + pages);
                 Log.d("MainActivity", "book price is " + price);
                 }while (cursor.moveToNext());
                 cursor.close();
                 }
                 */
                Cursor cursor = db.rawQuery("select * from Book", null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "book name is " + name);
                        Log.d("MainActivity", "book author is " + author);
                        Log.d("MainActivity", "book pages is " + pages);
                        Log.d("MainActivity", "book price is " + price);
                    } while (cursor.moveToNext());
                    cursor.close();
                }
            }
        });
    }
}