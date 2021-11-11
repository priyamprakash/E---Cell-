package com.mitm.startupmit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static android.content.ContentValues.TAG;

public class MemberDetails extends AppCompatActivity {
    TextView name, email, batch, url, designation;
    int id;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = findViewById(R.id.name2);
        email = findViewById(R.id.email2);
        batch = findViewById(R.id.batch2);
        designation = findViewById(R.id.designation2);
        pic = findViewById(R.id.image2);
        try {
            String name1 = getIntent().getStringExtra("name");
            String email1 = getIntent().getStringExtra("email");
            String batch1 = getIntent().getStringExtra("batch");
            String designation1 = getIntent().getStringExtra("designation");
            String url1 = getIntent().getStringExtra("url");


            name.setText(name1);
            email.setText(email1);
            batch.setText(batch1);
            designation.setText(designation1);


        Glide.with(MemberDetails.this)
                .load(url1)
                .placeholder(R.drawable.startup_logo)
                .into(pic);
        } catch (Exception e) {
            Log.d(TAG, "onCreate: " + e);
        }


    }
}