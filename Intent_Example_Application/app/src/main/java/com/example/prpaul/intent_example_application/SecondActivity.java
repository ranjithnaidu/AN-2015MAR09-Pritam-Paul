package com.example.prpaul.intent_example_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by prpaul on 3/23/2015.
 */
public class SecondActivity extends Activity implements View.OnClickListener{

    Button button;
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        textView = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        String s = intent.getStringExtra("fromActivityOne");
        textView.setText(s);
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button2)
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
