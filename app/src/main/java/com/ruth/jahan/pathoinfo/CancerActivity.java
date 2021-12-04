package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class CancerActivity extends AppCompatActivity {

    private ListView cancerlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancer);

        this.setTitle("Cancer Markers");

        cancerlistview = findViewById(R.id.cancerlistviewid);

        String[] cancertest= getResources().getStringArray(R.array.Cancer);
        ArrayList arrayList= new ArrayList(Arrays.asList(cancertest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CancerActivity.this,android.R.layout.simple_list_item_1,arrayList);
        cancerlistview.setAdapter(adapter);

    }
}