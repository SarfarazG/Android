package com.example.saf.explicit_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by SAF on 25-Aug-16.
 */
public class Otp extends Activity {

        Button btnotp2;
        TextView txtotp;
        Intent Switch_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp);
        btnotp2 = (Button)this.findViewById(R.id.btnotp2);
        txtotp = (TextView)this.findViewById(R.id.txtotp);
        Random rd = new Random();
        final Long randomizer=rd.nextLong();
        txtotp.setText(""+randomizer);
        btnotp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Switch_intent = new Intent(Otp.this,Login.class);
                Switch_intent.putExtra("otpno",randomizer);
                Otp.this.finish();
            }
        });
    }
    @Override
    public void finish(){
        this.setResult(888,Switch_intent);
        super.finish();
    }
}
