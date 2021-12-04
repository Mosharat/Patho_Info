package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class HistoActivity extends AppCompatActivity {

    private ListView histolistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histo);

        this.setTitle("HistoPathology");

        histolistview = findViewById(R.id.histolistviewid);

        String[] histotest= getResources().getStringArray(R.array.Histopathology);
        ArrayList arrayList= new ArrayList(Arrays.asList(histotest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(HistoActivity.this,android.R.layout.simple_list_item_1,arrayList);
        histolistview.setAdapter(adapter);
    }
}