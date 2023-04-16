package com.example.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText name;
String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.myname);
    }
    protected void onPause(){
        super.onPause();
        SharedPreferences s=getSharedPreferences("spfile",MODE_PRIVATE);
        SharedPreferences.Editor e=s.edit();
        e.putString("name","Amal Jyothi").toString();
        e.putInt("age",12).toString();
        e.commit();
        e.remove("name");
        e.commit();

    }
    protected void onResume(){
        super.onResume();
        SharedPreferences s=getSharedPreferences("spfile",MODE_PRIVATE);
        name.setText(s.getString("name","AJCE"));
        Toast.makeText(this, "My age"+age, Toast.LENGTH_SHORT).show();
    }
}