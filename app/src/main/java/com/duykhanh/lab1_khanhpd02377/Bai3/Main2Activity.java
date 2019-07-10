package com.duykhanh.lab1_khanhpd02377.Bai3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.duykhanh.lab1_khanhpd02377.R;

public class Main2Activity extends Activity implements View.OnClickListener, Listerner {

    private TextView tvMessage;
    private Button btnLoad;
    private ImageView imgLoad;

    public static final String IMAGE_URL ="https://caodang.fpt.edu.vn/wp-content/uploads/Recruit.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvMessage = findViewById(R.id.tvMessage);
        btnLoad = findViewById(R.id.btnLoadImage);
        imgLoad = findViewById(R.id.imgMessage);
        btnLoad.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoadImage:
                new LoadImageTask(this,this).execute(IMAGE_URL);
                break;
        }
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imgLoad.setImageBitmap(bitmap);
        tvMessage.setText("Image Downloaded");
    }

    @Override
    public void onError() {
        tvMessage.setText("Error download image");
    }
}
