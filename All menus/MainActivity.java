package com.example.allmenus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView l;
    String Contacts[] = {"Rohith", "Rojin"};
Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Contacts);
        l.setAdapter(adapter);
        registerForContextMenu(l);
        b1=(Button) findViewById(R.id.btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pop=new PopupMenu(MainActivity.this,b1);
                pop.getMenuInflater().inflate(R.menu.menus, pop.getMenu());

                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem Item) {
                        Toast.makeText(MainActivity.this, "You Clicked: " +Item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                pop.show();
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menus,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.cut:
                return true;
            case R.id.copy:
                return true;
            case R.id.exit:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        menu.setHeaderTitle("Select the Action");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.cut) {
            Toast.makeText(getApplicationContext(), "Copy code Invoked", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.copy) {
            Toast.makeText(getApplicationContext(), "Copy code Invoked", Toast.LENGTH_LONG).show();
        }
        else if (item.getItemId() == R.id.exit) {
            Toast.makeText(getApplicationContext(), "Exit Code Invoked", Toast.LENGTH_LONG).show();
        }
        else {
            return false;
        }
        return true;
    }
}