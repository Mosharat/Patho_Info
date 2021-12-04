package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MicrobioActivity extends AppCompatActivity {

    private ListView microbiolistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microbio);

        this.setTitle("Microbiology");

        microbiolistview = findViewById(R.id.microbiolistviewid);

        String[] microbiotest= getResources().getStringArray(R.array.Microbiology);
        ArrayList arrayList= new ArrayList(Arrays.asList(microbiotest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MicrobioActivity.this,android.R.layout.simple_list_item_1,arrayList);
        microbiolistview.setAdapter(adapter);
    }
}