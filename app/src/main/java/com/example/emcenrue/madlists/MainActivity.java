package com.example.emcenrue.madlists;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.emcenrue.madlists.util.StringListUtil;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

//    private ArrayAdapter<String> mlistAdapter;
    private GenericAdapter genericAdapter;
    private ListView lv;
    ArrayList<String> stringArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        stringArrayList = new ArrayList<String>();
        stringArrayList.add("hello");
        stringArrayList.add("world");
        stringArrayList.add("!");

        stringArrayList = StringListUtil.readWords(this);


        lv = (ListView) findViewById(R.id.elListView);
        genericAdapter = new GenericAdapter(this, 0, stringArrayList);
        lv.setAdapter(genericAdapter);


        Button addGoalButton = (Button) findViewById(R.id.button);
        addGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textField = (EditText) findViewById(R.id.editText);
                stringArrayList.add(textField.getText().toString());
                StringListUtil.writeWordsToFile(stringArrayList, getApplicationContext());
                genericAdapter.notifyDataSetChanged();
            }
        });
    }
}
