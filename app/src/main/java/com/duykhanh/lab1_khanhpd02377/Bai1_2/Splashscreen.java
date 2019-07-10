package com.duykhanh.lab1_khanhpd02377.Bai1_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.duykhanh.lab1_khanhpd02377.R;

public class Splashscreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private ImageView imgSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        imgSplash = findViewById(R.id.imgSplash);
        imgSplash.setImageResource(R.drawable.unnamed);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
