package com.example.uiwidgettest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
   // private  AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.edit_text);
        imageView=(ImageView)findViewById(R.id.image_view);
        progressBar=(ProgressBar)findViewById(R.id.process_bar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                /**
                int progress=progressBar.getProgress();
                progress=progress+10;
                progressBar.setProgress(progress);
                String inputText=editText.getText().toString();
                Toast.makeText(MainActivity.this,"you input "+inputText,Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this,"you clicked button!",Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.img_2);

                if (progressBar.getVisibility()==View.GONE)
                {
                    progressBar.setVisibility(View.VISIBLE);

                }
                else progressBar.setVisibility(View.GONE);
                 */
                /**
                 对话框
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a dialog");
                dialog.setMessage("Somethig important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                 */
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is Progress Dialog");
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
                progressDialog.show();
                String inputText=editText.getText().toString();
                Toast.makeText(MainActivity.this,"you input "+inputText,Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                break;
            default:
                break;
        }
    }
}
