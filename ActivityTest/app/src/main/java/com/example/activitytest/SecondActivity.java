package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    /**
    public static void actionStart(Context context,String data1,String data2) {
        Intent intent=new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button1=(Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("SecondActivity",this.toString());
        Log.d("SecondActivity","Task id is "+getTaskId());
        setContentView(R.layout.second_layout);
        /** 按键相关
        Button button2=(Button) findViewById(R.id.button_2);//返回的View对象转为Button
        button2.setOnClickListener(new View.OnClickListener() {//注册监听器
            @Override
            public void onClick(View v) {//执行此方法

                 Toast.makeText(SecondActivity.this,"you clicked button2!",Toast.LENGTH_SHORT).show();
                 //Context,内容,时长(长或短)
                 //finish();//销毁
            }
        });
        //传递数据给下一个活动(配套FirstActivity)
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");//getIntExtra,getBooleanExtra...
        Log.d("Second Activity",data);

        Button button2=(Button) findViewById(R.id.button_2);//返回的View对象转为Button
        button2.setOnClickListener(new View.OnClickListener() {//注册监听器
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("data_return","Hello First Activity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
     */
        Button button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello First Activity(via back)");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }

}