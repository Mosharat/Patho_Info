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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.auth.FirebaseAuth;

public class TestLabelActivity extends AppCompatActivity {

    private ListView listview;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_label);
        this.setTitle("Tests");
        mAuth= FirebaseAuth.getInstance();

        listview = findViewById(R.id.testlabellistviewid);

        String[] testlabels= getResources().getStringArray(R.array.Testlabel);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TestLabelActivity.this,R.layout.testlabel_sampleview,R.id.testlabeltextviewid,testlabels);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position== 0){
                    Intent intent= new Intent(view.getContext(),HaematologyActivity.class);
                    startActivity(intent);
                }
                else if (position== 1){
                    Intent intent= new Intent(view.getContext(),DiabetesActivity.class);
                    startActivity(intent);
                }
                else if (position== 2){
                    Intent intent= new Intent(view.getContext(),KidneyActivity.class);
                    startActivity(intent);
                }
                else if (position== 3){
                    Intent intent= new Intent(view.getContext(),LiverActivity.class);
                    startActivity(intent);
                }
                else if (position== 4){
                    Intent intent= new Intent(view.getContext(),HeartActivity.class);
                    startActivity(intent);
                }
                else if (position== 5){
                    Intent intent= new Intent(view.getContext(),CancerActivity.class);
                    startActivity(intent);
                }
                else if (position== 6){
                    Intent intent= new Intent(view.getContext(),ReproductiveActivity.class);
                    startActivity(intent);
                }
                else if (position== 7){
                    Intent intent= new Intent(view.getContext(),UrineActivity.class);
                    startActivity(intent);
                }
                else if (position== 8){
                    Intent intent= new Intent(view.getContext(),ThyroidActivity.class);
                    startActivity(intent);
                }
                else if (position== 9){
                    Intent intent= new Intent(view.getContext(),ArthritisActivity.class);
                    startActivity(intent);
                }
                else if (position== 10){
                    Intent intent= new Intent(view.getContext(),MicrobioActivity.class);
                    startActivity(intent);
                }
                else if (position== 11){
                    Intent intent= new Intent(view.getContext(),AnemiaActivity.class);
                    startActivity(intent);
                }
                else if (position== 12){
                    Intent intent= new Intent(view.getContext(),SerumActivity.class);
                    startActivity(intent);
                }
                else if (position== 13){
                    Intent intent= new Intent(view.getContext(),InfectionActivity.class);
                    startActivity(intent);
                }
                else if (position== 14){
                    Intent intent= new Intent(view.getContext(),HistoActivity.class);
                    startActivity(intent);
                }
                else if (position== 15){
                    Intent intent= new Intent(view.getContext(),AllergyActivity.class);
                    startActivity(intent);
                }
                else if (position== 16){
                    Intent intent= new Intent(view.getContext(),PCRActivity.class);
                    startActivity(intent);
                }
                else if (position== 17){
                    Intent intent= new Intent(view.getContext(),EndoActivity.class);
                    startActivity(intent);
                }
                else if (position== 18){
                    Intent intent= new Intent(view.getContext(),ImmunActivity.class);
                    startActivity(intent);
                }
                else if (position== 19){
                    Intent intent= new Intent(view.getContext(),LoadtestnameActivity.class);
                    startActivity(intent);
                }

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