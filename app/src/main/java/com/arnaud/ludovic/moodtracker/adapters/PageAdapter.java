package com.arnaud.ludovic.moodtracker.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.arnaud.ludovic.moodtracker.controller.MoodFragment;

public class PageAdapter extends FragmentPagerAdapter {

    //Array of colors that will be passed to MoodFragment
    private int[] colors;

    //Array of moods that will be passed to MoodFragment
    private int[] moods;

    //Default constructor
    protected PageAdapter(FragmentManager mgr, int[] colors, int[] moods){
        super(mgr);
        this.colors = colors;
        this.moods = moods;
    }

    @Override
    public int getCount() {
        return 5;
        //Number of pages to show
    }

    @Override
    public Fragment getItem(int position) {
        //Page to return
        return (MoodFragment.newInstance(position, this.colors[position], this.moods[position]));
    }
}
