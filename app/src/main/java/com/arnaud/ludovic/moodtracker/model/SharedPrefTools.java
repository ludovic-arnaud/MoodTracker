package com.arnaud.ludovic.moodtracker.model;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

import java.time.DayOfWeek;

public class SharedPrefTools {

    public SharedPrefTools() {
    }

    //Key comment in SharedPreferences
    private static final String PREF_KEY_COM = "PREF_KEY_COM";
    private static final String PREF_KEY_MOOD = "PREF_KEY_MOOD";


    //Set comments in SharedPreferences
    public static void setPrefKeyComment(SharedPreferences mPreferences, DayOfWeek dow, String comment){
        mPreferences.edit().putString(PREF_KEY_COM+dow, comment).apply();
    }

    //Set moods in SharedPreferences
    public static void setPrefKeyMood(SharedPreferences mPreferences, DayOfWeek dow, int mood){
        mPreferences.edit().putInt(PREF_KEY_MOOD+dow, mood).apply();
    }

    //Get comments from SharedPreferences
    public static String getPrefKeyCom(SharedPreferences mPreferences, DayOfWeek dow) {
        return mPreferences.getString(PREF_KEY_COM+dow, "");
    }

    //Get moods from SharedPreferences
    public static int getPrefKeyMood(SharedPreferences mPreferences, DayOfWeek dow){
        return mPreferences.getInt(PREF_KEY_MOOD+dow, 0);
    }

}
