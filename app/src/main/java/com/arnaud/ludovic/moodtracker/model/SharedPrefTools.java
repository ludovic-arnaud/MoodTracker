package com.arnaud.ludovic.moodtracker.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.time.LocalDate;


public class SharedPrefTools {

    public SharedPrefTools() {
    }

    //Key comment in SharedPreferences
    public static final String FILE = "MySharedPreference.xml";
    private static final String PREF_KEY_COM = "PREF_KEY_COM";
    private static final String PREF_KEY_MOOD = "PREF_KEY_MOOD";


    //Set comments in SharedPreferences
    public static void setPrefKeyComment(Context context, LocalDate date, String comment){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        mPreferences.edit().putString(PREF_KEY_COM+date, comment).apply();
    }

    //Set moods in SharedPreferences
    public static void setPrefKeyMood(Context context, LocalDate date, int mood){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        mPreferences.edit().putInt(PREF_KEY_MOOD+date, mood).apply();
    }

    //Get comments from SharedPreferences
    public static String getPrefKeyCom(Context context, LocalDate date) {
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        return mPreferences.getString(PREF_KEY_COM+date, "");
    }

    //Get moods from SharedPreferences
    public static int getPrefKeyMood(Context context, LocalDate date){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        return mPreferences.getInt(PREF_KEY_MOOD+date, 0);
    }

}
