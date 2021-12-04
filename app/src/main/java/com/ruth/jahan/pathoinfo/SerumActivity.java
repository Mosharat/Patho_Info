package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerumActivity extends AppCompatActivity {

    private ListView serumlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serum);

        this.setTitle("Serum Electrolytes");

        serumlistview = findViewById(R.id.serumlistviewid);

        String[] serumtest= getResources().getStringArray(R.array.Serum);
        ArrayList arrayList= new ArrayList(Arrays.asList(serumtest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SerumActivity.this,android.R.layout.simple_list_item_1,arrayList);
        serumlistview.setAdapter(adapter);
    }
}