package com.mitm.startupmit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DeveloperActivity extends AppCompatActivity {
    TextView myTitleToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        myTitleToolbar = findViewById(R.id.myTitleToolbar);

        myTitleToolbar.setText("Developer");
    }
}