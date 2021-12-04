package com.ruth.jahan.pathoinfo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Review> {

    private Activity context;
    private List<Review> reviewlist;

    public CustomAdapter(Activity context, List<Review> reviewlist) {
        super(context, R.layout.other_reviewsample, reviewlist);
        this.context = context;
        this.reviewlist = reviewlist;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= context.getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.other_reviewsample,null,true);

        Review review = reviewlist.get(position);
        TextView t1= view.findViewById(R.id.otherreviewlabnameid);
        TextView t2= view.findViewById(R.id.otherreviewcommentid);

        t1.setText("Labname : "+review.getLabname());
        t2.setText("Review : "+review.getComment());


        return view;
    }
}
