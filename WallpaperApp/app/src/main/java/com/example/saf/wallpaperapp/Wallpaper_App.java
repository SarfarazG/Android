package com.example.saf.wallpaperapp;

import android.app.WallpaperManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Wallpaper_App extends AppCompatActivity {

    Button btnfirst, btnprevious, btnnext, btnlast, btnwallpaper;
    RadioButton rbsim1,rbsim2;
    ImageView picture;
    int current = 1;
    int size = 6;
    int a[] = {0, R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six};
    WallpaperManager mywallpaper;
    Intent select = new Intent(Intent.ACTION_CHOOSER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallpaper__app);
        alocatememory();
        picture.setImageResource(a[1]);
        pressbutton();
    }

    private void pressbutton() {


        btnfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current=1;
                picture.setImageResource(a[1]);
                current++;

            }
        });

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (current > 1) {
                    current--;
                    picture.setImageResource(a[current]);
                }
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (current>=1 && current < size) {
                    current++;
                    picture.setImageResource(a[current]);
                }
            }
        });

        btnlast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                current=size;
                picture.setImageResource(a[size]);

            }
        });

        btnwallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mywallpaper = WallpaperManager.getInstance(getApplicationContext());
                try {
                    mywallpaper.setResource(a[current]);
                } catch (Exception e) {

                    System.out.println("error"+e);
                }
            }
        });

        rbsim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                select.putExtra("com.android.phone.extra.slot", 0);

            }
        });

        rbsim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                select.putExtra("com.android.phone.extra.slot", 1);
            }
        });
    }


    private void alocatememory() {

        btnfirst = (Button) this.findViewById(R.id.btnfirst);
        btnprevious = (Button) this.findViewById(R.id.btnprevious);
        btnnext = (Button) this.findViewById(R.id.btnnext);
        btnlast = (Button) this.findViewById(R.id.btnlast);
        btnwallpaper = (Button) this.findViewById(R.id.btnwallpaper);
        picture = (ImageView) this.findViewById(R.id.btnpicture);
        rbsim1 = (RadioButton) this.findViewById(R.id.rbsim1);
        rbsim2 = (RadioButton) this.findViewById(R.id.rbsim2);

    }


}
