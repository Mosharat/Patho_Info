package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ArthritisActivity extends AppCompatActivity {

    private ListView  arthritislistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arthritis);

        this.setTitle("Arthritis Diseases");

        arthritislistview = findViewById(R.id. arthritislistviewid);

        String[]  arthritistest= getResources().getStringArray(R.array. Arthritis);
        ArrayList arrayList= new ArrayList(Arrays.asList( arthritistest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( ArthritisActivity.this,android.R.layout.simple_list_item_1,arrayList);
        arthritislistview.setAdapter(adapter);
    }
}