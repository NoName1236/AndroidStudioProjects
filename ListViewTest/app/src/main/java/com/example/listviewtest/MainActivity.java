package com.example.listviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
    private String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry",
            "Cherry","Mango","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry",
            "Cherry","Mango"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    */
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter=new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);

        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initFruits()
    {
        for (int i=0;i<3;i++)
        {
            Fruit apple=new Fruit("Apple",R.drawable.apple);
            fruitList.add(apple);
            Fruit banana=new Fruit("Banana",R.drawable.banana);
            fruitList.add(banana);
            Fruit orange=new Fruit("Orange",R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon=new Fruit("Watermelon",R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear=new Fruit("Pear",R.drawable.pear);
            fruitList.add(pear);
            Fruit grape=new Fruit("Grape",R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple=new Fruit("Pineapple",R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry=new Fruit("Strawberry",R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit cherry=new Fruit("Cherry",R.drawable.cherry);
            fruitList.add(cherry);
            Fruit mango=new Fruit("Mango",R.drawable.mango);
            fruitList.add(mango);
        }
    }
}
