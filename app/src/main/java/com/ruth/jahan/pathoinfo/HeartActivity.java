package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class HeartActivity extends AppCompatActivity {

    private ListView heartlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);

        this.setTitle("Heart Diseases");

        heartlistview = findViewById(R.id.heartlistviewid);

        String[] hearttest= getResources().getStringArray(R.array.Heart);
        ArrayList arrayList= new ArrayList(Arrays.asList(hearttest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(HeartActivity.this,android.R.layout.simple_list_item_1,arrayList);
        heartlistview.setAdapter(adapter);

    }
}