package com.example.mainintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class secondActivity extends AppCompatActivity {

      Button btn;
      EditText nm,age,gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent in =getIntent();

        btn = (Button) findViewById(R.id.button2);
        nm = (EditText) findViewById(R.id.editTextName);
        age  = (EditText) findViewById(R.id.editAge);
        gender = (EditText) findViewById(R.id.editGender);


         String name = in.getStringExtra("Name");
         String ageVal = in.getStringExtra("Age");
         String genderVal = in.getStringExtra("Gender");

         nm.setText(name);
         age.setText(ageVal);
         gender.setText(genderVal);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(secondActivity.this,MainActivity.class);

                startActivity(in);
            }
        });

    }
}