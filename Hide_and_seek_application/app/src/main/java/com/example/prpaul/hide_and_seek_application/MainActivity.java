package com.example.prpaul.hide_and_seek_application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView textView;
    Button button;
    static boolean aBoolean = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hide_seek);
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
           if(aBoolean == false)
           {
               textView.setVisibility(View.VISIBLE);
               button.setText("HIDE");
               aBoolean = true;
           }
            else
           {
               textView.setVisibility(View.INVISIBLE);
               button.setText("SHOW");
               aBoolean = false;
           }
        }
    }
}
