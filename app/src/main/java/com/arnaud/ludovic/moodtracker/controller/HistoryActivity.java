package com.arnaud.ludovic.moodtracker.controller;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.arnaud.ludovic.moodtracker.R;
import com.arnaud.ludovic.moodtracker.model.SharedPrefTools;

import java.time.DayOfWeek;

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

    private SharedPreferences mPreferences;

    @TargetApi(Build.VERSION_CODES.O)
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

        FrameLayout[] frameArray = {
                mFrameMon,
                mFrameTue,
                mFrameWed,
                mFrameThu,
                mFrameFri,
                mFrameSat,
                mFrameSun
        };

        int [] moods = {
                SharedPrefTools.getPrefKeyMood(mPreferences, DayOfWeek.MONDAY),
                SharedPrefTools.getPrefKeyMood(mPreferences, DayOfWeek.TUESDAY),
                SharedPrefTools.getPrefKeyMood(mPreferences, DayOfWeek.WEDNESDAY),
                SharedPrefTools.getPrefKeyMood(mPreferences, DayOfWeek.THURSDAY),
                SharedPrefTools.getPrefKeyMood(mPreferences, DayOfWeek.FRIDAY),
                SharedPrefTools.getPrefKeyMood(mPreferences, DayOfWeek.SATURDAY),
                SharedPrefTools.getPrefKeyMood(mPreferences, DayOfWeek.SUNDAY),
        };

        for (int i = 0; i < 8; i++){
            updateFrame(frameArray[i], moods[i]);
        }

    }

    private void updateFrame(FrameLayout mFrameLayout, int mood){
        switch (mood){
            case 0:
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[0]);
                break;
            case 1:
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[1]);
                break;
            case 2:
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[2]);
                break;
            case 3:
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[3]);
                break;
            case 4:
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[4]);
                break;
        }
    }

}
