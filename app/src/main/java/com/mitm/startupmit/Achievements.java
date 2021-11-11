package com.mitm.startupmit;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

@Keep
public class Achievements extends AppCompatActivity {
    private static final String TAG = "Notification_Activity";
    private RecyclerView recyclerView;
    private AchievementsAdapter adapter;
    TextView myTitleToolbar;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar = findViewById(R.id.toolbarCustom);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler);
        myTitleToolbar = findViewById(R.id.myTitleToolbar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        /**
         * the next two lines can be used to reverse the list so that the recent comes on top
         */
        linearLayoutManager.setReverseLayout(true);//to reverse the list
        linearLayoutManager.setStackFromEnd(true);//to reverse the list
        myTitleToolbar.setText("Achievement");

        recyclerView.setLayoutManager(linearLayoutManager);

        FirebaseRecyclerOptions<Achievements_model> options =
                new FirebaseRecyclerOptions.Builder<Achievements_model>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("Achievements"),
                                Achievements_model.class).build();



        adapter = new AchievementsAdapter
                (Achievements.this,options);
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: adapter "+ adapter);

    }

    //to start
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    //to stop
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}