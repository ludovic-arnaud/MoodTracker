package com.arnaud.ludovic.moodtracker.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import java.time.DayOfWeek;

public class SharedPrefTools {

    public SharedPrefTools() {
    }

    //Key comment in SharedPreferences
    public static final String FILE = "MySharedPreference.xml";
    private static final String PREF_KEY_COM = "PREF_KEY_COM";
    private static final String PREF_KEY_MOOD = "PREF_KEY_MOOD";


    //Set comments in SharedPreferences
    public static void setPrefKeyComment(Context context, DayOfWeek dow, String comment){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        mPreferences.edit().putString(PREF_KEY_COM+dow, comment).apply();
    }

    //Set moods in SharedPreferences
    public static void setPrefKeyMood(Context context, DayOfWeek dow, int mood){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        mPreferences.edit().putInt(PREF_KEY_MOOD+dow, mood).apply();
    }

    //Get comments from SharedPreferences
    public static String getPrefKeyCom(Context context, DayOfWeek dow) {
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        return mPreferences.getString(PREF_KEY_COM+dow, "");
    }

    //Get moods from SharedPreferences
    public static int getPrefKeyMood(Context context, DayOfWeek dow){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        return mPreferences.getInt(PREF_KEY_MOOD+dow, 0);
    }

}
