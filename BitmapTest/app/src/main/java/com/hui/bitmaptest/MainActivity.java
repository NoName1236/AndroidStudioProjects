package com.hui.bitmaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView original_pic,after_option;
    Button scale_by_value,scaling,cut,clockwise_rotation,counter_clockwise_rotation,offset_effect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化布局和控件
        initView();
    }

    private void initView() {//初始化视图及控件
        original_pic=findViewById(R.id.main_iv_original_pic);
        after_option=findViewById(R.id.main_iv_after_option);

        scale_by_value=findViewById(R.id.main_ll_btn_scale_by_value);
        scaling=findViewById(R.id.main_ll_btn_scaling);
        cut=findViewById(R.id.main_ll_btn_cut);
        clockwise_rotation=findViewById(R.id.main_ll_btn_clockwise_rotation);
        counter_clockwise_rotation=findViewById(R.id.main_ll_btn_counterclockwise_rotation);
        offset_effect=findViewById(R.id.offset_effect);
        scale_by_value.setOnClickListener(this);
        scaling.setOnClickListener(this);
        cut.setOnClickListener(this);
        clockwise_rotation.setOnClickListener(this);
        counter_clockwise_rotation.setOnClickListener(this);
        offset_effect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bitmap original_bm= BitmapFactory.decodeResource(getResources(),R.mipmap.test);
        float alpha=45.0f;
        float ratio=0.8f;
        switch (v.getId()){
            case R.id.main_ll_btn_scale_by_value:
                int new_width=100,new_height=100;
                Bitmap nBM1= scaleBitmapByValue(original_bm,new_width,new_height);
                after_option.setImageBitmap(nBM1);
                break;
            case R.id.main_ll_btn_scaling:
                Bitmap nBM2 = scaleBitmap(original_bm, ratio);
                after_option.setImageBitmap(nBM2);
                break;
            case R.id.main_ll_btn_cut:
                after_option.setImageBitmap(cutBitmap(original_bm));
                break;
            case R.id.main_ll_btn_clockwise_rotation:
                Bitmap nBM3=clockwiseRotate(original_bm,alpha);
                after_option.setImageBitmap(nBM3);
                break;
            case R.id.main_ll_btn_counterclockwise_rotation:
                alpha=-45.0f;
                Bitmap nBM4= clockwiseRotate(original_bm,alpha);
                after_option.setImageBitmap(nBM4);
                break;
            case R.id.offset_effect:
//                Bitmap nBM5=offsetEffect(original_bm);
//                after_option.setImageBitmap(nBM5);

//                InputStream is = null;
//                try {
//                    AssetManager am = getAssets();
//                    is = am.open("test2.jpg");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Bitmap bitmap = BitmapFactory.decodeStream(is);
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.high_pixel_img);
                String file_name = Environment.getExternalStorageDirectory().toString()+"/"+"test2.jpg";
                Bitmap bitmap = BitmapFactory.decodeFile(file_name);
                after_option.setImageBitmap(bitmap);
                break;
            default:
                break;
        }
    }

    private Bitmap offsetEffect(Bitmap originalBm) {
        int width = originalBm.getWidth();
        int height = originalBm.getHeight();
        Matrix matrix = new Matrix();
        matrix.postSkew(-0.6f, -0.3f);
        Bitmap newBM = Bitmap.createBitmap(originalBm, 0, 0, width, height, matrix, false);
        if (newBM.equals(originalBm)) {
            return newBM;
        }
        originalBm.recycle();
        return newBM;
    }

    private Bitmap clockwiseRotate(Bitmap original_bm, float alpha) {
        if (original_bm==null) {
            return null;
        }
        int width = original_bm.getWidth();
        int height = original_bm.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(alpha);
        // 围绕原地进行旋转
        Bitmap newBM = Bitmap.createBitmap(original_bm, 0, 0, width, height, matrix, false);
        if (newBM.equals(original_bm)) {
            return newBM;
        }
        original_bm.recycle();
        return newBM;
    }

    private Bitmap cutBitmap(Bitmap original_bm) {
        if (original_bm == null) {
            return null;
        }
        int w = original_bm.getWidth(); // 得到图片的宽，高
        int h = original_bm.getHeight();
        int cropWidth = w / 2;// 裁切后所取的正方形区域边长
        int cropHeight = h / 2;
        return Bitmap.createBitmap(original_bm, w/3, h/3, cropWidth, cropHeight, null, false);
    }

    private Bitmap scaleBitmapByValue(Bitmap original_bm, int newWidth, int newHeight) {//按数值缩放
        if (original_bm==null) {
            return null;
        }
        int height=original_bm.getHeight();
        int width=original_bm.getWidth();
        float scaleWidth=((float)newWidth)/width;
        float scaleHeight=((float)newHeight)/height;
        Matrix matrix=new Matrix();
        matrix.postScale(scaleWidth,scaleHeight);
        Bitmap new_bm=Bitmap.createBitmap(original_bm,0,0,width,height,matrix,false);
        if (!original_bm.isRecycled()){
            original_bm.recycle();
        }
        return new_bm;
    }
    private Bitmap scaleBitmap(Bitmap origin, float ratio) {
        if (origin == null) {
            return null;
        }
        int width = origin.getWidth();
        int height = origin.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(ratio, ratio);
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (newBM.equals(origin)) {
            return newBM;
        }
        origin.recycle();
        return newBM;
    }
}