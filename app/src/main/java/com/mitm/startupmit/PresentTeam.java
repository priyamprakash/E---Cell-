package com.mitm.startupmit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PresentTeam extends AppCompatActivity {
    List<Team_Model> teamList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_team);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView myTitleToolbar = findViewById(R.id.myTitleToolbar);
        myTitleToolbar.setText("Members");

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
                        "Naveed Hasan",
                        "priyamprakash99@gmail.com",
                        "2017,CE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Sandip Kumar",
                        "ravi9@gmail.com",
                        "2O18,CE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Harsh Kumar",
                        "priyamprakash99@gmail.com",
                        "2017,ME",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Pratyush Chandra",
                        "ravi9@gmail.com",
                        "2017,ME",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Ravi Ranjan",
                        "priyamprakash99@gmail.com",
                        "2018,ECE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Om Prakash",
                        "ravi9@gmail.com",
                        "2018,ME",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Abhinav Kishor",
                        "priyamprakash99@gmail.com",
                        "2017,EE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Khusboo Anad",
                        "ravi9@gmail.com",
                        "2017,EE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Md. Qamar Jaiwad",
                        "priyamprakash99@gmail.com",
                        "2018,EE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Aadil Raza",
                        "ravi9@=.com",
                        "2017,ECE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Priyam Prakash",
                        "priyamprakash99@gmail.com",
                        "2018,ECE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Saummya Singh",
                        "ravi9@gmail.com",
                        "2018,ECE",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Shubham Kumar",
                        "priyamprakash99@gmail.com",
                        "22017,IT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Kumar Shivam",
                        "ravi9@gmail.com",
                        "2017,IT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Suryakant Vishal",
                        "priyamprakash99@gmail.com",
                        "2018,IT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Ravi Kumar",
                        "ravi9@gmail.com",
                        "2018,IT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Vishwajeet",
                        "priyamprakash99@gmail.com",
                        "2017,LT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Abhishek Aman",
                        "ravi9@gmail.com",
                        "2017,LT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));
        //adding some items to our list
        teamList.add(
                new Team_Model(
                        1,
                        "Rushali Raj",
                        "priyamprakash99@gmail.com",
                        "2018,LT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));

        teamList.add(
                new Team_Model(
                        1,
                        "Ayush Ranjan",
                        "ravi9@gmail.com",
                        "2018,LT",
                        "Student Coordinator",
                        "https://i.ibb.co/BN77dgy/pratyush1.jpg",
                        R.drawable.placeholder));


        Team_Adapter adapter = new Team_Adapter(this, teamList);
        recyclerView.setAdapter(adapter);


    }
}