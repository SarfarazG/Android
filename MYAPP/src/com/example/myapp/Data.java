package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener{
	
	Button start,startfor;
	EditText SendET;
	TextView GotAnswer;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialize();
		
	}
	private void initialize() {

		start = (Button)findViewById(R.id.bSA);
		startfor = (Button) findViewById(R.id.bSAFR);
		SendET = (EditText)findViewById(R.id.etSend);
		GotAnswer = (TextView)findViewById(R.id.tvQuestions);
		start.setOnClickListener(this);
		startfor.setOnClickListener(this);
				
		
	}
	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
			
		case R.id.bSA:
				String bread = SendET.getText().toString();
				Bundle basket = new Bundle();
				basket.putString("k1", bread);
				Intent i = new Intent(Data.this,Opendclass.class);
				i.putExtras(basket);
				startActivity(i);		
			    break;
		case R.id.bSAFR:
			Intent a = new Intent(Data.this,Opendclass.class);
			startActivityForResult(a, 0);
			break;			
		}
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle basket = data.getExtras();
			String s = basket.getString("k2");
			GotAnswer.setText(s);
			
			
		}
	}
	
}
