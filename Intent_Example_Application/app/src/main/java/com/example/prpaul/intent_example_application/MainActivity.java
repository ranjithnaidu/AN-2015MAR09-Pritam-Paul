package com.example.prpaul.intent_example_application;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.view.View.OnClickListener;


public class MainActivity extends Activity implements OnClickListener {

    Button button;
    Button googlesearch;
    Button dial;
    Button call;
    Button wireless;
    Button bluetooth;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener((OnClickListener) this);

        googlesearch = (Button)findViewById(R.id.button3);
        googlesearch.setOnClickListener((OnClickListener) this);

        dial = (Button)findViewById(R.id.button4);
        dial.setOnClickListener((OnClickListener) this);

        call = (Button)findViewById(R.id.button5);
        call.setOnClickListener((OnClickListener) this);

        wireless = (Button)findViewById(R.id.button6);
        wireless.setOnClickListener((OnClickListener) this);

        bluetooth = (Button)findViewById(R.id.button7);
        bluetooth.setOnClickListener((OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id)
        {
            case R.id.button :
                Intent i = new Intent(this, SecondActivity.class);
                String s = editText.getText().toString();
                i.putExtra("fromActivityOne",s);
                startActivity(i);
                break;
            case R.id.button3 :
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(intent);
                break;
            case R.id.button4 :
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8186734263"));
                startActivity(intent1);
                break;
            case R.id.button5 :
                Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8186734263"));
                startActivity(intent2);
                break;
            case R.id.button6 :
                Intent intent3 = new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK);
                startActivity(intent3);
                break;
            case R.id.button7 :
                Intent intent4 = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent4);
                break;
        }
    }
}
