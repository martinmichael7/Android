package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoked");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("lifecycle","onResume invoked");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("lifecycle","onStop is invoked");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("lifecycle","onRestart is invoked");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("lifecycle","onDestroy is invoked");
    }
@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.myapp,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.upload_item:
                return true;
            case R.id.app_bar_search:
                return true;
            case R.id.app_bar_switch:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}