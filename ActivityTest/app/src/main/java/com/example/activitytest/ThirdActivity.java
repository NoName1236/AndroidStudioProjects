package com.example.activitytest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity","Task id is "+getTaskId());
        setContentView(R.layout.third_layout);
        Button button3=(Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ThirdActivity.this,"You clicked Button3",Toast.LENGTH_SHORT).show();
                ActivityCollector.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());//杀掉进程
            }
        });
    }

}
