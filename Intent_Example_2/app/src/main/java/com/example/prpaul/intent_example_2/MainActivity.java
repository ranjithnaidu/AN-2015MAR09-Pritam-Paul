package com.example.prpaul.intent_example_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    Button apps;
    Button settings;
    Button vibrate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apps = (Button)findViewById(R.id.button);
        settings = (Button)findViewById(R.id.button2);
        vibrate = (Button)findViewById(R.id.button3);

        apps.setOnClickListener(this);
        settings.setOnClickListener(this);
        vibrate.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
       int id = v.getId();
        switch(id){
            case R.id.button:
                Intent apps_intent = new Intent(this, AppsActivity.class);
                startActivity(apps_intent);
                break;
            case R.id.button2:
                Intent settings_intent = new Intent(this, SettingsActivity.class);
                startActivity(settings_intent);
                break;
            case R.id.button3:
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(400);
        }

    }
}
