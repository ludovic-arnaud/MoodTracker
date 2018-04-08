package com.arnaud.ludovic.moodtracker.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.arnaud.ludovic.moodtracker.R;

public class HistoryActivity extends AppCompatActivity {

    private FrameLayout mFrameMon;
    private FrameLayout mFrameTue;
    private FrameLayout mFrameWed;
    private FrameLayout mFrameThu;
    private FrameLayout mFrameFri;
    private FrameLayout mFrameSat;
    private FrameLayout mFrameSun;
    private ImageButton mButtonMon;
    private ImageButton mButtonTue;
    private ImageButton mButtonWed;
    private ImageButton mButtonThu;
    private ImageButton mButtonFri;
    private ImageButton mButtonSat;
    private ImageButton mButtonSun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mFrameMon = findViewById(R.id.activity_history_mon);
        mFrameTue = findViewById(R.id.activity_history_tue);
        mFrameWed = findViewById(R.id.activity_history_wed);
        mFrameThu = findViewById(R.id.activity_history_thu);
        mFrameFri = findViewById(R.id.activity_history_fri);
        mFrameSat = findViewById(R.id.activity_history_sat);
        mFrameSun = findViewById(R.id.activity_history_sun);

        mButtonMon = findViewById(R.id.activity_history_btn_mon);
        mButtonTue = findViewById(R.id.activity_history_btn_tue);
        mButtonWed = findViewById(R.id.activity_history_btn_wed);
        mButtonThu = findViewById(R.id.activity_history_btn_thu);
        mButtonFri = findViewById(R.id.activity_history_btn_fri);
        mButtonSat = findViewById(R.id.activity_history_btn_sat);
        mButtonSun = findViewById(R.id.activity_history_btn_sun);
    }
}
