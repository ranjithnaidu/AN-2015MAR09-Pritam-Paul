package com.example.prpaul.todo_application;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.prpaul.todo_application.helper.DatabseHelper;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if (id == R.id.action_add) {
            openDialog();
            return true;
        }

        if (id == R.id.action_likeus) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openDialog()
    {
        final DatabseHelper helper = new DatabseHelper(this);

        LayoutInflater inflater = LayoutInflater.from(this);

        View promtView = inflater.inflate(R.layout.todo_add_layout,null);

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        final DatePicker dp = (DatePicker) promtView.findViewById(R.id.datePicker);
        final EditText name = (EditText) promtView.findViewById(R.id.name);
        final EditText desc = (EditText) promtView.findViewById(R.id.description);

        Button save = (Button) promtView.findViewById(R.id.save);
        Button cancel = (Button) promtView.findViewById(R.id.cancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = name.getText().toString();
                String strDesc = desc.getText().toString();
                String dateSelected = (dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear());

                Log.d("Title :: ", strName);
                Log.d("Description :: ", strDesc);
                Log.d("Date :: ", dateSelected);

                helper.insertTask(strName,strDesc,dateSelected);

               // display.setText(strName + "\n" + strEmail);
                alertDialog.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });

        alertDialog.setView(promtView);
        alertDialog.show();
    }
}
