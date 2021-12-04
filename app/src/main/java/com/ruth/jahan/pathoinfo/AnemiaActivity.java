package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class AnemiaActivity extends AppCompatActivity {

    private ListView anemialistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anemia);

        this.setTitle("Anemia Profile");

        anemialistview = findViewById(R.id.anemialistviewid);

        String[] anemiatest= getResources().getStringArray(R.array.Anemia);
        ArrayList arrayList= new ArrayList(Arrays.asList(anemiatest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AnemiaActivity.this,android.R.layout.simple_list_item_1,arrayList);
        anemialistview.setAdapter(adapter);

    }
}