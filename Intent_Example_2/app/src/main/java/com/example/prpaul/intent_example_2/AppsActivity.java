package com.example.prpaul.intent_example_2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by prpaul on 3/25/2015.
 */
public class AppsActivity extends Activity implements View.OnClickListener{

    Button specificApp;
    Button developer;
    Button search;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apps_activity);

        specificApp = (Button)findViewById(R.id.button4);
        developer =(Button)findViewById(R.id.button5);
        search = (Button)findViewById(R.id.button6);

        specificApp.setOnClickListener(this);
        developer.setOnClickListener(this);
        search.setOnClickListener(this);

        editText = (EditText)findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.button4:
                try{
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.facebook.katana")));
                }catch(android.content.ActivityNotFoundException anfe){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.facebook.katana")));
                }
                break;
            case R.id.button5:
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=Ranjith+naidu")));
                }catch(android.content.ActivityNotFoundException anfe){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Ranjith+naidu")));
                }
                break;
            case R.id.button6:
                String query = editText.getText().toString();
                Log.d("Apps Activity",query);
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q="+query)));
                }catch(android.content.ActivityNotFoundException anfe){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q="+query)));
                }
                break;
        }

    }
}
