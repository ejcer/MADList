package com.example.emcenrue.madlists;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

//    private ArrayAdapter<String> mlistAdapter;
    private GenericAdapter genericAdapter;
    private ListView lv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("hello");
        stringArrayList.add("world");
        stringArrayList.add("!");


        lv = (ListView) findViewById(R.id.elListView);
        genericAdapter = new GenericAdapter(this, 0, stringArrayList);
//        mlistAdapter = new ArrayAdapter<String>(this, R.layout.item_row_generic,R.id.rowTextView, stringArrayList);



        lv.setAdapter(genericAdapter);
    }

}
