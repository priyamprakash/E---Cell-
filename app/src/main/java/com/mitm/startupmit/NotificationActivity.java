package com.mitm.startupmit;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
@Keep
public class NotificationActivity extends AppCompatActivity {
    private static final String TAG = "NotificationActivity";
    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    TextView myTitleToolbar;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
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
        myTitleToolbar.setText("UPDATES");

        recyclerView.setLayoutManager(linearLayoutManager);


        FirebaseRecyclerOptions<Notification_Model> options =
                new FirebaseRecyclerOptions.Builder<Notification_Model>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("Notifications"),
                                Notification_Model.class).build();



        adapter = new NotificationAdapter(NotificationActivity.this,options);
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: adapter "+ adapter);

    }



    public void fb(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/startupmitm"));
        startActivity(browserIntent);
//        https://www.facebook.com/startupmitm
    }

    public void insta(View view) {
    }

    public void mail(View view) {
    }

    public void bell(View view) {
        Toast.makeText(this, "Get the Latest update here", Toast.LENGTH_SHORT).show();
    }
    public void share(View view) {
        Intent shareintent = new Intent(Intent.ACTION_SEND);
        shareintent.setType("text/plain");
        String shareBody = "Download STARTUP MIT app now from GOOGLE PLAY STORE :- http://play.google.com/store/apps/details?id=com.mitm.startupmit&hl=en";
        String sharesub = "STARTUP MIT";
        shareintent.putExtra(Intent.EXTRA_SUBJECT, sharesub);
        shareintent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(shareintent, "Share Using:"));
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