package com.example.saf.storage_sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.AvoidXfermode;

/**
 * Created by SAF on 01-Sep-16.
 */
public class DataStorage {

    private String Filename;
    private Context ctx;
    SharedPreferences pref = null;
    SharedPreferences.Editor Edit = null;

    public static final int INTEGER =1;
    public static final int FLOAT =2;
    public static final int STRING =3;
    public static final int BOOLEAN =4;


    public DataStorage(String Filename,Context ctx ){

        this.Filename = Filename;
        this.ctx = ctx;
        pref = ctx.getSharedPreferences(Filename,ctx.MODE_PRIVATE);
        Edit = pref.edit();
    }

    public void write(String key,int value){
        Edit.putInt(key,value);
        Edit.commit();
    }
    public void write(String key,Float value){
        Edit.putFloat(key, value);
        Edit.commit();
    }

    public void write(String key,String value){
        Edit.putString(key, value);
        Edit.commit();
    }
    public void write(String key,boolean value){
        Edit.putBoolean(key, value);
        Edit.commit();
    }

    public Object read(String key,int DataType){
        Object temp = new Object();
        if(DataType==INTEGER)
            temp = pref.getInt(key,0);
        else if(DataType==FLOAT)
            temp = pref.getFloat(key, 0.0f);
        else if(DataType==STRING)
            temp = pref.getString(key,"");
        else if(DataType==BOOLEAN)
            temp = pref.getBoolean(key,false);

        return temp;
    }
  
}
