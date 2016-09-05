package com.example.saf.malacounter;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Mala_Counter extends Activity {

    EditText lblmanka,lblmala;
    Button btnCount;
    int Malacounter,Mankacounter;


    @Override
    //bundle variable chaned from savedinstances to incomingvalues

    protected void onCreate(Bundle incomingvalues)
    {
        super.onCreate(incomingvalues);
        setContentView(R.layout.mala__counter);
        allocatememory();
        // one of the way to rotate the scrren-(screen orientation)
        if(incomingvalues!=null && incomingvalues.containsKey("malacount")==true && incomingvalues.containsKey("mankacount")==true)
        {
            Mankacounter = incomingvalues.getInt("mankacount");
            Malacounter = incomingvalues.getInt("malacount");
            lblmanka.setText(""+Mankacounter);
            lblmala.setText("" + Malacounter);
        }
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Mankacounter++;
                    lblmanka.setText(""+Mankacounter);
                    if(Mankacounter==108) {

                        Mankacounter = 0;
                        Malacounter++;
                        lblmala.setText("" + Malacounter);
                    }
            }
        });

        //TO TOAST THE  ORIENTATION,HEIGHT AND WIDTH OF ROTATED SCREEN
        WindowManager manager = this.getWindowManager();
        Display screen = manager.getDefaultDisplay();
        int height = screen.getHeight();
        int width = screen.getWidth();

        if(height>width)
        {
            Toast.makeText(this,"POTRAIT ORIENTATION",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"LANDSCAPE ORIENTATION",Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"HEIGHT="+height+" WIDTH="+width+"",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onSaveInstanceState(Bundle outgoingvalues) {//bundle variable chaned from savedinstances to outgoingvalues
        super.onSaveInstanceState(outgoingvalues);
        outgoingvalues.putInt("mankacount",Mankacounter);
        outgoingvalues.putInt("malacount",Malacounter);
    }

    private void allocatememory() {

        //not to allow to rotate the screen
       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        //  this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);




        lblmala = (EditText) this.findViewById(R.id.lblmala);
        lblmanka = (EditText) this.findViewById(R.id.lblmanka);
        btnCount = (Button) this.findViewById(R.id.btnCount);
    }


}

