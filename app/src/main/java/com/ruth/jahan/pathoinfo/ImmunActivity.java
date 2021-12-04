package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ImmunActivity extends AppCompatActivity {

    private ListView immunlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immun);

        this.setTitle("Immuno Histochemistry");

        immunlistview = findViewById(R.id.immunlistviewid);

        String[] immuntest= getResources().getStringArray(R.array.Immunohistochemistry);
        ArrayList arrayList= new ArrayList(Arrays.asList(immuntest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ImmunActivity.this,android.R.layout.simple_list_item_1,arrayList);
        immunlistview.setAdapter(adapter);
    }
}