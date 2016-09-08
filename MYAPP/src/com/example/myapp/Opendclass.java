package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Opendclass extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	TextView test, Question;
	Button Returndata;
	RadioGroup selectionlist;
	String Gotbread,Senddata;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		SharedPreferences getdata = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getdata.getString("edittext", "sarfaraz is");
		String values = getdata.getString("list", "4");
		if(values.contentEquals("1")){
			Question.setText(et);
		}
		//Bundle Gotbasket = getIntent().getExtras();
		//Gotbread = Gotbasket.getString("k1");
		//Question.setText(Gotbread);	
	}
	private void initialize() {

		test = (TextView) findViewById(R.id.tvtest);
		Question = (TextView) findViewById(R.id.tvQuestions);
		Returndata = (Button) findViewById(R.id.bReturn);
		Returndata.setOnClickListener(this);
		selectionlist = (RadioGroup)findViewById(R.id.rgAnswers);
		selectionlist.setOnCheckedChangeListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent person =new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("k2", Senddata);
		person.putExtras(backpack);
		setResult(RESULT_OK,person);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {

		switch (checkedId) {

			case R.id.rcrazy:
				Senddata = "Correct";
				break;
			case R.id.rsexy:
				Senddata = "Sort of";
				break;
			case R.id.rboth:
				Senddata = "absolutely Right";
				break;
		}
		test.setText(Senddata);
	}
}
