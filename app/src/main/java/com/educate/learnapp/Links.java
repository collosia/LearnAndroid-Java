package com.educate.learnapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.learnapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Links extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView linkcard1,linkcard2,linkcard3,linkcard4,linkcard5;
    Context context = Links.this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        linkcard1 = findViewById(R.id.linkcard1);
        linkcard2 = findViewById(R.id.linkcard2);
        linkcard3 = findViewById(R.id.linkcard3);
        linkcard4 = findViewById(R.id.linkcard4);
        linkcard5 = findViewById(R.id.linkcard5);

        linkcard1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://github.com/topics/android-project");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://maze.co/collections/ux-ui-design/tools/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://roadmap.sh/android");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://github.com/wasabeef/awesome-android-ui");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://github.com/aritraroy/UltimateAndroidReference");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });



        Window g = getWindow();

        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.links);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.links:
                        return true;
                    case R.id .Timeline:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.courses:
                        startActivity(new Intent(getApplicationContext(),Courses.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.doc:
                        startActivity(new Intent(getApplicationContext(),Doc.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.showc:
                        startActivity(new Intent(getApplicationContext(),Shows.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });


    }
}

