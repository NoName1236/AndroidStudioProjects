package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 李辉 on 2018/12/5.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resuorceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects)
    {
        super(context,textViewResourceId,objects);
        resuorceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resuorceId, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.fruitImage=(ImageView)view.findViewById(R.id.image_fruit);
            viewHolder.fruitName=(TextView)view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//viewHolder存储在view中
        }
        else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        /**
        ImageView fruitImage=(ImageView)view.findViewById(R.id.image_fruit);
        TextView fruitName=(TextView)view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
         */
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder
    {
        ImageView fruitImage;
        TextView fruitName;

    }
}
