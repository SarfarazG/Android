package com.example.saf.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.Inflater;

public class DialogActivity extends Activity {

    Button btnone,btntwo,btnthree,btncheck,btnradio,btndate,btntime,btncustom;
    ImageView ivdate,ivtime;
    TextView lblresult,lbldate,lbltime;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        allocatememory();
       // ivdate.setImageResource(R.drawable.datepicker);
        //ivtime.setImageResource(R.drawable.time);
        setlistner();
    }
    public void allocatememory() {
        btnone = (Button)this.findViewById(R.id.btnone);
        btntwo = (Button)this.findViewById(R.id.btntwo);
        btnthree = (Button)this.findViewById(R.id.btnthree);
        btncheck = (Button) this.findViewById(R.id.btncheck);
        btnradio = (Button) this.findViewById(R.id.btnradio);
        btndate = (Button) this.findViewById(R.id.btndate);
        btntime = (Button) this.findViewById(R.id.btntime);
        btncustom = (Button) this.findViewById(R.id.btncustom);
        lblresult = (TextView)this.findViewById(R.id.lblresult);
        lbldate = (TextView)this.findViewById(R.id.lbldate);
        lbltime = (TextView)this.findViewById(R.id.lbltime);
        ivdate = (ImageView) this.findViewById(R.id.ivdate);
        ivtime = (ImageView) this.findViewById(R.id.ivtime);
        ctx=this;
    }

    public void setlistner(){

        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // step-1: create an object of builder class
                AlertDialog.Builder build = new AlertDialog.Builder(ctx);

                //step-2: set title,message etc
                build.setTitle("1(one)Button dialog box Example");
                build.setIcon(R.mipmap.ic_launcher);
                build.setMessage("This is the example of the one button dialogbox");

                //step-3 set buttons on dialogbox
                build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"OK Button pressed",Toast.LENGTH_LONG).show();
                    }
                });

                //step-4: create the object of alertdialog
                AlertDialog alert = build.create();

                //step-5: show the dialogbox
                alert.show();
            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step-1: Create object of the builder class
                AlertDialog.Builder build = new AlertDialog.Builder(ctx);
                //step-2: set title,message etc for dialogbox
                build.setTitle("2(two) Button dialogbox");
                build.setIcon(R.mipmap.ic_launcher);
                build.setMessage("Example 2 button dialogbox ");
                //step-3: set buttons
                build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"OK button pressed",Toast.LENGTH_LONG).show();
                    }
                });
                build.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx, "CANCLE button pressed", Toast.LENGTH_LONG).show();
                    }
                });
                //step-4: create object of alertdialog
                AlertDialog alert = build.create();
                //step-5: show dialogbox
                alert.show();
            }
        });
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step-1: Create object of the builder class
                AlertDialog.Builder build = new AlertDialog.Builder(ctx);
                //step-2: set title,message etc for dialogbox
                build.setTitle("3(three) Button dialogbox");
                build.setIcon(R.mipmap.ic_launcher);
                build.setMessage("Example 3 button dialogbox ");
                //step-3: set buttons
                build.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx,"OK button pressed",Toast.LENGTH_LONG).show();
                    }
                });
                build.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx, "CANCLE button pressed", Toast.LENGTH_LONG).show();
                    }
                });
                build.setNeutralButton("maybe later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ctx, "MAYBE_LATER", Toast.LENGTH_LONG).show();
                    }
                });
                //step-4: create object of alertdialog
                AlertDialog alert = build.create();
                //step-5: show dialogbox
                alert.show();
            }
        });
        btnradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[]countrylist = ctx.getResources()
                        .getStringArray(R.array.Country_List);
                AlertDialog.Builder build = new AlertDialog.Builder(ctx);
                build.setTitle("RadioSelect dialogbox");
                build.setItems(countrylist, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        Toast.makeText(ctx, "Selected country is"
                                + countrylist[position], Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alert = build.create();
                alert.show();
            }
        });
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              final String[]fruitlist = ctx.getResources()
                        .getStringArray(R.array.FRUIT_LIST);
                boolean[] checkedlist = {true,false,true,false,true};
                AlertDialog.Builder build = new AlertDialog.Builder(ctx);
                build.setTitle("Multiselect dialogbox");
                build.setMultiChoiceItems(fruitlist, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        Toast.makeText(ctx, "Checked fruits is"
                                + fruitlist[position], Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alert = build.create();
                alert.show();
            }
        });
        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GregorianCalendar gc = new GregorianCalendar();
                int currentyear,currentmonth,currentday;
                currentyear = gc.get(Calendar.YEAR);
                currentmonth = gc.get(Calendar.MONTH)+1;
                currentday = gc.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dtp = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        lblresult.setText(day+"/"+month+"/"+year);
                    }
                }, currentyear,currentmonth,currentday);
                dtp.show();
            }

        });
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GregorianCalendar gc =new GregorianCalendar();
                int chour,cminute;
                chour =gc.get(Calendar.HOUR_OF_DAY);
                cminute = gc.get(Calendar.MINUTE);
                AlertDialog.Builder build = new AlertDialog.Builder(ctx);
                TimePickerDialog tp =new TimePickerDialog(ctx,
                        new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {
                        lblresult.setText(hour+":"+minute);
                    }
                }, chour, cminute, true);
                tp.show();
            }
        });
        ivdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GregorianCalendar gc = new GregorianCalendar();
                int currentyear,currentmonth,currentday;
                currentyear = gc.get(Calendar.YEAR);
                currentmonth = gc.get(Calendar.MONTH)+1;
                currentday = gc.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dtp = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        lbldate.setText(day+"/"+month+"/"+year);
                    }
                }, currentyear,currentmonth,currentday);
                dtp.show();
            }
        });
        ivtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GregorianCalendar gc =new GregorianCalendar();
                int chour,cminute;
                chour =gc.get(Calendar.HOUR_OF_DAY);
                cminute = gc.get(Calendar.MINUTE);
                AlertDialog.Builder build = new AlertDialog.Builder(ctx);
                TimePickerDialog tp =new TimePickerDialog(ctx,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hour, int minute) {
                                lbltime.setText(hour+":"+minute);
                            }
                        }, chour, cminute, true);
                tp.show();
            }
        });
        btncustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step-1: create object of builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                //step-2: create object of inflater(it used for creating the custom dialog box)
                LayoutInflater If =LayoutInflater.from(ctx);
                // step-3: inflate the view from xml
                final View myview=If.inflate(R.layout.login,null);
                //step-4: setview and create the buttons
                builder.setView(myview);
                builder.setPositiveButton("LOGIN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*when we want to call the another xml file from exsisting
                          java file then "View myview" is used */
                        String username, password;
                        EditText lblusername, lblpassword;
                        lblusername = (EditText) myview.findViewById(R.id.lblusername);
                        lblpassword = (EditText) myview.findViewById(R.id.lblpassword);
                        username = lblusername.getText().toString();
                        password = lblpassword.getText().toString();

                        Toast.makeText(ctx, "Usename:" + username + "Password:" + password
                                , Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(ctx, "Cancle button pressed", Toast.LENGTH_LONG).show();
                    }
                });
                //step-5: object of alertdialogbox
                AlertDialog Alert = builder.create();
                //Step-6: show the dialogbox
                Alert.show();
            }
        });

    }
}
