package com.example.saf.toast_and_ratingbar;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Toast_AND_RatingBar extends AppCompatActivity {

    TextView lblquality;
    RatingBar rbquality;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast__and__rating_bar);

        this.allocatememory();
        rbquality.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                lblquality.setText(""+rbquality.getProgress());
                Toast.makeText(ctx,""+rbquality.getProgress(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void allocatememory(){

        lblquality =(TextView) this.findViewById(R.id.textView);
        rbquality = (RatingBar) this.findViewById(R.id.ratingBar);
        ctx=this;

    }


    }

