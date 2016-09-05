package com.example.saf.toggle_switch_button;

import android.app.Activity;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    Switch swtwifi,swtforecolor,swtfontsize;
    ToggleButton tgbbackcolor,tgbdata,tgbbluetooth,tgbflightmode;
    Button btndata,btnbluetooth;
    WifiManager manager;
    ConnectivityManager cmanager;
    RelativeLayout mylayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allocatememory();
        setlistner();
    }

    private void setlistner() {

        swtwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swtwifi.isChecked() == true)
                    manager.setWifiEnabled(true);
                else {
                    manager.setWifiEnabled(false);
                }
            }
        });
        swtforecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swtforecolor.isChecked()){
                    swtwifi.setTextColor(Color.GREEN);
                    swtforecolor.setTextColor(Color.GREEN);
                    swtfontsize.setTextColor(Color.GREEN);
                }else {
                    swtwifi.setTextColor(Color.RED);
                    swtforecolor.setTextColor(Color.RED);
                    swtfontsize.setTextColor(Color.RED);
                }
            }
        });
        swtfontsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swtfontsize.isChecked()){
                    swtwifi.setTextSize(20.0f);
                    swtforecolor.setTextSize(20.0f);
                    swtfontsize.setTextSize(20.0f);
                }
                else{
                    swtwifi.setTextSize(14.0f);
                    swtforecolor.setTextSize(14.0f);
                    swtfontsize.setTextSize(14.0f);
                }
            }
        });
        tgbbackcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgbbackcolor.isChecked()==true){
                    mylayout.setBackgroundColor(Color.GRAY);
                }
                else{
                    mylayout.setBackgroundColor(Color.GREEN);
                }
            }
        });
        btndata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkInfo ni = cmanager.getActiveNetworkInfo();
                ni.
                if(ni!=null){
                    ni.isConnected();
                }
            }

        });
    }

    private void allocatememory() {
        swtwifi = (Switch)this.findViewById(R.id.swtwifi);
        swtforecolor = (Switch)this.findViewById(R.id.swtforecolor);
        swtfontsize = (Switch)this.findViewById(R.id.swtfontsize);
        tgbbackcolor = (ToggleButton)this.findViewById(R.id.tgbbackcolor);
        tgbdata = (ToggleButton)this.findViewById(R.id.tgbbdata);
        tgbbluetooth = (ToggleButton)this.findViewById(R.id.tgbbluetooth);
        tgbflightmode = (ToggleButton)this.findViewById(R.id.tgbflightmode);
        btndata = (Button)this.findViewById(R.id.btndata);
        btnbluetooth = (Button)this.findViewById(R.id.btnbluetooth);

        manager = (WifiManager) this.getSystemService(WIFI_SERVICE);
        mylayout =(RelativeLayout)this.findViewById(R.id.mylayout);
        cmanager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);


    }
}
