package com.ruth.jahan.pathoinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class LoadtestnameActivity extends AppCompatActivity {

    ListView loaddatalistview;
    ArrayList<String>holder= new ArrayList<>();

    private static final String loaddataurl= "https://pathoinfo.000webhostapp.com/json_fetch.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadtestname);
        this.setTitle("Recently Added Tests");

        fetchdata();
    }

    public void fetchdata(){
        loaddatalistview= findViewById(R.id.loaddatalistviewid);

        class dbManager extends AsyncTask<String,Void,String>{

            protected void onPostExecute(String data)
            {
                try {
                    JSONArray ja= new JSONArray(data);
                    JSONObject jo= null;

                    holder.clear();
                    for (int i=0;i<ja.length();i++){
                        jo= ja.getJSONObject(i);

                        String testname= jo.getString("testname");
                        holder.add(testname);

                        String tk= jo.getString("tk");
                        holder.add(tk);
                    }
                    ArrayAdapter<String> at=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,holder);
                    loaddatalistview.setAdapter(at);
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            protected String doInBackground(String... Strings)
            {
                try {
                    URL url= new URL(Strings[0]);
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));

                    StringBuffer data= new StringBuffer();
                    String line;

                    while ((line=br.readLine())!=null)
                    {
                        data.append(line+"\n");
                    }

                    br.close();

                    return data.toString();
                }

                catch (Exception ex)
                {
                    return ex.getMessage();
                }

            }


        }

        dbManager obj= new dbManager();
        obj.execute(loaddataurl);


    }
}