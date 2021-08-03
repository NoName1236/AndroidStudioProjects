package com.example.recyclerviewtest;

/**
 * Created by 李辉 on 2018/12/5.
 */

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name, int imageId)
    {
        this.name=name;
        this.imageId=imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
