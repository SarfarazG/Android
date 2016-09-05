package com.example.saf.modechanger;

import android.app.Activity;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Mode_Changer extends Activity {

    TextView lblcurrent;
    Spinner spmode;
    AudioManager manager;
    String[] ModeList ={"Ringing Mode","vibrate Mode","Silent Mode","Ringing+Vibrate Mode"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode__changer);
        allocatememory();
        fillspinner();
        spmode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                    manager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                else if(position==1)
                    manager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                else if(position==2)
                    manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
               /* else if(position==3) {
                    manager.setRingerMode(AudioManager.EXTRA_RINGER_MODE);
                }*/
                lblcurrent.setText(ModeList[position]);
                lblcurrent.setTextColor(Color.RED);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void allocatememory(){

        lblcurrent = (TextView) this.findViewById(R.id.lblcurrentmode);
        spmode = (Spinner) this.findViewById(R.id.spinner);
        manager = (AudioManager) this.getSystemService(AUDIO_SERVICE)

    }
    private void fillspinner(){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,ModeList);
        spmode.setAdapter(adapter);

    }
}
