package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4;
EditText ed1,ed2,ed3;
int a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.btnsubmit);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        ed1=(EditText) findViewById(R.id.ed1);
        ed2=(EditText) findViewById(R.id.ed2);
        ed3=(EditText) findViewById(R.id.result);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=Integer.parseInt(ed1.getText().toString());
                b=Integer.parseInt(ed2.getText().toString());
                c=a+b;
                ed3.setText("Result is "+c);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=Integer.parseInt(ed1.getText().toString());
                b=Integer.parseInt(ed2.getText().toString());
                c=a-b;
                ed3.setText("Result is "+c);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=Integer.parseInt(ed1.getText().toString());
                b=Integer.parseInt(ed2.getText().toString());
                c=a*b;
                ed3.setText("Result is "+c);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=Integer.parseInt(ed1.getText().toString());
                b=Integer.parseInt(ed2.getText().toString());
                c=a/b;
                ed3.setText("Result is "+c);
            }
        });
    }
}