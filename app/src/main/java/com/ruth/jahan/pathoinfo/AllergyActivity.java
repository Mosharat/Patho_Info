package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class AllergyActivity extends AppCompatActivity {

    private ListView allergylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy);

        this.setTitle("Allergy Tests");

        allergylistview = findViewById(R.id.allergylistviewid);

        String[] allergytest= getResources().getStringArray(R.array.Allergy);
        ArrayList arrayList= new ArrayList(Arrays.asList(allergytest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllergyActivity.this,android.R.layout.simple_list_item_1,arrayList);
        allergylistview.setAdapter(adapter);

    }
}