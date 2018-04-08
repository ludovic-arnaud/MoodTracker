package com.arnaud.ludovic.moodtracker.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefTools {

    //Key comment in SharedPreferences
    public static final String FILE = "MySharedPreference.xml";
    private static final String PREF_KEY_COM = "PREF_KEY_COM";
    private static final String PREF_KEY_MOOD = "PREF_KEY_MOOD";

    private static SharedPreferences mPreferences;

    //Set comments in SharedPreferences
    public static void setPrefKeyComment(Context context, String comment){
        mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        mPreferences.edit().putString(PREF_KEY_COM, comment).apply();
    }

    //Set moods in SharedPreferences
    public static void setPrefKeyMood(Context context, int mood){
        mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        mPreferences.edit().putInt(PREF_KEY_MOOD, mood).apply();
    }
}
