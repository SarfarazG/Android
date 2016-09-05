package com.example.saf.explicit_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    EditText lblusername,lblpassword;
    Button btnlogin,btnregister,btnotp;
    Intent Switch_Intent;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        allocatememory();
        
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = lblusername.getText().toString();
                password = lblpassword.getText().toString();
                if (username.equals("saf") == true
                        && password.equals("1214") == true) {
                    Switch_Intent = new Intent(Login.this, Home.class);
                    Switch_Intent.putExtra("username", username);
                    Switch_Intent.putExtra("uid", 99);
                    Login.this.startActivity(Switch_Intent);
                    Login.this.finish();

                } else {
                    Toast.makeText(Login.this, "Enter valid inputs", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Switch_Intent = new Intent(Login.this,Register.class);
                Login.this.startActivity(Switch_Intent);
            }
        });
        btnotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Switch_Intent = new Intent(Login.this,Otp.class);
                Login.this.startActivityForResult(Switch_Intent, 88);
            }
        });
    }
    private void allocatememory() {

        lblusername = (EditText)this.findViewById(R.id.lblusername);
        lblpassword = (EditText)this.findViewById(R.id.lblpassword);
        btnlogin = (Button)this.findViewById(R.id.btnlogin);
        btnregister = (Button)this.findViewById(R.id.btnregister);
        btnotp = (Button)this.findViewById(R.id.btnotp);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==88 && resultCode==888&& data!=null){

            long otp_number=data.getLongExtra("otpno",0);
            btnotp.setText(""+otp_number);
        }

    }
}
