package com.example.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);//给当前活动创建菜单(资源文件，Menu对象)
        return true;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("FirstActivity",this.toString());
        Log.d("FirstActivity","Task id is "+getTaskId());
        setContentView(R.layout.first_layout);//加载布局
        Button button1=(Button) findViewById(R.id.button_1);//返回的View对象转为Button
        button1.setOnClickListener(new View.OnClickListener() {//注册监听器
            @Override
            public void onClick(View v) {//执行此方法
            /**
                 //Toast
                Toast.makeText(FirstActivity.this,"you clicked button1!",Toast.LENGTH_SHORT).show();
                //Context,内容,时长(长或短)
               //finish();//销毁
                //显式Intent
                Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
                //隐式Intent
                Intent intent=new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
                //http协议
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                //字符串解析为Uri对象后传递给setData
                startActivity(intent);
                //拨打电话，地理位置等等
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:15809592137"));
                startActivity(intent);

                //传递数据给下一关活动
                String data="Hello Second Activity";
                Intent intent= new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);//第一个参数为键
                startActivity(intent);

                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
                Intent intent=new Intent(FirstActivity.this,FirstActivity.class);
                startActivity(intent);

                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
             */
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){//获取点击的菜单项
            case R.id.add_item:
                Toast.makeText(this,"you clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }
}
