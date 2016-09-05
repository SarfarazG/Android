package com.example.saf.intent_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

    EditText lblusername,lblpassword;
    Button btnlogin,btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);

        allocatememory();
        setlistner();

    }

    private void setlistner() {

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Switch_Intent = new Intent(Login.this,Register.class);
                Login.this.startActivity(Switch_Intent);
            }
        });
    }

    private void allocatememory() {

        lblusername = (EditText) this.findViewById(R.id.lblusername);
        lblpassword = (EditText) this.findViewById(R.id.lblpassword);
        btnlogin = (Button)this.findViewById(R.id.btnlogin);
        btnlogin = (Button) this.findViewById(R.id.btnregister);

    }


}
