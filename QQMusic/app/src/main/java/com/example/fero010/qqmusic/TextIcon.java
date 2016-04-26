package com.example.fero010.qqmusic;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by FERO010 on 2016/4/26.
 */
public class TextIcon{

    final static Typeface face = Typeface.createFromAsset(MyApplication.getAppContext().getAssets(), "icomoon.ttf");

    static int CodeHome = 0xE605;

    static String getStr(int uinicode) {
        try {
            return new String(new byte[]{(byte) (uinicode >> 8 & 0xff),
                    (byte) (uinicode & 0xff)}, "unicode");
        } catch (Exception e) {
            return null;
        }

    }



    public static String tag = getStr(0xe900);
    public static String music = getStr(0xe901);
    public static String two = getStr(0xe902);
    public static String word = getStr(0xe903);



    public static void setHomeIcon(TextView tv) {
        tv.setText(getStr(CodeHome));
        tv.setTypeface(face);
    }

    public static void setForIcon(TextView tv, String string) {
        tv.setText(string);
        tv.setTypeface(face);
    }

    public static void setPesonIcon(TextView tv) {

    }
}
