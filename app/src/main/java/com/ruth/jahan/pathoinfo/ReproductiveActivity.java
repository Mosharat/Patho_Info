package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ReproductiveActivity extends AppCompatActivity {

    private ListView reproductivelistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductive);

        this.setTitle("Reproductive Tests");

        reproductivelistview = findViewById(R.id.reproductivelistviewid);

        String[] reproductivetest= getResources().getStringArray(R.array.Reproductive);
        ArrayList arrayList= new ArrayList(Arrays.asList(reproductivetest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ReproductiveActivity.this,android.R.layout.simple_list_item_1,arrayList);
        reproductivelistview.setAdapter(adapter);
    }
}