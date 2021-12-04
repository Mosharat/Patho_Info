package com.ruth.jahan.pathoinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class labinformation extends AppCompatActivity implements View.OnClickListener {

    private Button aboutbutton,testinfobutton;
    private Intent intent;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labinformation);
        this.setTitle("Lab Info");
        mAuth= FirebaseAuth.getInstance();

        aboutbutton=findViewById(R.id.aboutid);
        testinfobutton=findViewById(R.id.testinfoid);

        aboutbutton.setOnClickListener(this);
        testinfobutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.aboutid){
            intent=new Intent(labinformation.this,Aboutlab.class);
            intent.putExtra("name","aboutlab");
            startActivity(intent);
        }


        if (v.getId()==R.id.testinfoid){
            intent=new Intent(labinformation.this,TestLabelActivity.class);
            intent.putExtra("name","testinfolab");
            startActivity(intent);
        }

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