package com.example.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by 李辉 on 2018/12/5.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button title_back=(Button)findViewById(R.id.title_back);
        Button title_edit=(Button)findViewById(R.id.title_edit);
        Button title_refresh=(Button)findViewById(R.id.title_refresh);
        title_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        title_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"You clicked Edit Button!",Toast.LENGTH_SHORT).show();
            }
        });
        title_refresh.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"You clicked Refresh Button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
