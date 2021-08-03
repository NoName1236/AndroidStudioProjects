package com.example.litepaltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase=(Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
                Toast.makeText(MainActivity.this,"create databases",Toast.LENGTH_SHORT).show();
            }
        });
        Button addData=(Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book();
                book.setAuthor("Dan Browm");
                book.setName("The DaVinci Code");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknown");
                book.save();
                Toast.makeText(MainActivity.this,"add data",Toast.LENGTH_SHORT).show();
            }
        });
        Button updateData=(Button)findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book();

                /**
                book.setName("The Lost Symbol");
                book.setAuthor("Dan Brown");
                book.setPages(510);
                book.setPrice(19.95);
                book.setPress("Unknown");
                book.save();
                book.setPrice(10.99);
                book.save();
                */
                /**
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name=?and author=?","The Lost Symbol","Dan Brown");
                 */
                book.setToDefault("pages");
                book.updateAll();
                Toast.makeText(MainActivity.this,"update data",Toast.LENGTH_SHORT).show();

            }
        });
        Button deleteData=(Button)findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class);
                Toast.makeText(MainActivity.this,"delete all",Toast.LENGTH_SHORT).show();
            }
        });
        Button queryData=(Button)findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //List<Book> books=DataSupport.findAll(Book.class);//findFirst findLast etc
                List<Book> books=DataSupport.select("name","author").find(Book.class);
                List<Book> books1=DataSupport.where("pages>?","400").find(Book.class);
                List<Book> books2=DataSupport.order("price desc").find(Book.class);
                //limit offset

                /**
                Cursor c=DataSupport.findBySQL("select * from Book where pages > ? and price < ?","400","20");
                if (c.moveToFirst())
                {
                    do {
                        String name=c.getString(c.getColumnIndex("name"));
                        //....
                        Log.d("MainActivity","name is "+name);
                    }while (c.moveToNext());
                }
                c.close();
                */
                for (Book book:books1)
                {
                    Log.d("MainActivity","book name is "+book.getName());
                    Log.d("MainActivity","book author is "+book.getAuthor());
                    Log.d("MainActivity","book price is "+book.getPrice());
                    Log.d("MainActivity","book press is "+book.getPress());
                    Log.d("MainActivity","book pages is "+book.getPages());
                }
            }
        });
    }
}
