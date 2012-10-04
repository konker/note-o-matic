package com.morningwoodsoftware.android.noteomatic;

import android.util.Log;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;

public class NoteOMaticApplication extends Application implements OnSharedPreferenceChangeListener
{
    public static final String TAG = "NOTE-O-MATIC";
    public static final String ERROR_TAG = "NOTE-O-MATIC:ERROR";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();

        this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
        this.editor = prefs.edit();
        this.prefs.registerOnSharedPreferenceChangeListener(this);

        Log.d(NoteOMaticApplication.TAG, "App.onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        Log.i(NoteOMaticApplication.TAG, "App.onTerminate");
    }

    public SharedPreferences getPrefs() {
        return prefs;
    }
    public SharedPreferences.Editor getPrefsEditor() {
        return editor;
    }

    /* methods required by OnSharedPreferenceChangeListener */
    public synchronized void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
        //[TODO]
        Log.i(NoteOMaticApplication.TAG, "App.onSharedPreferenceChanged");
        return;
    }
}


