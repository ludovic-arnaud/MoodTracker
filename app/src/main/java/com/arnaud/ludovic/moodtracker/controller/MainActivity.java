package com.arnaud.ludovic.moodtracker.controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.arnaud.ludovic.moodtracker.R;
import com.arnaud.ludovic.moodtracker.adapters.PageAdapter;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

public class MainActivity extends AppCompatActivity {

    private ImageButton mCommentButton;
    private ImageButton mHistoryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configure ViewPager
        this.configureViewPager();

        //Set buttons
        mCommentButton = (ImageButton) findViewById(R.id.activity_main_comment_btn);
        mHistoryButton = (ImageButton)findViewById(R.id.activity_main_history_btn);

        //Configure alert dialog for comment button
        mCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Add a comment")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .create()
                        .show();
            }
        });
    }

    private void configureViewPager(){
        //Array of moods
        final int[] moods = {R.drawable.smiley_sad, R.drawable.smiley_disappointed, R.drawable.smiley_normal, R.drawable.smiley_happy, R.drawable.smiley_super_happy};

        //Get ViewPages from Layout
        VerticalViewPager pager = findViewById(R.id.activity_main_viewpager);
        //Set adapter PageAdapter and glue it together
        pager.setAdapter(new PageAdapter(
                getSupportFragmentManager(),
                getResources().getIntArray(R.array.colorPagesViewPager), moods) {
        });
    }
}
