package com.arnaud.ludovic.moodtracker.controller;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.arnaud.ludovic.moodtracker.R;
import com.arnaud.ludovic.moodtracker.model.SharedPrefTools;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@TargetApi(Build.VERSION_CODES.O)
public class HistoryActivity extends AppCompatActivity {

    private FrameLayout mFrameSeven;
    private FrameLayout mFrameSix;
    private FrameLayout mFrameFive;
    private FrameLayout mFrameFour;
    private FrameLayout mFrameThree;
    private FrameLayout mFrameTwo;
    private FrameLayout mFrameYest;
    private ImageButton mButtonSeven;
    private ImageButton mButtonSix;
    private ImageButton mButtonFive;
    private ImageButton mButtonFour;
    private ImageButton mButtonThree;
    private ImageButton mButtonTwo;
    private ImageButton mButtonYest;

    //Getting the date of the week for the current day
    LocalDate mDate = LocalDate.now();

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mFrameSeven = findViewById(R.id.activity_history_seven);
        mFrameSix = findViewById(R.id.activity_history_six);
        mFrameFive = findViewById(R.id.activity_history_five);
        mFrameFour = findViewById(R.id.activity_history_foor);
        mFrameThree = findViewById(R.id.activity_history_three);
        mFrameTwo = findViewById(R.id.activity_history_two);
        mFrameYest = findViewById(R.id.activity_history_yest);

        mButtonSeven = findViewById(R.id.activity_history_btn_seven);
        mButtonSix = findViewById(R.id.activity_history_btn_six);
        mButtonFive = findViewById(R.id.activity_history_btn_five);
        mButtonFour = findViewById(R.id.activity_history_btn_foor);
        mButtonThree = findViewById(R.id.activity_history_btn_three);
        mButtonTwo = findViewById(R.id.activity_history_btn_two);
        mButtonYest = findViewById(R.id.activity_history_btn_yest);

        //Array of FrameLayouts
        FrameLayout[] frameArray = {
                mFrameSeven,
                mFrameSix,
                mFrameFive,
                mFrameFour,
                mFrameThree,
                mFrameTwo,
                mFrameYest
        };

        //Array of ImageButtons
        ImageButton[] buttonArray = {
                mButtonSeven,
                mButtonSix,
                mButtonFive,
                mButtonFour,
                mButtonThree,
                mButtonTwo,
                mButtonYest
        };

        //Array of moods from SharedPreferences
         int [] moods = {
                SharedPrefTools.getPrefKeyMood(HistoryActivity.this, mDate.minus(7, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyMood(HistoryActivity.this, mDate.minus(6, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyMood(HistoryActivity.this, mDate.minus(5, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyMood(HistoryActivity.this, mDate.minus(4, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyMood(HistoryActivity.this, mDate.minus(3, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyMood(HistoryActivity.this, mDate.minus(2, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyMood(HistoryActivity.this, mDate.minus(1, ChronoUnit.DAYS)),
        };

         //Array of comments from SharedPreferences
        String [] comments = {
                SharedPrefTools.getPrefKeyCom(HistoryActivity.this, mDate.minus(7, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyCom(HistoryActivity.this, mDate.minus(6, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyCom(HistoryActivity.this, mDate.minus(5, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyCom(HistoryActivity.this, mDate.minus(4, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyCom(HistoryActivity.this, mDate.minus(3, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyCom(HistoryActivity.this, mDate.minus(2, ChronoUnit.DAYS)),
                SharedPrefTools.getPrefKeyCom(HistoryActivity.this, mDate.minus(1, ChronoUnit.DAYS))
        };


         //Update FrameLayouts and ImageButtons for moods and comments arrays
        for (int i = 0; i < 7; i++){
                updateFrame(frameArray[i], moods[i]);
                updateButton(buttonArray[i], comments[i]);
        }
    }

    //Update size and color of FrameLayouts depending of moods
    private void updateFrame(FrameLayout mFrameLayout, int mood){

        //Get informations about the display size
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mFrameLayout.getLayoutParams();

        switch (mood){
            case 0:
                //20% screen size and red color for disappointed mood
                params.width = ((metrics.widthPixels * 20) / 100);
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[0]);
                break;
            case 1:
                //40% screen size and grey color for sad mood
                params.width = ((metrics.widthPixels * 40) / 100);
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[1]);
                break;
            case 2:
                //60% screen size and blue color for normal mood
                params.width = ((metrics.widthPixels * 60) / 100);
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[2]);
                break;
            case 3:
                //80% screen size and green color for happy mood
                params.width = ((metrics.widthPixels * 80) / 100);
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[3]);
                break;
            case 4:
                //100% screen size and yellow color for super happy mood
                mFrameLayout.setBackgroundColor(getResources().getIntArray(R.array.colorPagesViewPager)[4]);
                break;
        }
    }

    //Show ImageButtons if there is a comment and activate the click + toast
    private void updateButton(ImageButton imageButton, final String comment){

        //Show the ImageButton with View setVisibility() method if there is a comment
        if (comment != "") {
            imageButton.setVisibility(View.VISIBLE);
        } else {
            imageButton.setVisibility(View.INVISIBLE);
        }

        //Set onClick + show Toast with comment
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HistoryActivity.this, comment, Toast.LENGTH_SHORT).show();
            }
        });
    }
}