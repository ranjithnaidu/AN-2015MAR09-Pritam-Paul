package com.example.prpaul.database_exercise_application;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends ActionBarActivity {

    SQLiteItemSearch sqllitebb;
    AutoCompleteTextView actv;
    String[] deal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        sqllitebb = new SQLiteItemSearch(this);

        sqllitebb.insertitemSearch("Color Monitor");
        sqllitebb.insertitemSearch("Compact Disk");
        sqllitebb.insertitemSearch("Computer");
        sqllitebb.insertitemSearch("Hard Disk");
        sqllitebb.insertitemSearch("HP Printer");

        deal = sqllitebb.getAllItemFilter();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, deal);
        actv.setAdapter(adapter);
        actv.setThreshold(1);
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                arg0.getItemAtPosition(arg2);
                }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
