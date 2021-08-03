package com.example.fragmentbestpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 李辉 on 2018/12/7.
 */

public class NewsContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    public void refresh(String newsTitle,String newsContent){
        View visibilityLayout=view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText=(TextView) view.findViewById(R.id.news_title);
        TextView newsContentTet=(TextView)view.findViewById(R.id.news_content);
        newsTitleText.setText(newsTitle);
        newsContentTet.setText(newsContent);
    }
}
