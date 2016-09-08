package com.example.saf.storage_sharedprefrences;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.renderscript.Element;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

    Button btnlogin;
    EditText txtusername2,txtpassword2;
    Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        allocatememory();
        final DataStorage storage = new DataStorage("SAF_G",this);
        boolean reg_status = Boolean.parseBoolean(storage.read("Registerstatus", DataStorage.BOOLEAN).toString());
        boolean log_status = Boolean.parseBoolean(storage.read("loginstatus", DataStorage.BOOLEAN).toString());
        if(reg_status==false)
        {
            Intent Switch_intent = new Intent(ctx,Register.class);
            ctx.startActivity(Switch_intent);
            Login.this.finish();
        }
        if(log_status==true)
        {
            Intent Switch_intent = new Intent(ctx,Home.class);
            ctx.startActivity(Switch_intent);
            Login.this.finish();
        }
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username,password;
                username = txtusername2.getText().toString();
                username=username.trim();
                password = txtpassword2.getText().toString();
                password=password.trim();
                if(username.equals("admin")==true && password.equals("123123")==true){
                    storage.write("Username",username);
                    storage.write("Userid",99);// use any id u want
                    storage.write("loginstatus",true);
                    Intent Switch_intent = new Intent(ctx,Home.class);
                    Login.this.startActivity(Switch_intent);
                }

            }
        });
    }

    private void allocatememory() {
        ctx=this;
        txtusername2 = (EditText) this.findViewById(R.id.txtusername2);
        txtpassword2 = (EditText) this.findViewById(R.id.txtpassword2);
        btnlogin = (Button) this.findViewById(R.id.btnlogin);
    }
}
