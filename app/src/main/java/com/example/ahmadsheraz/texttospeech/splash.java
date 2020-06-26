package com.example.ahmadsheraz.texttospeech;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /////
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        ////////////
        setContentView(R.layout.activity_splash);



        ImageView image = (ImageView)findViewById(R.id.myimage);
        Animation animation1 =
                AnimationUtils.loadAnimation(this, R.anim.translate);
        image.startAnimation(animation1);




        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {

                Intent myIntent = new Intent(splash.this, MainTextToSpeech.class);

                startActivity(myIntent);
                splash.this.finish();
            }
        };
        handler.postDelayed(r, 1000);




    }




}
