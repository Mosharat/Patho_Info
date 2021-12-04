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
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReviewActivity extends AppCompatActivity {
    private Button donebutton,loadbutton;
    private EditText labnameedittext, reviewedittext;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        this.setTitle("Review");
        mAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("Review");

        donebutton = findViewById(R.id.donebuttonid);
        loadbutton = findViewById(R.id.loadbuttonid);
        labnameedittext = findViewById(R.id.reviewlabnameid);
        reviewedittext = findViewById(R.id.commentid);

        loadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewActivity.this,OtherReviewActivity.class);
                startActivity(intent);
            }
        });

        donebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givereview();
            }

        });

    }

    public void givereview() {

        String labname = labnameedittext.getText().toString().trim();
        String comment = reviewedittext.getText().toString().trim();

        String key = databaseReference.push().getKey();

        Review review = new Review(labname, comment);

        databaseReference.child(key).setValue(review);
        Toast.makeText(getApplicationContext(), "Your review is noted", Toast.LENGTH_SHORT).show();

        labnameedittext.setText("");
        reviewedittext.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.signoutid) {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.shareid) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "Pathology laboratory app";
            String body = "com.ruth.jahan.pathoinfo";

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);

            startActivity(Intent.createChooser(intent, "Share with"));
        }

        return super.onOptionsItemSelected(item);

    }

}
