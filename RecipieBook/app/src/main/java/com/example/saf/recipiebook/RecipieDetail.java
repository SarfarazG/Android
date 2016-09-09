package com.example.saf.recipiebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecipieDetail extends Activity {

    TextView lblrecepie,lblreceipeContent;
    Button  btnback;
    LinearLayout mylayout;
    int position=0;
    int fileid;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipiedetail);
        allocatememory();
        position = this.getIntent().getExtras().getInt("position");
        System.out.println("position is"+position);
        DataStorage storage = new DataStorage(this);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SI = new Intent(RecipieDetail.this,RecipieList.class);
                RecipieDetail.this.startActivity(SI);
                RecipieDetail.this.finish();
            }
        });
        switch(position){

            case 0:
                fileid = R.raw.pavbhaji;
                text= "PAV-BHAJI";
                mylayout.setBackgroundResource(R.mipmap.pavbhaji);
                break;
            case 1:

               fileid = R.raw.mysamosa;
                text="SAMOSA";
                mylayout.setBackgroundResource(R.mipmap.itsamosa);
                break;

            case 2:
                fileid = R.raw.panipuri;
                text= "PANI-PURI";
                mylayout.setBackgroundResource(R.mipmap.panipuri);
                break;
            case 3:
                fileid = R.raw.paneer;
                text= "PANEER";
                mylayout.setBackgroundResource(R.mipmap.paneer);
                break;
            case 4:
                fileid = R.raw.myicecreame;
                text= "ICE-CREAM";
                mylayout.setBackgroundResource(R.mipmap.icecream);
                break;
        }
        String filecontent = storage.ReadFromInternalStorage(fileid);
        lblrecepie.setText(text);
        lblreceipeContent.setText(filecontent);

    }

    private void allocatememory() {

        lblrecepie = (TextView) this.findViewById(R.id.lblrecipie);
        lblreceipeContent = (TextView) this.findViewById(R.id.lblreceipeContent);
        btnback = (Button) this.findViewById(R.id.btnback);
        mylayout = (LinearLayout) this.findViewById(R.id.mylayout);

    }
}
