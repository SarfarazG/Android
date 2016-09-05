package com.example.saf.intent_demo;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {

    EditText lblusername2,lblpassword2,lblemail2,lblmobile;
    Button btnregister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        allocatememory();

    }

    private void allocatememory() {

        lblusername2 = (EditText) this.findViewById(R.id.lblusername2);
        lblpassword2 = (EditText) this.findViewById(R.id.lblpassword2);
        lblemail2 = (EditText) this.findViewById(R.id.lblemail2);
        lblmobile = (EditText) this.findViewById(R.id.lblmobile);
        btnregister2 = (Button) this.findViewById(R.id.btnregister2);

    }
}
