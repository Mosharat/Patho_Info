package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ThyroidActivity extends AppCompatActivity {

    private ListView thyroidlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thyroid);

        this.setTitle("Thyroid Disorders");

        thyroidlistview = findViewById(R.id.thyroidlistviewid);

        String[] thyroidtest= getResources().getStringArray(R.array.Thyroid);
        ArrayList arrayList= new ArrayList(Arrays.asList(thyroidtest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThyroidActivity.this,android.R.layout.simple_list_item_1,arrayList);
        thyroidlistview.setAdapter(adapter);

    }
}