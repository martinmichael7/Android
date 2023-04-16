package com.example.fmsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1,b2,b3;
    TextView t1;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.freq_edtxt);
        b1 = (Button) findViewById(R.id.btn_scan);
        b2 = (Button) findViewById(R.id.btn_pre);
        b3 = (Button) findViewById(R.id.btn_nxt);
        t1 = (TextView) findViewById(R.id.list_txt);

        SharedPreferences sp = getSharedPreferences("mychannel",MODE_PRIVATE);
        List<String> items = new ArrayList<String>();
        items.add("89.15");
        items.add("89.45");
        items.add("90.00");
        items.add("98.75");
        items.add("99.15");
        items.add("102.3");
        Set<String> itemsSet = new HashSet<String>(items);
        SharedPreferences.Editor ed = sp.edit();
        ed.putStringSet("items", itemsSet);
        ed.apply();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("mychannel",MODE_PRIVATE);
                Set<String> itemsSet = sp.getStringSet("items", new HashSet<String>());
                List<String> itemsList = new ArrayList<String>(itemsSet);

                // Loop through the items and add them to the TextView
                StringBuilder stringBuilder = new StringBuilder();
                for (String item : itemsList) {
                    stringBuilder.append(item).append("\n");
                }
                t1.setText(stringBuilder.toString());

                if (itemsList.size() > 0) {
                    e1.setText(itemsList.get(counter));
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("mychannel",MODE_PRIVATE);
                Set<String> itemsSet = sp.getStringSet("items", new HashSet<String>());
                List<String> itemsList = new ArrayList<String>(itemsSet);

                counter--;

                if (counter < 0) {
                    counter = itemsList.size() - 1;
                }
                e1.setText(itemsList.get(counter));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("mychannel",MODE_PRIVATE);
                Set<String> itemsSet = sp.getStringSet("items", new HashSet<String>());
                List<String> itemsList = new ArrayList<String>(itemsSet);

                counter++;

                if (counter >= itemsList.size()) {
                    counter = 0;
                }
                e1.setText(itemsList.get(counter));
            }
        });
    }
}