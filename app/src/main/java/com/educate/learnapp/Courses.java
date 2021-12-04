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

public class Courses extends AppCompatActivity {


    CardView linkcard1,linkcard2,linkcard3,linkcard4,linkcard5,linkcard6,linkcard7,linkcard8,linkcard9;
    Context context = Courses.this;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);


        linkcard1 = findViewById(R.id.linkcard1);
        linkcard2 = findViewById(R.id.linkcard2);
        linkcard3 = findViewById(R.id.linkcard3);
        linkcard4 = findViewById(R.id.linkcard4);
        linkcard5 = findViewById(R.id.linkcard5);
        linkcard5 = findViewById(R.id.linkcard5);
        linkcard6 = findViewById(R.id.linkcard6);
        linkcard7 = findViewById(R.id.linkcard7);
        linkcard8 = findViewById(R.id.linkcard8);
        linkcard9 = findViewById(R.id.linkcard9);

        linkcard1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.udemy.com/course/master-android-7-nougat-java-app-development-step-by-step/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://developer.android.com/jetpack/compose/tutorial?gclid=Cj0KCQiA7oyNBhDiARIsADtGRZZqN_8JPOQPJRwjmiszeRZ9cFxLz1jqb4j1CXSuK1pGc3ik3xx7Ar4aAt3lEALw_wcB&gclsrc=aw.ds");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.youtube.com/watch?v=ZE2Jkvnk2Bs");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.youtube.com/watch?v=RGOj5yH7evk");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.udemy.com/course/android-architecture/?utm_source=adwords&utm_medium=udemyads&utm_campaign=LongTail_la.EN_cc.INDIA&utm_content=deal4584&utm_term=_._ag_77882236463_._ad_533093955810_._kw__._de_c_._dm__._pl__._ti_dsa-1007766171312_._li_9062089_._pd__._&matchtype=b&gclid=Cj0KCQiA7oyNBhDiARIsADtGRZY9SbBj00nEu1NF3Rcjde8qdtvOkU-aSqwCSZWgxB5Ou4UfsXXYlqgaApdHEALw_wcB");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.youtube.com/watch?v=wuiT4T_LJQo&t=7788s");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.youtube.com/watch?v=rtWH70_MMHM");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.youtube.com/watch?v=312RhjfetP8&t=669s");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });

        linkcard9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;

                uri = Uri.parse("https://www.youtube.com/playlist?list=PLrnPJCHvNZuCbuD3xpfKzQWOj3AXybSaM");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });




        Window g = getWindow();

        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.courses);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.links:
                        startActivity(new Intent(getApplicationContext(),Links.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id .Timeline:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.courses:

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

