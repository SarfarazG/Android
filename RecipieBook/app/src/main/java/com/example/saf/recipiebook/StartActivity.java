package com.example.saf.recipiebook;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class StartActivity extends Activity {

    MediaPlayer player;
    @Override
    protected void onPause() {
        super.onPause();
        player.release();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startactivity);
        player = MediaPlayer.create(this,R.raw.welcome);
        player.start();
        Thread  t = new Thread(){

            public void run(){

                try {
                    sleep(3000);
                    Intent SI = new Intent(StartActivity.this,RecipieList.class);
                    StartActivity.this.startActivity(SI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

    }
}
