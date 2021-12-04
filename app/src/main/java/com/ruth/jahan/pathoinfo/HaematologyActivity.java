package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;

public class HaematologyActivity extends AppCompatActivity {

    private ListView haematologylistview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haematology);
        this.setTitle("Haematology");

        haematologylistview = findViewById(R.id.haematologylistviewid);

        String[] haematologytest= getResources().getStringArray(R.array.Haematology);
        ArrayList arrayList= new ArrayList(Arrays.asList(haematologytest));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(HaematologyActivity.this,android.R.layout.simple_list_item_1,arrayList);
        haematologylistview.setAdapter(adapter);

    }
}