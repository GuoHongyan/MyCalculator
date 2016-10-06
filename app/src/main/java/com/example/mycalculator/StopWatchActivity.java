package com.example.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class StopWatchActivity extends Activity implements View.OnClickListener,Chronometer.OnChronometerTickListener{

    private Chronometer chronometer;
    private Button btnStart;
    private Button btnStop;
    private Button btnBase;
    private Button btnFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stop_watch);
        //addActivity
        SysApplication.getInstance().addActivity(this);

        Button btnBack=(Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StopWatchActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        initView();

    }
    private void initView() {
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnBase = (Button) findViewById(R.id.btnReset);
        btnFormat = (Button) findViewById(R.id.btn_format);

        chronometer.setOnChronometerTickListener(this);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnBase.setOnClickListener(this);
        btnFormat.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                chronometer.start();// 开始计时
                break;
            case R.id.btnStop:
                chronometer.stop();// 停止计时
                break;
            case R.id.btnReset:
                chronometer.setBase(SystemClock.elapsedRealtime());// 复位
                break;
            case R.id.btn_format:
                chronometer.setFormat("T：%s");// 更改时间显示格式
                btnFormat.setEnabled(false);
                break;
        }
    }



    @Override
    public void onChronometerTick(Chronometer chronometer) {

    }

}

