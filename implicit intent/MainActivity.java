package com.example.implicitindent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.b1);
        btn2=(Button) findViewById(R.id.b2);
        btn3=(Button) findViewById(R.id.b3);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Intent in=new Intent(Intent.ACTION_VIEW, Uri.parse("https://login.aesajce.in/"));
                startActivity(in);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent in=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:987654321"));
                startActivity(in);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent in=new Intent(Intent.ACTION_SEND);
                in.setType("text/plain");
                in.putExtra(Intent.EXTRA_TEXT,"Hello..How Are You??");
                startActivity(in);
            }
        });
    }
}