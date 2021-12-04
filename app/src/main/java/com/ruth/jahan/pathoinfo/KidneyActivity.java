package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class KidneyActivity extends AppCompatActivity {

    private ListView kidneylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kidney);

        this.setTitle("Kidney Diseases");

        kidneylistview = findViewById(R.id.kidneylistviewid);

        String[] kidneytest= getResources().getStringArray(R.array.Kidney);
        ArrayList arrayList= new ArrayList(Arrays.asList(kidneytest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(KidneyActivity.this,android.R.layout.simple_list_item_1,arrayList);
        kidneylistview.setAdapter(adapter);
    }
}