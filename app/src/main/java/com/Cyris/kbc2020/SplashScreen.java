package com.Cyris.kbc2020;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if(getIntent().getExtras()!=null){
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                if(key.equals("update")){
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.Cyris.kbc2020"));
                    try {
                        startActivity(intent1);
                        this.finish();
                        return;
                    }catch (Exception e){
                        Log.i("Error","WebView error");
                    }
                }
                if(key.equals("link")){
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(value));
                    try {
                        startActivity(intent1);
                        this.finish();
                        return;
                    }catch (Exception e){
                        Log.i("Error","WebView error");
                    }
                }
            }
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        },1000);
    }
}
