package com.duykhanh.lab1_khanhpd02377.Bai4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.duykhanh.lab1_khanhpd02377.R;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTime;
    private Button btnRun;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edtTime = findViewById(R.id.edtTime);
        btnRun = findViewById(R.id.btnRun);
        tvResult = findViewById(R.id.tvResult);
        btnRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRun:
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this,tvResult, edtTime);
                String sleepTime = edtTime.getText().toString();
                asyncTaskRunner.execute(sleepTime);
                break;
        }
    }
}
