package com.ruth.jahan.pathoinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LabName extends AppCompatActivity {
    String[] st={"Agrani Pathology Laboratory", "Alpha Labs", "Adhunik Pathology and X-ray Clinic", "Basic Lab Chittagong","BD Lab",
            "Chevron Clinical Laboratory(Bandartila Branch)", "Chevron Clinical Laboratory(Agrabad Branch)",
            "Chevron Clinical Laboratory(O.R. Nizam Road Branch)", "Chittagong Lab", "Central Lab", "Chittagong Square",
            "CSCR(pvt.) Ltd.", "Diagnostic Centre", "Doctor's Lab", "Dr. Lal Path Labs", "Epic Health Care",
           "Echo Diagnostic Centre", "Ibne Sina", "Lab One Health Service", "Lab Asia", "LabAid Diagnostic Chattogram",
            "Modern Diagnostic Complex", "Metro Diagnostic Centre", "Niruponi Pathology Laboratory", "Popular Diagnostic Centre Ltd.",
            "Premier Diagnostic Centre", "SRL Diagnostics Chattogram", "Sigma Lab Limited", "Ultra Assay Dignostic Centre",
            "Woodland Dignostic Centre"};
    private ListView labnamelistview;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_name);
        this.setTitle("Lab Name");
        mAuth= FirebaseAuth.getInstance();

        labnamelistview = findViewById(R.id.labnamelistviewid);
      /*  String[] labnames = getResources().getStringArray(R.array.lab_names);*/

       /* ArrayAdapter<String> adapter=new ArrayAdapter<>(LabName.this,R.layout.labname_layout,R.id.labnametextviewid,labnames);*/
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,st);


        labnamelistview.setAdapter(adapter);
        labnamelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LabName.this,labinformation.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.signoutid){
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.shareid) {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject="Pathology laboratory app";
            String body="com.ruth.jahan.pathoinfo";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);

            startActivity(Intent.createChooser(intent,"Share with"));
        }

        return super.onOptionsItemSelected(item);

    }


}