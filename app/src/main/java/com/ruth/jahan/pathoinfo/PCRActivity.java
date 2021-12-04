package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PCRActivity extends AppCompatActivity {

    private ListView pcrlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_c_r);

        this.setTitle("PCR");

        pcrlistview = findViewById(R.id. pcrlistviewid);

        String[]  pcrtest= getResources().getStringArray(R.array.PCR);
        ArrayList arrayList= new ArrayList(Arrays.asList( pcrtest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PCRActivity.this,android.R.layout.simple_list_item_1,arrayList);
        pcrlistview.setAdapter(adapter);
    }
}