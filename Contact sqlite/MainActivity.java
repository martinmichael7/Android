package com.example.contacrdbsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    TextView view;
    Button btninsert, btnlist, btnupdate, btndelete;
    EditText eid, ename;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninsert = (Button) findViewById(R.id.btninsert);
        btnlist = (Button) findViewById(R.id.btnlist);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btndelete = (Button) findViewById(R.id.btndelete);
        view = (TextView) findViewById(R.id.settext);
        eid = (EditText) findViewById(R.id.edittxt1);
        ename = (EditText) findViewById(R.id.edittxt2);

        try {
            db = openOrCreateDatabase("Contact", SQLiteDatabase.CREATE_IF_NECESSARY, null);
            db.execSQL("Create Table temp(id integer,name text)");
        } catch (SQLException e) {
        }

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("id", eid.getText().toString());
                values.put("name", ename.getText().toString());

                if ((db.insert("temp", null, values)) != -1) {
                    Toast.makeText(MainActivity.this, "Record successfully inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not inserted", Toast.LENGTH_SHORT).show();
                }

                eid.setText("");
                ename.setText("");
            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM temp", null);
                c.moveToFirst();
                StringBuilder str = new StringBuilder();
                while (!c.isAfterLast()) {
                    str.append(c.getString(0)).append(", ").append(c.getString(1)).append("\n");
                    c.moveToNext();
                }
                view.setText(str.toString());
                c.close();
            }
        });


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(eid.getText().toString());
                String name = ename.getText().toString();

                // Update the name of the record with the specified ID
                db.execSQL("UPDATE 'temp' SET name='" + name + "' WHERE id=" + id);
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(eid.getText().toString());
                db.execSQL("DELETE FROM 'temp' WHERE id=" + id);
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }
}
