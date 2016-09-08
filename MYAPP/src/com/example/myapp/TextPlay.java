package com.example.myapp;

import java.util.Random;

import android.R.string;
import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener{

	MediaPlayer oursong;
	Button b;
	EditText ed;
	ToggleButton tb;
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		MYFIRSTAPP();
		tb.setOnClickListener(this);
		b.setOnClickListener(this);	
	}
	private void MYFIRSTAPP() {
		// TODO Auto-generated method stub
		     b = (Button) findViewById(R.id.b1);
		    ed = (EditText)findViewById(R.id.etext);
			tb = (ToggleButton)findViewById(R.id.tb1);
			tv = (TextView)findViewById(R.id.tv1);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.b1:
			String check = ed.getText().toString();
			if(check.contentEquals("left")){
				tv.setGravity(Gravity.LEFT);		
			}else if(check.contentEquals("centre")){
				tv.setGravity(Gravity.CENTER);
			}else if(check.contentEquals("right")){
				tv.setGravity(Gravity.RIGHT);
			}else if(check.contentEquals("blue")){
				tv.setTextColor(Color.BLUE);
				tv.setText("blue");
			}else if(check.contains("SAF")){
				Random r = new Random();
				tv.setText("SAF!!!");
				tv.setTextSize(r.nextInt(75));
				tv.setTextColor(Color.rgb(r.nextInt(265), r.nextInt(265), r.nextInt(265)));
				oursong = MediaPlayer.create(TextPlay.this, R.raw.ascream3);
				oursong.start();
				switch(r.nextInt(4)){
					
					case 0:
						tv.setGravity(Gravity.LEFT);
						break;
					case 1:
						tv.setGravity(Gravity.CENTER);
						break;
					case 2:
						tv.setGravity(Gravity.RIGHT);
						break;	
					case 3:
						tv.setTextColor(Color.BLUE);
						tv.setText("blue");
						break;			
				}
			}else {
				tv.setText("KHOTU CHE!");
				tv.setGravity(Gravity.CENTER);
				tv.setTextColor(Color.BLACK);
			}
			break;
			
		case R.id.tb1:
			if (tb.isChecked()) {
				
		        ed.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				
			} else {
				ed.setInputType(InputType.TYPE_CLASS_TEXT);
				
			}
			break;
		}
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		oursong.release();
	}
	
	

}
