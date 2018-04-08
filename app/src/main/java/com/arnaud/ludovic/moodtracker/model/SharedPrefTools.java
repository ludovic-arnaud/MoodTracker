package com.arnaud.ludovic.moodtracker.model;

import android.content.SharedPreferences;

public class SharedPrefTools {

    public SharedPrefTools() {
    }

    //Key comment in SharedPreferences
    private static final String PREF_KEY_COM = "PREF_KEY_COM";
    private static final String PREF_KEY_MOOD = "PREF_KEY_MOOD";


    //Set comments in SharedPreferences
    public static void setPrefKeyComment(SharedPreferences mPreferences, int day, String comment){
        mPreferences.edit().putString(PREF_KEY_COM+day, comment).apply();
    }

    //Set moods in SharedPreferences
    public static void setPrefKeyMood(SharedPreferences mPreferences, int day, int mood){
        mPreferences.edit().putInt(PREF_KEY_MOOD+day, mood).apply();
    }

    //Get comments from SharedPreferences
    static String getPrefKeyCom(SharedPreferences mPreferences, int day) {
        return mPreferences.getString(PREF_KEY_COM+day, "");
    }

    //Get moods from SharedPreferences
    static int getPrefKeyMood(SharedPreferences mPreferences, int day){
        return mPreferences.getInt(PREF_KEY_MOOD+day, 0);
    }

    //Save moods and comments in arrays of 7 days
    public void createWeek(SharedPreferences mPreferences, int day){

        //8 for today and the 7 days of the week to show in History
        int [] weekMoods = new int[8];
        String [] weekComs = new String[8];

        //Save moods from SharedPreferences for each day
        for (int i = 0; i < weekMoods.length; i++){
            weekMoods[i] = getPrefKeyMood(mPreferences, i);
        }

        //Save comments from SharedPreferences for each day
        for (int i = 0; i < weekComs.length; i++){
            weekComs[i] = getPrefKeyCom(mPreferences, i);
        }

        //Each new day, comments & moods are moved to the next table
        for (int i = 7; i > 0; i--){
            if ((i-day) >= 0){
                weekMoods[i] = weekMoods[i-day];
                weekComs[i] = weekComs[i-day];
            } else {
                //Default happy mood
                weekMoods[i] = 3;
                //Default empty comment
                weekComs[i] = "";
            }
        }

        //Save moods array in SharedPreferences
        for (int i = 1; i < weekMoods.length; i++){
            setPrefKeyMood(mPreferences, i, weekMoods[i]);
        }

        //Save comments array in SharedPreferences (1 = yesterday, 7 = 7 days ago)
        for (int i = 1; i < weekComs.length; i++){
            setPrefKeyComment(mPreferences, i , weekComs[i]);
        }

        //Save defaults comments and moods for day 0 (today)
        setPrefKeyComment(mPreferences, 0, "");
        setPrefKeyMood(mPreferences, 0, 3);
    }
}
