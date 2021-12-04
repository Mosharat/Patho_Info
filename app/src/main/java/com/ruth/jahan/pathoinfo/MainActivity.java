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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity { //implements RepositoryObserver

  private Button showlabinfobutton,reviewbutton;
    //private Subject mUserDataRepository;
    //private TextView newtesttextview;
    //private TextView newtk;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth= FirebaseAuth.getInstance();

        showlabinfobutton= findViewById(R.id.showlabinfobuttonid);
      //  newtesttextview = (TextView) findViewById(R.id.newtesttextviewid);
       // newtk = (TextView) findViewById(R.id.newtktextviewid);

        //mUserDataRepository = UserDataRepository.getInstance();
        //mUserDataRepository.registerObserver(this);


        showlabinfobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent labinfotolabname = new Intent(MainActivity.this,LabName.class);
                startActivity(labinfotolabname);
            }
        });

        reviewbutton= findViewById(R.id.reviewbuttonid);
        reviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent review=new Intent(MainActivity.this,ReviewActivity.class);
                startActivity(review);
            }
        });
    }

    //@Override
    //public void onUserDataChanged(String testname, int tk) {
      //  newtesttextview.setText(testname);
        //newtk.setText(tk);
    //}



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