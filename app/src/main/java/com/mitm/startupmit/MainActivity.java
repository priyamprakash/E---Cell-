package com.mitm.startupmit;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

@Keep
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView myTitleToolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ImageView drawer_icon;
    String title, message = "";
    Button logout;

    private DatabaseReference databaseReference;
    TextView notification_title, notification_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        logout = findViewById(R.id.logout);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(MainActivity.this, LoginActivity.class)//StartActivity tha  pehle
//                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
//                finish();// to destroy this
//            }
//        });
        myTitleToolbar = findViewById(R.id.myTitleToolbar);
        myTitleToolbar.setText("EXIGENCY");


        databaseReference = FirebaseDatabase
                .getInstance().getReference().child("An_Update").child("1");
        notification_title = findViewById(R.id.notification_title);
        notification_text = findViewById(R.id.notification_text);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.d(TAG, "onDataChange: "+ snapshot.child("Latest_message") +"      " +snapshot.child("Latest_Title"));

                message =  snapshot.child("Latest_message").getValue().toString();
                title =  snapshot.child("Latest_Title").getValue().toString();
                notification_text.setText(message);
                notification_title.setText(title);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawer_icon = findViewById(R.id.drawer);
        drawer_icon.setVisibility(View.VISIBLE);
        drawer_icon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // open drawer here

                drawerLayout.openDrawer(Gravity.LEFT);

            }
        });
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.ic_mir);
    }


    public void about_ecell(View view) {
        Intent i = new Intent(MainActivity.this, About_cell.class);
        startActivity(i);
    }

    public void about_mit(View view) {
        Intent i = new Intent(MainActivity.this, AboutMit.class);
        startActivity(i);
    }

    public void notification(View view) {
        Intent i = new Intent(MainActivity.this, NotificationActivity.class);
        startActivity(i);
    }

    public void achievements(View view) {
        Intent i = new Intent(MainActivity.this, Achievements.class);
        startActivity(i);
    }

    public void team(View view) {
        Intent i = new Intent(MainActivity.this, TeamList.class);
        startActivity(i);
    }

    public void dev(View view) {
        Intent i = new Intent(MainActivity.this, DeveloperActivity.class);
        startActivity(i);
    }


    public void connect(View view) {
        Intent i = new Intent(MainActivity.this, ConnectActivity.class);
        startActivity(i);
    }

    public void gallery(View view) {
        Intent i = new Intent(MainActivity.this, Gallery.class);
        startActivity(i);
    }

//    public void web(View view) {
//        Intent i = new Intent(MainActivity.this, WebsiteActivity.class);
//        startActivity(i);
//    }
//---------------------------------


    public void bell(View view) {
        Intent i = new Intent(MainActivity.this, NotificationActivity.class);
        startActivity(i);
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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.ic_mir:
                Intent i = new Intent(MainActivity.this, AboutMit.class);
                startActivity(i);
                break;
                case R.id.ic_web:
                Intent i1= new Intent(MainActivity.this, WebActivity.class);
                startActivity(i1);
                break;
            case R.id.ic_update:
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
                break;
            case R.id.ic_find:
                Uri uri = Uri.parse("geo:0,0?q=\"" + 26.1413 + "," + 85.3654 + "\"");
                Intent intent4 = new Intent(android.content.Intent.ACTION_VIEW, uri);
                intent4.setPackage("com.google.android.apps.maps");
                startActivity(intent4);
                break;
            case R.id.ic_invite:
                Intent shareintent = new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                String shareBody = "Download START UP, MITM app now from GOOGLE PLAY STORE :- http://play.google.com/store/apps/details?id=com.mitm.startupmit&hl=en";
                String sharesub = "START UP MIT";
                shareintent.putExtra(Intent.EXTRA_SUBJECT, sharesub);
                shareintent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareintent, "Share Using:"));
                break;
            case R.id.ic__review:
                Toast.makeText(MainActivity.this, "You can Rate and Review us on PLAY STORE", Toast.LENGTH_LONG).show();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.mitm.startupmit"));
                startActivity(browserIntent);
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class)//StartActivity tha  pehle
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                break;


        }
//        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
//
//    @Override
//    public void onBackPressed() {
//
////        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
////            drawerLayout.closeDrawer(GravityCompat.START);
////        } else {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("STARTUP CELL");
//        builder.setIcon(R.drawable.startup_logo);
//
//        builder.setMessage(("Are you sure to exit?")).setCancelable(false).setPositiveButton(
//                ("YES"),
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
////                            ExitNotifier.getInstance().doExit(true);
//                            finish();
//                        MainActivity.super.onBackPressed(); //original
//
//                    }
//                })
//                .setNegativeButton("NO",
//                        new DialogInterface.OnClickListener()  {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int which) {
//                                dialogInterface.cancel();
//                            }
//                        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//
////    }
//    }
}
