package com.example.learnapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    BottomNavigationView bottomNavigationView;
    com.example.learnapp.DatabaseAdapter databaseAdapter;
    RecyclerView rvPrograms;
    com.example.learnapp.ContactsAdapter contactsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<com.example.learnapp.Contacts> contactsList = new ArrayList<>();
    TextView welx;
    CardView jdoc,maincard2,maincard3,maincard4;
    Context context;
    ImageView aboutme;
    Dialog dialog;



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK ){
            Toast.makeText(MainActivity.this, "Can't back anymore!", Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);



        dialog = new Dialog(this);

        aboutme = findViewById(R.id.aboutme);

        aboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }

            private void openDialog() {
                dialog.setContentView(R.layout.dia_layout);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dialog.show();


            }
        });

        getWindow().setNavigationBarColor(ContextCompat.getColor(MainActivity.this,
                R.color.black));

        welx = findViewById(R.id.welx);

        jdoc=findViewById(R.id.jdoc);


        maincard2=findViewById(R.id.maincard2);
        maincard3=findViewById(R.id.maincard3);
        maincard4=findViewById(R.id.maincard4);


        context = MainActivity.this;


        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setBackground(null);
        NestedScrollView nestedS = findViewById(R.id.nestedS);
        nestedS.setFadingEdgeLength(150);
        com.example.learnapp.PreCreateDB.copyDB(this);
        databaseAdapter = new com.example.learnapp.DatabaseAdapter(this);
        contactsList = databaseAdapter.getAllContacts();
        rvPrograms = findViewById(R.id.rvPrograms);
        rvPrograms.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvPrograms.setLayoutManager(layoutManager);
        contactsAdapter = new com.example.learnapp.ContactsAdapter(this, contactsList, rvPrograms);
        rvPrograms.setAdapter(contactsAdapter);
        Window g = getWindow();

        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.Timeline);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.links:
                        startActivity(new Intent(getApplicationContext(), Links.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Timeline:
                        return true;
                    case R.id.courses:
                        startActivity(new Intent(getApplicationContext(), Courses.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.doc:
                        startActivity(new Intent(getApplicationContext(), Doc.class));
                        overridePendingTransition(10, 10);
                        return true;
                    case R.id.showc:
                        startActivity(new Intent(getApplicationContext(), Shows.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });

        jdoc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                    uri = Uri.parse("https://docs.oracle.com/javase/7/docs/api/");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(intent);


            }
        });

        maincard2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.youtube.com/playlist?list=PLEbnTDJUr_Iekh7CGDsDizndTgBFruHn1");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);



            }
        });

        maincard3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               Uri uri;

                uri = Uri.parse("https://codingbat.com/java");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);



            }
        });
        maincard4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.hackerrank.com/domains/java");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);



            }
        });









    }


}