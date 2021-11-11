package com.mitm.startupmit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Gallery extends AppCompatActivity {
    List<Gallery_Model> gallery_list;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView myTitleToolbar = findViewById(R.id.myTitleToolbar);
        myTitleToolbar.setText("Gallery");

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);//grid recycler
        recyclerView.setLayoutManager(gridLayoutManager);//grid

        gallery_list = new ArrayList<Gallery_Model>();

        gallery_list.add
                (
                new Gallery_Model
                        (
                                "https://i.ibb.co/BN77dgy/pratyush1.jpg"
                       )
                 );

        Log.d(TAG, "onCreate: " + gallery_list);


        GalleryAdapter adapter = new GalleryAdapter(this, gallery_list);
        recyclerView.setAdapter(adapter);

        
    }
}