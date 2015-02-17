package com.example.emcenrue.madlists;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayAdapter<String> mlistAdapter;
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("hello");
        stringArrayList.add("world");
        stringArrayList.add("!");

        mlistAdapter = new ArrayAdapter<String>(this, 0, stringArrayList);

        lv.setAdapter(mlistAdapter);
    }

}
