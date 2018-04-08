package com.arnaud.ludovic.moodtracker.controller;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.arnaud.ludovic.moodtracker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoodFragment extends Fragment {

    //Create keys for our bundle
    public static final String KEY_POSITION="KEY_POSITION";
    public static final String KEY_COLOR="KEY_COLOR";
    public static final String KEY_MOOD="KEY_MOOD";

    //Empty public constructor
    public MoodFragment() {
    }

    //Method that will create a new instance of MoodFragment and add data to its bundle
    public static MoodFragment newInstance(int position, int color, int mood){

        //Create new fragment
        MoodFragment fragment = new MoodFragment();

        //Create bundle and add datas
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        args.putInt(KEY_MOOD, mood);

        fragment.setArguments(args);
        return (fragment);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_mood, container, false);

        //Get widgets from layout and serialise it
        LinearLayout rootView = (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
        ImageView imageView = (ImageView) result.findViewById(R.id.fragment_mood_image);

        //Get data from bundle
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);
        int mood = getArguments().getInt(KEY_MOOD, -1);

        //Update widget with it
        rootView.setBackgroundColor(color);
        imageView.setImageResource(mood);

        return result;
    }

}
