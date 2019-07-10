package com.duykhanh.lab1_khanhpd02377.Bai1_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.duykhanh.lab1_khanhpd02377.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView imgAndroid;
    private TextView tvMessage;
    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;
    private Button btnLoadImage;
    private String url = "https://image.slidesharecdn.com/xuantien-ph06431-171012041352/95/k-hoch-2-nm-4-thng-ti-fpt-polytechnic-1-638.jpg?cb=1507781721";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAndroid = findViewById(R.id.imgMessage);
        tvMessage = findViewById(R.id.tvMessage);
        btnLoadImage = findViewById(R.id.btnLoadImage);
        btnLoadImage.setOnClickListener(this);
    }


    private Bitmap loadImageFromNetWork(String link){
        URL url;
        Bitmap bmp = null;
        try{
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }  catch (IOException e) {
            e.printStackTrace();
        }

        return bmp;
    }

    private Handler messageHandler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("message");
            tvMessage.setText(message);
            imgAndroid.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };

    @Override
    public void onClick(View view) {
        progressDialog = ProgressDialog.show(MainActivity.this,"","Downloading...");
        Runnable aRunnable = new Runnable() {
            @Override
            public void run() {
                bitmap = downloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMessage = "Image downloaded";
                bundle.putString("message",threadMessage);
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
            }
        };
        Thread aThread = new Thread(aRunnable);
        aThread.start();
    }

    private Bitmap downloadBitmap(String link2){
        try{
            URL url2 = new URL(link2);
            HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void btnLoadImage(View view) {
//        final Thread myThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Bitmap bitmap = loadImageFromNetWork("http://quiz.emdep.vn/upload/2018/11/2018-11-05_wU2tMFT8dW.tr%E1%BA%A1nh.jpg");
//                imgAndroid.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        tvMessage.setText("Image downloaded");
//                        imgAndroid.setImageBitmap(bitmap);
//                    }
//                });
//            }
//        });
//        myThread.start();



    }
}
