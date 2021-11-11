package com.mitm.startupmit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EcellFamily extends AppCompatActivity {
    List<Team_Model> teamList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecell_family);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView myTitleToolbar = findViewById(R.id.myTitleToolbar);
        myTitleToolbar.setText("Family");

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);//grid recycler
        recyclerView.setLayoutManager(gridLayoutManager);//grid

        teamList = new ArrayList<Team_Model>();


        //adding some items to our list


        teamList.add(
                new Team_Model(
                        1,
                        "Ashwinni Kumar",
                        "priyamprakash99@gmail.com",
                        "2015,CE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Rahul Raj",
                        "ravi9@gmail.com",
                        "2015,IT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list


        teamList.add(
                new Team_Model(
                        1,
                        "Jagat Narayan",
                        "ravi9@gmail.com",
                        "2016,CE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));



        Team_Adapter adapter = new Team_Adapter(this, teamList);
        recyclerView.setAdapter(adapter);
    }
}