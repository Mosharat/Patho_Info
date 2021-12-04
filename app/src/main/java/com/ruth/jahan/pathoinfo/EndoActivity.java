package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class EndoActivity extends AppCompatActivity {

    private ListView endolistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endo);

        this.setTitle("Endocrine Metabolic Disorder");

        endolistview = findViewById(R.id.endolistviewid);

        String[] endotest= getResources().getStringArray(R.array.Endocrine);
        ArrayList arrayList= new ArrayList(Arrays.asList(endotest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EndoActivity.this,android.R.layout.simple_list_item_1,arrayList);
        endolistview.setAdapter(adapter);
    }
}