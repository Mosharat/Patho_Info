package com.ruth.jahan.pathoinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Aboutlab extends AppCompatActivity {

    private TextView textView;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutlab);
        mAuth= FirebaseAuth.getInstance();

        textView=findViewById(R.id.textviewid);

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            String buttonname=bundle.getString("name");
            showDetails(buttonname);
        }

    }

    private void showDetails(String buttonname) {
        if (buttonname.equals("aboutlab")){
            textView.setText(R.string.about_text);
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