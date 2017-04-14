package com.yexin.speak.Log;

import android.util.Log;

/**
 * Created by userd on 2016/12/12.
 */
public final class LogOut  {

    private LogOut() {

    }

    public static int v(String tag, String msg){
        return Log.v(tag,msg);
    }
    public static int d(String tag, String msg){
        return Log.d(tag,msg);
    }
    public static int i(String tag, String msg){
        return Log.i(tag,msg);
    }
    public  static int w(String tag, String msg){
        return Log.w(tag,msg);
    }
    public static  int e(String tag, String msg){
        return Log.e(tag,msg);
    }

}
