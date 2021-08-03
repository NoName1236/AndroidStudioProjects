package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HelloWorldActivity extends AppCompatActivity {
    private static final String TAG = "HelloWorldActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);
        Log.v("HelloWorldActivity","最低级别Log.v");
        Log.d("data","onCreate execute(Log.d) debug级别");
        Log.i("HelloWorldActivity","Log.i 比debug高一级 info级别");
        Log.w("HelloWorldActivity","Log.w 比info高一级 warning级别");
        Log.e("HelloWorldActivity","错误级别，最高");
        Log.d(TAG, "onCreate: ");
        Log.i(TAG, "onCreate: ");
        Log.w(TAG, "onCreate: ");//logd/i/w+Tab快捷生成

       // System.out.println(R.string.app_name);

    }

}
