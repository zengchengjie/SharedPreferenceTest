package com.example.zcj.sharedpreferencetest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zcj on 2016/11/7.
 */
public class SpUtil {

    private static final String SP_NAME = "com.tjz.sp";
    private static final String SP_KEY = "key";

    public static void put(Context context, String value){
        SharedPreferences sp =context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        sp.edit().putString(SP_KEY,value).commit();
    }

    public static String get(Context context){
        SharedPreferences sp =context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        return sp.getString(SP_KEY,null);
    }
}
