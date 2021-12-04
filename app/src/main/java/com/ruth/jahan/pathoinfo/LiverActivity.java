package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSmoothScroller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiverActivity extends AppCompatActivity {

    private ListView liverlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liver);

        this.setTitle("Liver Diseases");

        liverlistview = findViewById(R.id.liverlistviewid);

        String[] livertest= getResources().getStringArray(R.array.Liver);
        ArrayList arrayList= new ArrayList(Arrays.asList(livertest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LiverActivity.this,android.R.layout.simple_list_item_1,arrayList);
        liverlistview.setAdapter(adapter);
    }
}