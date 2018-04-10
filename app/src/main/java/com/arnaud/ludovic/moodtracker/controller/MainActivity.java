package com.arnaud.ludovic.moodtracker.controller;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.arnaud.ludovic.moodtracker.R;
import com.arnaud.ludovic.moodtracker.adapters.PageAdapter;
import com.arnaud.ludovic.moodtracker.model.SharedPrefTools;

import java.time.LocalDate;

//Import castorflex (Antoine Merle) verticalviewpager
import fr.castorflex.android.verticalviewpager.VerticalViewPager;

@TargetApi(Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {

    //Buttons variables
    private ImageButton mCommentButton;
    private ImageButton mHistoryButton;
    private ImageButton mShareButton;

    //Set VerticalViewpager
    VerticalViewPager pager;

    //Getting the date of the current day
    LocalDate mDate = LocalDate.now();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set buttons
        mCommentButton = findViewById(R.id.activity_main_comment_btn);
        mHistoryButton = findViewById(R.id.activity_main_history_btn);
        mShareButton = findViewById(R.id.activity_main_share_btn);

        //Configure ViewPager
        this.configureViewPager();

        //Show Comment Popup
        this.showCommentPopup();

        //Open History
        this.openHistory();

        this.textShare();
    }

    private void configureViewPager(){
        //Array of moods drawables
        final int[] moods = {R.drawable.smiley_sad, R.drawable.smiley_disappointed, R.drawable.smiley_normal, R.drawable.smiley_happy, R.drawable.smiley_super_happy};

        //Get ViewPager from Layout
        pager = findViewById(R.id.activity_main_viewpager);
        //Set adapter PageAdapter and glue it together
        pager.setAdapter(new PageAdapter(
                getSupportFragmentManager(),
                getResources().getIntArray(R.array.colorPagesViewPager), moods)
                {
        });
        //Set default mood happy
        pager.setCurrentItem(3);
    }

    private void showCommentPopup(){
        //Configure alert dialog for comment button
        mCommentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Comment popup
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                final View v = inflater.inflate(R.layout.dialog_comment, null);
                //Add Title
                builder.setTitle("Add a comment")
                        // Inflate and set the layout for the dialog
                        // Pass null as the parent view because its going in the dialog layout
                        .setView(v)
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText mCommentEdit = v.findViewById(R.id.dialog_comment_edit);
                                //Save comment in SharedPreferences when OK button is clicked
                                SharedPrefTools.setPrefKeyComment(MainActivity.this, mDate, mCommentEdit.getText().toString());
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .create()
                        .show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Save chosen mood in SharedPreferences when back button is clicked
        SharedPrefTools.setPrefKeyMood(MainActivity.this, mDate, pager.getCurrentItem());
    }

    //Open HistoryActivity
    private void openHistory(){
        mHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyActivity = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyActivity);
            }
        });
    }

    //Click on mShareButton allow to sent mood via email or SMS in text format
    private void textShare(){
        mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Save chosen mood in SharedPreferences
                SharedPrefTools.setPrefKeyMood(MainActivity.this, mDate, pager.getCurrentItem());

                //Convert int mood in text
                int intMood = SharedPrefTools.getPrefKeyMood(MainActivity.this, mDate);
                String convertedMood = null;
                switch (intMood){
                    case 0:
                        convertedMood = "I am disappointed today!";
                        break;
                    case 1:
                        convertedMood = "I am sad today!";
                        break;
                    case 2:
                        convertedMood = "I am normal today!";
                        break;
                    case 3:
                        convertedMood = "I am happy today!";
                        break;
                    case 4:
                        convertedMood = "I am super happy today!";
                        break;
                }

                //Initialize Share Text (mood + comment) Intent
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, convertedMood + " " + SharedPrefTools.getPrefKeyCom(MainActivity.this, mDate));
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }
}
