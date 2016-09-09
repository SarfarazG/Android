package com.example.saf.recipiebook;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecipieList extends ListActivity {

    String recipilist[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //step1- Fetching the array having list of recipie(It works like Electric plug)
        recipilist=getResources().getStringArray(R.array.ItemList);
        //step2- now taking list view we wan to add in our activity(IT WORKS LIKE A CHARGER)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,recipilist);
        //step-3 Now creating a listView and Setting this adapter on that view(IT works like a laptop)
        ListView mylistview = this.getListView();
        mylistview.setAdapter(adapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent SI = new Intent(RecipieList.this,RecipieDetail.class);
                SI.putExtra("position",position);
                System.out.println("position is" + position);
                RecipieList.this.startActivity(SI);
            }
        });

    }
}
