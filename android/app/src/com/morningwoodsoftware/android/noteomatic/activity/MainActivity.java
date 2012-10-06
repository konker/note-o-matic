package com.morningwoodsoftware.android.noteomatic.activity;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.LinearLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.net.Uri;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.app.SherlockActivity;

import com.morningwoodsoftware.android.noteomatic.R;
import com.morningwoodsoftware.android.noteomatic.NoteOMaticApplication;

public class MainActivity extends SherlockActivity
{
    private NoteOMaticApplication app;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.app = (NoteOMaticApplication) getApplication();
        getSupportActionBar().setTitle(R.string.app_name);

        setupUI();

        Log.d(NoteOMaticApplication.TAG, "MainActivity.onCreate");
    }


    protected void setupUI()
    {
        /*[FIXME: new activity needs to replace MainActivity in the stack]*/
        if (app.isAccountConfigured()) {
            initNoteList();
            /*
            startActivity(new Intent(this, NoteListActivity.class)
                                  .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                  */
        }
        else {
            initMainInfoPanel();
            /*
            startActivity(new Intent(this, NoAccountActivity.class)
                                  .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                  */
        }
    }

    protected void initMainInfoPanel()
    {
        Button buttonSimplenoteSettings = (Button)findViewById(R.id.buttonSimplenoteSettings);
        buttonSimplenoteSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.d(NoteOMaticApplication.TAG, "Main.buttonSimplenoteSettings clicked");
                Intent intent = new Intent(MainActivity.this, PrefsSimplenoteActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });

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

        LinearLayout mainInfoPanel = (LinearLayout)findViewById(R.id.mainInfoPanel);
        mainInfoPanel.setVisibility(View.VISIBLE);

        ListView noteList = (ListView)findViewById(R.id.noteList);
        noteList.setVisibility(View.GONE);
    }

    protected void initNoteList()
    {
        LinearLayout mainInfoPanel = (LinearLayout)findViewById(R.id.mainInfoPanel);
        mainInfoPanel.setVisibility(View.GONE);

        ListView noteList = (ListView)findViewById(R.id.noteList);
        noteList.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.menuPreferences:
                Intent intent = new Intent(this, PrefsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* Lifecycle methods [TODO: remove if uneeded?] */
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(NoteOMaticApplication.TAG, "MainActivity.onPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(NoteOMaticApplication.TAG, "MainActivity.onResume");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(NoteOMaticApplication.TAG, "MainActivity.onStart");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(NoteOMaticApplication.TAG, "MainActivity.onRestart");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(NoteOMaticApplication.TAG, "MainActivity.onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(NoteOMaticApplication.TAG, "MainActivity.onDestroy");
    }
}

