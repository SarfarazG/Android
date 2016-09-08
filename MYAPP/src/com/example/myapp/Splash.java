package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash  extends Activity{
	MediaPlayer oursong;
	

	@Override
	protected void onCreate(Bundle safloveniece) {
		// TODO Auto-generated method stub
		super.onCreate(safloveniece);
		setContentView(R.layout.splash);
		oursong = MediaPlayer.create(Splash.this, R.raw.ascream3);
		SharedPreferences getprefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music=getprefs.getBoolean("check", true);
		if(music==true)
		oursong.start();
		Thread t = new Thread(){
			public void run(){
				try{
					sleep(1000);
					
				}catch(InterruptedException e){
					System.out.println(" "+"ERROR IS "+e);
					e.printStackTrace();
				}finally{
					try{
					Intent nextactivity = new Intent("com.example.myapp.MENU");
					startActivity(nextactivity); 					
					}catch(Exception e){
						System.out.println("baka ahiya bhul che");
					}
				}
				}
		};
		t.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		oursong.release();
		finish();
	}
	
}
