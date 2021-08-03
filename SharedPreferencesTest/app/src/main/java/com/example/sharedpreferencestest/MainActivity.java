package com.example.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save_data= (Button) findViewById(R.id.save_data);
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",18);
                editor.putBoolean("married",false);
                editor.apply();
                Log.d("MainActivity","已应用");
            }
        });
        Button restoredata=(Button)findViewById(R.id.restore_data);
        restoredata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
                String name=preferences.getString("name","noName");
                int age=preferences.getInt("age",0);
                boolean married=preferences.getBoolean("married",true);
                Log.d("MainActivity","name is "+name);
                Log.d("MainActivity","age = "+age);
                Log.d("MainActivity","married occasion:"+married);
            }
        });
    }
}
