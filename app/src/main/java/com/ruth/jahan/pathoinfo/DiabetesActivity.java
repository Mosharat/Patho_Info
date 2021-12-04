package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class DiabetesActivity extends AppCompatActivity {

    private ListView diabeteslistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes);

        this.setTitle("Diabetes");

        diabeteslistview = findViewById(R.id.diabeteslistviewid);

        String[] diabetestest= getResources().getStringArray(R.array.Diabetes);
        ArrayList arrayList= new ArrayList(Arrays.asList(diabetestest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DiabetesActivity.this,android.R.layout.simple_list_item_1,arrayList);
        diabeteslistview.setAdapter(adapter);
    }
}