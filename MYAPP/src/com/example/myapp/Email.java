package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Email extends Activity implements View.OnClickListener{

		
		Button SendEmail;
		EditText Emial_id,intro,Persons_Name,Stupid_things,Hateful_Actions,Outro;
		String EmialAdd,begning,Name,StupidAction,HatefulAct,out;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializevar();
		SendEmail.setOnClickListener(this);
		
	}
	private void initializevar() {
	
		Emial_id = (EditText) findViewById(R.id.etemail);
		intro = (EditText)findViewById(R.id.etintro);
		Persons_Name = (EditText) findViewById(R.id.etname);
		Stupid_things = (EditText) findViewById(R.id.etthings);
		Hateful_Actions = (EditText) findViewById(R.id.etaction);
		Outro = (EditText)findViewById(R.id.etoutro);
		SendEmail = (Button) findViewById(R.id.etsentEmail);
	}
	@Override
	public void onClick(View v) {
		
		conversion();
		String emailAddress[] = {EmialAdd};
		String message = "well hello "
						+Name
						+" I just wanted to say "
						+begning
						+". Not only that but I hate when u "
						+StupidAction
						+", that just really makes me crazy. I just want to make u "
						+HatefulAct
						+". Welp, thats all i want to chit-chatter about,oh and "
						+out
						+". Oh also listen i was just kidding";
		
		Intent ourintent = new Intent(android.content.Intent.ACTION_SEND);
		ourintent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
		ourintent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate u!");
		ourintent.setType("plain/text");
		ourintent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(ourintent);
		
	}
	private void conversion() {
		// TODO Auto-generated method stub
		EmialAdd = Emial_id.getText().toString();
		begning = intro.getText().toString();
		Name = Persons_Name.getText().toString();
		StupidAction = Stupid_things.getText().toString();
		HatefulAct = Hateful_Actions.getText().toString();
		out = Outro.getText().toString();
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
	
	
	
	
	

}
