package com.example.saf.implicit_intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ACTION_Example extends Activity {

    EditText lblfirstvalue,lblsecondvalue;
    Button btncall,btndialer,btnbrowser,btngmail,btnmap;
    Intent myintent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action__example);
        allocatememory();
        setlistner();
    }
    private void setlistner() {

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile =lblfirstvalue.getText().toString();
                myintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+mobile));
                ACTION_Example.this.startActivity(myintent);
            }
        });
        btndialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dialer = lblfirstvalue.getText().toString();
                myintent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+dialer));
                ACTION_Example.this.startActivity(myintent);
            }
        });
        btnbrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String browse = lblfirstvalue.getText().toString();
                myintent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://" +browse));
                ACTION_Example.this.startActivity(myintent);
            }
        });
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lat = lblfirstvalue.getText().toString();
                String lng = lblsecondvalue.getText().toString();
                String co_ordinates = lat+","+lng;
                myintent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://" +co_ordinates));
                ACTION_Example.this.startActivity(myintent);
            }
        });
        btngmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = lblfirstvalue.getText().toString();
                String EmailAddress[]={email};
                myintent = new Intent(Intent.ACTION_SEND);
                myintent.putExtra(Intent.EXTRA_EMAIL, EmailAddress);
                myintent.setType("plain/text");
                ACTION_Example.this.startActivity(Intent.createChooser(myintent,""));
            }
        });
    }

    private void allocatememory() {
        lblfirstvalue = (EditText)this.findViewById(R.id.lblfirstvalue);
        lblsecondvalue = (EditText)this.findViewById(R.id.lblsecondvalue);
        btncall = (Button)this.findViewById(R.id.btncall);
        btndialer = (Button)this.findViewById(R.id.btndialer);
        btnbrowser = (Button)this.findViewById(R.id.btnbrowser);
        btngmail = (Button)this.findViewById(R.id.btngmail);
        btnmap = (Button)this.findViewById(R.id.btnmap);
        btngmail = (Button) this.findViewById(R.id.btngmail);
    }

}
