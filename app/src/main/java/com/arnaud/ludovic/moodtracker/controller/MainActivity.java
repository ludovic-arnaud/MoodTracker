package com.arnaud.ludovic.moodtracker.controller;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

import com.arnaud.ludovic.moodtracker.R;
import com.arnaud.ludovic.moodtracker.adapters.PageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configure ViewPager
        this.configureViewPager();
    }

    private void configureViewPager(){
        //Get ViewPages from Layout
        ViewPager pager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        //Set adapter PageAdapter and glue it together
        pager.setAdapter(new PageAdapter(
                getSupportFragmentManager(),
                getResources().getIntArray(R.array.colorPagesViewPager)) {
        });
    }
}
