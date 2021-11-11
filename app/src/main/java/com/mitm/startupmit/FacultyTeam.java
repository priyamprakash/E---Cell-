package com.mitm.startupmit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FacultyTeam extends AppCompatActivity {
    List<Team_Model> teamList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_team);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView myTitleToolbar = findViewById(R.id.myTitleToolbar);
        myTitleToolbar.setText("Faculties");

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);//grid recycler
        recyclerView.setLayoutManager(gridLayoutManager);//grid

        teamList = new ArrayList<Team_Model>();

        teamList.add(
                new Team_Model(
                        1,
                        "Mr. Mohit Kumar",
                        "ravi9@gmail.com",
                        "2018,ME",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Md. Irshad Alam",
                        "priyamprakash99@gmail.com",
                        "2017,EE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Dr. Subha Sinha",
                        "ravi9@gmail.com",
                        "2017,EE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Dr.Nayan Kumar",
                        "priyamprakash99@gmail.com",
                        "2018,EE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));



        Team_Adapter adapter = new Team_Adapter(this, teamList);
        recyclerView.setAdapter(adapter);


    }

}