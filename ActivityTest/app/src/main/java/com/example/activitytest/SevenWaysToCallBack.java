package com.example.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SevenWaysToCallBack extends AppCompatActivity {
    //完整生存期
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seven_ways_to_call_back_layout);
    }//第一次创建时调用，初始化

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }//销毁前调用
    //可见生存期，加载与释放可见资源
    @Override
    protected void onStart() {
        super.onStart();
    }//活动由不可见变为可见

    @Override
    protected void onStop() {
        super.onStop();
    }//完全不可见时
    //前台生存期，可交互
    @Override
    protected void onResume() {
        super.onResume();
    }//活动处于栈顶，运行状态

    @Override
    protected void onPause() {
        super.onPause();
    }//启动或恢复另一活动，执行要快
     


    @Override
    protected void onRestart() {
        super.onRestart();
    }//停止变重新运行
}
