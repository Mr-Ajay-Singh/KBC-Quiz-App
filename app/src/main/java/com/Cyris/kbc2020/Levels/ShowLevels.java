package com.Cyris.kbc2020.Levels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.Cyris.kbc2020.AdapterClass.LevelAdapter;
import com.Cyris.kbc2020.R;

public class ShowLevels extends AppCompatActivity {
    RecyclerView mRecyclerViewLevels;
    LevelAdapter levelAdapter;
    boolean soundOnOff;
    String language = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_levels);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        mRecyclerViewLevels = findViewById(R.id.recyclerview_in_levels);
        soundOnOff = getIntent().getBooleanExtra(getString(R.string.sound_on_off), true);
        language = getIntent().getStringExtra(getString(R.string.select_language));
        Log.i("language",language);


    }

    @Override
    protected void onResume() {
        super.onResume();
        levelAdapter = new LevelAdapter(this,soundOnOff,language);
        mRecyclerViewLevels.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerViewLevels.setAdapter(levelAdapter);
    }
}