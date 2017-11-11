package com.javier_de_la_vega.plugbot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by auto on 11/7/17.
 */

public class MyOnPlugReceiver extends BroadcastReceiver{
    String TAG = " MyOnPlugReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent();
        String action = intent.getAction().toString();
        if ( action.equals("android.intent.action.ACTION_POWER_CONNECTED")){
            intent1.setAction("usb_connected");
            context.sendBroadcast(intent1);
            Log.d(TAG,"MyOnPlugReceiver send connected received intent : "+action);

        }
        if ( action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")){
            intent1.setAction("usb_disconnected");
            context.sendBroadcast(intent1);
            Log.d(TAG,"MyOnPlugReceiver send disconnected received intent : "+action);
        }


    }
}
