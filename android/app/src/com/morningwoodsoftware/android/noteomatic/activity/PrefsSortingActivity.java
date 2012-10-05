package com.morningwoodsoftware.android.noteomatic.activity;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.app.SherlockPreferenceActivity;

import com.morningwoodsoftware.android.noteomatic.R;
import com.morningwoodsoftware.android.noteomatic.NoteOMaticApplication;

public class PrefsSortingActivity extends SherlockPreferenceActivity
{
    private NoteOMaticApplication app;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.app = (NoteOMaticApplication) getApplication();

        addPreferencesFromResource(R.xml.prefs_sorting);
        setContentView(R.layout.prefs);
        getSupportActionBar().setTitle(R.string.menu_preferences);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(NoteOMaticApplication.TAG, "PrefsSortingActivity.onCreate");
    }

    /* Lifecycle methods [TODO: remove if uneeded?] */
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(NoteOMaticApplication.TAG, "PrefsSortingActivity.onPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(NoteOMaticApplication.TAG, "PrefsSortingActivity.onResume");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(NoteOMaticApplication.TAG, "PrefsSortingActivity.onStart");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(NoteOMaticApplication.TAG, "PrefsSortingActivity.onRestart");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(NoteOMaticApplication.TAG, "PrefsSortingActivity.onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(NoteOMaticApplication.TAG, "PrefsSortingActivity.onDestroy");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Log.d(NoteOMaticApplication.TAG, "Main.buttonPrefs clicked: " + item.getItemId());
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, PrefsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


