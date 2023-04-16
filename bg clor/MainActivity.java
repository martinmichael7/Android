package com.example.mainintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText nm,Age;
    RadioButton m,f;
    String Radioval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.buttonmain);
        nm = (EditText) findViewById(R.id.editText);
        Age = (EditText) findViewById(R.id.editTextAge);
        m = (RadioButton) findViewById(R.id.radioButton);
        f =(RadioButton) findViewById(R.id.radioBtn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(m.isChecked()){
                    Radioval=m.getText().toString();
                }
                else if(f.isChecked()){
                    Radioval = f.getText().toString();
                }
                 String nameval = nm.getText().toString();
                 String age = Age.getText().toString();
                Intent in = new Intent(MainActivity.this,secondActivity.class);

                in.putExtra("Name",nameval);
                in.putExtra("Age", age);
                in.putExtra("Gender",Radioval);
                startActivity(in);

            }
        });

    }
}