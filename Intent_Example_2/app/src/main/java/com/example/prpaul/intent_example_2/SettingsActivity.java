package com.example.prpaul.intent_example_2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by prpaul on 3/30/2015.
 */
public class SettingsActivity extends Activity implements View.OnClickListener{

    Button wifi;
    Button bluetooth;
    Button addaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        wifi = (Button)findViewById(R.id.button7);
        bluetooth =(Button)findViewById(R.id.button8);
        addaccount = (Button)findViewById(R.id.button9);

        wifi.setOnClickListener(this);
        bluetooth.setOnClickListener(this);
        addaccount.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id)
        {
            case R.id.button7 :
                Intent wifi = new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK);
                startActivity(wifi);
                break;
            case R.id.button8 :
                Intent bluetooth = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(bluetooth);
                break;
            case R.id.button9 :
                Intent addaccount = new Intent(Settings.ACTION_ADD_ACCOUNT);
                startActivity(addaccount);
                break;
        }
    }
}
