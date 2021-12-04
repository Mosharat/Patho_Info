package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class InfectionActivity extends AppCompatActivity {

    private ListView infectionlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infection);

        this.setTitle("Infectious Diseases");

        infectionlistview = findViewById(R.id.infectionlistviewid);

        String[] infectiontest= getResources().getStringArray(R.array.Infection);
        ArrayList arrayList= new ArrayList(Arrays.asList(infectiontest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(InfectionActivity.this,android.R.layout.simple_list_item_1,arrayList);
        infectionlistview.setAdapter(adapter);
    }
}