package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class UrineActivity extends AppCompatActivity {

    private ListView  urinelistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urine);

        this.setTitle("Urine/Stool Sample");

        urinelistview = findViewById(R.id. urinelistviewid);

        String[]  urinetest= getResources().getStringArray(R.array. Urine);
        ArrayList arrayList= new ArrayList(Arrays.asList( urinetest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( UrineActivity.this,android.R.layout.simple_list_item_1,arrayList);
        urinelistview.setAdapter(adapter);
    }

}