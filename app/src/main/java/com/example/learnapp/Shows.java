package com.example.learnapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Shows extends AppCompatActivity {

    private WebView webView;
    BottomNavigationView bottomNavigationView;
    ProgressBar PBloading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);





            PBloading = (ProgressBar)findViewById(R.id.PBloading);

            CustomWebViewClient client = new CustomWebViewClient(this);

            webView = findViewById(R.id.idWebView);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setUserAgentString("Chrome/96.0.4664.45 Mobile");
            webView.loadUrl("https://dribbble.com/tags/app_inspiration");




            webView.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onProgressChanged(android.webkit.WebView view, int newProgress) {
                    PBloading.setVisibility(View.VISIBLE);
                    PBloading.setProgress(newProgress);
                    setTitle("Loading...");
                    if(newProgress == 100){
                        PBloading.setVisibility(View.GONE);
                        setTitle(view.getTitle());
                    }
                    super.onProgressChanged(view, newProgress);
                }
            });





            bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.showc);
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
                        startActivity(new Intent(getApplicationContext(),Courses.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.doc:
                        startActivity(new Intent(getApplicationContext(),Doc.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.showc:
                        return true;

                }
                return false;
            }
        });


    }

    static class CustomWebViewClient extends WebViewClient{
        private final Activity activity;
        public CustomWebViewClient(Activity activity){
            this.activity = activity;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url){
            return false;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request){
            return false;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()){
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
