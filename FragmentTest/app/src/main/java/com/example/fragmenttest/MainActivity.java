package com.example.fragmenttest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
        //活动获取碎片
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        replaceFragment(new RightFragment());
        RightFragment rightFragment=(RightFragment)getSupportFragmentManager().findFragmentById(R.id.right_fragment);

        //碎片得到活动
        rightFragment.getActivity();
        //碎片与碎片通信
        Activity activity=rightFragment.getActivity();
        LeftFragment newFragment=(LeftFragment)getSupportFragmentManager().findFragmentById(R.id.left_fragment);
        */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null)
        {
            String tempData=savedInstanceState.getString("data_key");
            Log.d("MainActivity",tempData);
        }
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
       // replaceFragment(new RightFragment());
    }

    /**
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManger = getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManger.beginTransaction();
        transaction.replace(R.id.right_layout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
              // replaceFragment(new RightFragment2());
                break;
            default:
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String tempData="something you just typed";
        outState.putString("data_key",tempData);
    }
}
