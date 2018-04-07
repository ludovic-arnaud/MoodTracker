package com.arnaud.ludovic.moodtracker.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SharedPrefTools {

    //Key comment in SharedPreferences
    public static final String FILE = "MySharedPreference.xml";
    private static final String PREF_KEY_COM_MON = "PREF_KEY_COM_MON";
    private static final String PREF_KEY_COM_TUE = "PREF_KEY_COM_TUE";
    private static final String PREF_KEY_COM_WED = "PREF_KEY_COM_WED";
    private static final String PREF_KEY_COM_THU = "PREF_KEY_COM_THU";
    private static final String PREF_KEY_COM_FRI = "PREF_KEY_COM_FRI";
    private static final String PREF_KEY_COM_SAT = "PREF_KEY_COM_SAT";
    private static final String PREF_KEY_COM_SUN = "PREF_KEY_COM_SUN";
    private static final String PREF_KEY_MOOD_MON = "PREF_KEY_MOOD_MON";
    private static final String PREF_KEY_MOOD_TUE = "PREF_KEY_MOOD_TUE";
    private static final String PREF_KEY_MOOD_WED = "PREF_KEY_MOOD_WED";
    private static final String PREF_KEY_MOOD_THU = "PREF_KEY_MOOD_THU";
    private static final String PREF_KEY_MOOD_FRI = "PREF_KEY_MOOD_FRI";
    private static final String PREF_KEY_MOOD_SAT = "PREF_KEY_MOOD_SAT";
    private static final String PREF_KEY_MOOD_SUN = "PREF_KEY_MOOD_SUN";

    //Getting the day of the week for the current day
    private static final LocalDate date = LocalDate.now();
    private static final DayOfWeek dow = date.getDayOfWeek();

    //Set comments in SharedPreferences
    public static void setPrefKeyComment(Context context, String comment){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        switch (dow){
            case MONDAY:
                mPreferences.edit().putString(PREF_KEY_COM_MON, comment).apply();
                break;
            case TUESDAY:
                mPreferences.edit().putString(PREF_KEY_COM_TUE, comment).apply();
                break;
            case WEDNESDAY:
                mPreferences.edit().putString(PREF_KEY_COM_WED, comment).apply();
                break;
            case THURSDAY:
                mPreferences.edit().putString(PREF_KEY_COM_THU, comment).apply();
                break;
            case FRIDAY:
                mPreferences.edit().putString(PREF_KEY_COM_FRI, comment).apply();
                break;
            case SATURDAY:
                mPreferences.edit().putString(PREF_KEY_COM_SAT, comment).apply();
                break;
            case SUNDAY:
                mPreferences.edit().putString(PREF_KEY_COM_SUN, comment).apply();
                break;
        }
    }

    //Set moods in SharedPreferences
    public static void setPrefKeyMood(Context context, int mood){
        SharedPreferences mPreferences = context.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        switch (dow){
            case MONDAY:
                mPreferences.edit().putInt(PREF_KEY_MOOD_MON, mood).apply();
                break;
            case TUESDAY:
                mPreferences.edit().putInt(PREF_KEY_MOOD_TUE, mood).apply();
                break;
            case WEDNESDAY:
                mPreferences.edit().putInt(PREF_KEY_MOOD_WED, mood).apply();
                break;
            case THURSDAY:
                mPreferences.edit().putInt(PREF_KEY_MOOD_THU, mood).apply();
                break;
            case FRIDAY:
                mPreferences.edit().putInt(PREF_KEY_MOOD_FRI, mood).apply();
                break;
            case SATURDAY:
                mPreferences.edit().putInt(PREF_KEY_MOOD_SAT, mood).apply();
                break;
            case SUNDAY:
                mPreferences.edit().putInt(PREF_KEY_MOOD_SUN, mood).apply();
                break;
        }
    }


}
