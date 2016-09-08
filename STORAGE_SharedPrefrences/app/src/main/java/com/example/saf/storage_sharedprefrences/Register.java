package com.example.saf.storage_sharedprefrences;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity{

    Button btnregister;
    EditText txtusername,txtpassword,txtemail,txtphone;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        allocatememory();
        final DataStorage storage = new DataStorage("SAF_G",this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage.write("Registerstatus", true);
                Intent Switch_intent = new Intent(ctx,Login.class);
                ctx.startActivity(Switch_intent);
                Register.this.finish();
            }
        });

    }

    public void allocatememory(){

        txtusername = (EditText) this.findViewById(R.id.txtusername);
        txtpassword = (EditText) this.findViewById(R.id.txtpassword);
        txtemail = (EditText) this.findViewById(R.id.txtemail);
        txtphone = (EditText) this.findViewById(R.id.txtphone);
        btnregister = (Button) this.findViewById(R.id.btnregister);
        ctx=this;
    }
}
