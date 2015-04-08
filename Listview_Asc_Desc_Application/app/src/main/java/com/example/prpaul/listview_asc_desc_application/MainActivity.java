package com.example.prpaul.listview_asc_desc_application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    ListView view;
    Button Asc;
    Button Desc;
    ArrayAdapter<String> adapter;

    String data[] = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(ListView)findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,data);
        view.setAdapter(adapter);
        Asc=(Button)findViewById(R.id.asc);
        Asc.setOnClickListener(this);
        Desc=(Button)findViewById(R.id.desc);
        Desc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch(id)
        {
            case R.id.asc:
                Arrays.sort(data);
                adapter.notifyDataSetChanged();
                break;
            case R.id.desc:
                Arrays.sort(data);
                List<String> list = Arrays.asList(data);
                Collections.reverse(list);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
