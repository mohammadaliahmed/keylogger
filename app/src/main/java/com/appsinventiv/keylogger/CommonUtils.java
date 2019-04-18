package com.appsinventiv.keylogger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.widget.Toast;

import android.net.ConnectivityManager;
/*
 * Created by AliAh on 14/05/2018.
 */

public class CommonUtils {


    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static void showToast(final String msg) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @SuppressLint("WrongConstant")
            public void run() {
                Toast.makeText(ApplicationClass.getInstance().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }




}
