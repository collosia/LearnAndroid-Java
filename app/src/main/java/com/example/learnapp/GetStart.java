package com.example.learnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.royrodriguez.transitionbutton.TransitionButton;
import com.royrodriguez.transitionbutton.utils.WindowUtils;

public class GetStart extends AppCompatActivity {

    private TransitionButton transitionButton;
    TextView andro,startt,here,name;
    Animation fade_in_anim;
    Animation fade_in_anim1;
    Animation fade_in_anim2;
    Animation fade_in_anim3;
    Animation fade_in_anim4;
    EditText editT;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);

        if (restorePreData()){
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            finish();
        }


        WindowUtils.makeStatusbarTransparent(this);

        andro=findViewById(R.id.andro);
        startt=findViewById(R.id.startt);
        here=findViewById(R.id.here);


        transitionButton = findViewById(R.id.tbutton);

        fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fade_in_anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in1);
        fade_in_anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in2);
        fade_in_anim3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in3);
        fade_in_anim4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in4);

        transitionButton.setOnClickListener(v -> {
            // Then start the loading animation when the user tap the button
            transitionButton.startAnimation();

            // Do your networking task or background work here.
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    boolean isSuccessful = true;

                    if (isSuccessful) {
                        transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                            @Override
                            public void onAnimationStopEnd() {
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);
                                savePrefsData();
                            }
                        });
                    }
                }
            }, 1000);
        });

//        public static void setAlphaAnimation(View v) {
//            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(v, "alpha",  1f, .3f);
//            fadeOut.setDuration(2000);
//            ObjectAnimator fadeIn = ObjectAnimator.ofFloat(v, "alpha", .3f, 1f);
//            fadeIn.setDuration(2000);
//
//            final AnimatorSet mAnimationSet = new AnimatorSet();
//
//            mAnimationSet.play(fadeIn).after(fadeOut);
//
//            mAnimationSet.addListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    super.onAnimationEnd(animation);
//                    mAnimationSet.start();
//                }
//            });
//            mAnimationSet.start();
//        }

        final Handler hand = new Handler();
        hand.postDelayed(() -> {

            startt.startAnimation(fade_in_anim);
            startt.setVisibility(View.VISIBLE);
        }, 3000);


        final Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                andro.startAnimation(fade_in_anim1);
                andro.setVisibility(View.VISIBLE);
            }
        }, 3000);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                here.startAnimation(fade_in_anim2);
                here.setVisibility(View.VISIBLE);

            }

        }, 3000);






        final Handler handled = new Handler();
        handled.postDelayed(new Runnable() {
            @Override
            public void run() {


                transitionButton.setVisibility(View.VISIBLE);
                transitionButton.startAnimation(fade_in_anim3);

            }

        }, 3000);



    }

    private boolean restorePreData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = preferences.getBoolean("isIntroOpened", false);
        return isIntroActivityOpenedBefore;
    }

    private void savePrefsData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.apply();
    }





}