package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddTestActivity extends AppCompatActivity implements RepositoryObserver  {

    private String insertDataURL = "https://pathoinfo.000webhostapp.com/addData.php";
    private static String TAG = AddTestActivity.class.getSimpleName();
    EditText newtestName, testtk;
    private Subject mUserDataRepository;
    private TextView newusernotificationtextview;
    //public static String newtest;
    //public static int cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);

        this.setTitle("Editors Dashboard");

        newusernotificationtextview = findViewById(R.id.newusernotificationtextviewid);
        newtestName=findViewById(R.id.addtestnameid);
        testtk=findViewById(R.id.testtkid);

        mUserDataRepository = UserDataRepository.getInstance();
        mUserDataRepository.registerObserver(this);

        Button button = findViewById(R.id.addtestbuttonid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertTestdata();
                Intent intent = new Intent(AddTestActivity.this,TestLabelActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onUserDataChanged(String username) { //int tk) {
      newusernotificationtextview.setText(username);
        //newtesttextview.setText(testname);
      //newtk.setText(tk);
    }



    ///>>>>.....Insert..........

    public void  insertTestdata() {
      // newtest=newtestName.getText().toString();
       //cost=Integer.valueOf(testtk.getText().toString());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, insertDataURL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


               newtestName.setText("");
               testtk.setText("");

               Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put("testname", newtestName.getText().toString());
                parameters.put("tk", testtk.getText().toString());

                return parameters;
            }
        };

        AppSingleton.getInstance(this).addToRequestQueue(stringRequest,TAG);
    }

}