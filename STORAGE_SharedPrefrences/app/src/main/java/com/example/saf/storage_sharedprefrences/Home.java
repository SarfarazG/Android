package com.example.saf.storage_sharedprefrences;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends Activity {

    TextView lblusername,lbluserid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        lblusername = (TextView)  this.findViewById(R.id.lblusername);
        lbluserid = (TextView)  this.findViewById(R.id.lbluserid);

        DataStorage storage = new DataStorage("SAF_G",this);
        String result = storage.read("Username",DataStorage.STRING).toString();
        lblusername.setText("" + result);
        int result1=Integer.parseInt(storage.read("Userid", DataStorage.INTEGER).toString());
        lbluserid.setText(""+result1);
    }
}
