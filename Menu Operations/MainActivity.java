package com.example.dropdownandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText first,second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first=(EditText) findViewById(R.id.first_input);
        second=(EditText) findViewById(R.id.second_input);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.operations, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int a,b;
        switch (item.getItemId()) {

            case R.id.add_item:
                a=Integer.parseInt(first.getText().toString());
                b=Integer.parseInt(second.getText().toString());
                Toast.makeText(this, "Sum is: " + (a+b), Toast.LENGTH_SHORT).show();
                return true;

            case R.id.sub_item:
                a=Integer.parseInt(first.getText().toString());
                b=Integer.parseInt(second.getText().toString());
                Toast.makeText(this, "Difference is: " +(a-b), Toast.LENGTH_SHORT).show();
                return true;

            case R.id.multi_item:
                a=Integer.parseInt(first.getText().toString());
                b=Integer.parseInt(second.getText().toString());
                Toast.makeText(this, "Value is: " +(a*b), Toast.LENGTH_SHORT).show();
                return true;

            case R.id.divide_item:
                a=Integer.parseInt(first.getText().toString());
                b=Integer.parseInt(second.getText().toString());
                Toast.makeText(this, "Value is: " +(a/b), Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}