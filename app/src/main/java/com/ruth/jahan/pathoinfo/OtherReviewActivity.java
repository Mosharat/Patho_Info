package com.ruth.jahan.pathoinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OtherReviewActivity extends AppCompatActivity {


    private ListView listView;
    DatabaseReference databaseReference;
    private List<Review> reviewList;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_review);


        databaseReference = FirebaseDatabase.getInstance().getReference("Review");
        reviewList = new ArrayList<>();
        customAdapter = new CustomAdapter(OtherReviewActivity.this,reviewList);
        listView = findViewById(R.id.otherreviewlistid);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                reviewList.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Review review = dataSnapshot1.getValue(Review.class);
                    reviewList.add(review);
                }

                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}