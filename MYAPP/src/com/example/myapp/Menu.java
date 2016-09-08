package com.example.myapp;

import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Menu  extends ListActivity{
	
	String list[] = {"MainActivity","TextPlay","Email","Camera",
			         "Data","example5","example6","example7"}; 

	@Override
	protected void onCreate(Bundle safloveniece) {
		// TODO Auto-generated method stub
		super.onCreate(safloveniece);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, list));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String selection = list[position];
		try{
		Class ourclass = Class.forName("com.example.myapp."+selection);
		Intent nextactivity = new Intent(Menu.this,ourclass);
		startActivity(nextactivity);
		}catch(Exception e){
			System.out.println(" "+" ERROR IS HERE"+e);
			e.printStackTrace();
		}
		}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		 MenuInflater blowup = getMenuInflater();
		 blowup.inflate(R.menu.collmenu, menu);
		 return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		
		case R.id.aboutus:
			
			Intent I = new Intent("com.example.myapp.ABOUT");
			startActivity(I);
			
			break;
			
		case R.id.prefrences:
			Intent a = new Intent("com.example.myapp.PREFS");
			startActivity(a);
			break;
		case R.id.exit:
			finish();
		}
		return false;
		
	}


}
