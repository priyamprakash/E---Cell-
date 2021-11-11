package com.mitm.startupmit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

public class TeamList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
    }

    public void faculty(View view) {
try {
    Intent i = new Intent(TeamList.this, FacultyTeam.class);
    startActivity(i);
}catch (Exception e)
{
    Log.d(TAG, "faculty: " + e);
}

    }

    public void student(View view) {
        Intent i = new Intent(TeamList.this , PresentTeam.class);
        startActivity(i);

    }

    public void family(View view) {
        Intent i = new Intent(TeamList.this , EcellFamily.class);
        startActivity(i);

    }
}