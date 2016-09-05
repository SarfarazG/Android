package com.example.saf.explicit_intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Home extends Activity{
    EditText lbluname,lbluid;
    String username;
    int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        lbluname= (EditText) this.findViewById(R.id.lbluname);
        lbluid= (EditText) this.findViewById(R.id.lbluid);

        username = this.getIntent().getExtras().getString("username");
        uid = this.getIntent().getExtras().getInt("uid");
        lbluname.setText(username);
        lbluid.setText("" + uid);
    }
}
