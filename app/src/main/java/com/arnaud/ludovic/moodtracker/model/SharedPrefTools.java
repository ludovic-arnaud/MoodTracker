package com.arnaud.ludovic.moodtracker.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefTools {

    //Key comment in SharedPreferences
    public static final String FILE = "MySharedPreference.xml";
    public static final String PREF_KEY_COMMENT = "PREF_KEY_COMMENT";

    public static void setPrefKeyComment(Context context, String comment){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        mPreferences.edit().putString(PREF_KEY_COMMENT, comment).apply();
    }
}
