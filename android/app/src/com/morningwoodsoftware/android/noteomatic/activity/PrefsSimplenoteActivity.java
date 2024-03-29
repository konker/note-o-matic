package com.morningwoodsoftware.android.noteomatic.activity;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.net.Uri;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.app.SherlockPreferenceActivity;

import com.morningwoodsoftware.android.noteomatic.R;
import com.morningwoodsoftware.android.noteomatic.NoteOMaticApplication;

public class PrefsSimplenoteActivity extends SherlockPreferenceActivity
{
    private NoteOMaticApplication app;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.app = (NoteOMaticApplication) getApplication();

        addPreferencesFromResource(R.xml.prefs_simplenote);
        setContentView(R.layout.prefs_simplenote);
        getSupportActionBar().setTitle(R.string.menu_preferences);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button buttonSimplenote = (Button)findViewById(R.id.buttonSimplenote);
        buttonSimplenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.d(NoteOMaticApplication.TAG, "Main.buttonSimplenote clicked");
                Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(getString(R.string.simplenote_register_url)));
                startActivity(intent);
            }
        });

        Log.d(NoteOMaticApplication.TAG, "PrefsSimplenoteActivity.onCreate");
    }

    /* Lifecycle methods [TODO: remove if uneeded?] */
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(NoteOMaticApplication.TAG, "PrefsSimplenoteActivity.onPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(NoteOMaticApplication.TAG, "PrefsSimplenoteActivity.onResume");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(NoteOMaticApplication.TAG, "PrefsSimplenoteActivity.onStart");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(NoteOMaticApplication.TAG, "PrefsSimplenoteActivity.onRestart");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(NoteOMaticApplication.TAG, "PrefsSimplenoteActivity.onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(NoteOMaticApplication.TAG, "PrefsSimplenoteActivity.onDestroy");
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

