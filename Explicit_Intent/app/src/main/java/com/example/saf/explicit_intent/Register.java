package com.example.saf.explicit_intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by SAF on 16-Aug-16.
 */
public class Register extends Activity{

    EditText lblusername2,lblpassword2,lblmobile,lblemail;
    Button btnregister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        allocatememory();
    }

    private void allocatememory() {

        lblusername2 = (EditText)this.findViewById(R.id.lblusername2);
        lblpassword2 = (EditText)this.findViewById(R.id.lblpassword2);
        lblemail = (EditText)this.findViewById(R.id.lblemail);
        lblmobile = (EditText)this.findViewById(R.id.lblmobile);
        btnregister2 = (Button)this.findViewById(R.id.btnregister2);

    }

}
