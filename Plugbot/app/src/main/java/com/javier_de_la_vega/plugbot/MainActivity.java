package com.javier_de_la_vega.plugbot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {
    String TAG = " TAG";
    UsbManager usbManager;
    EditText textView;
    TextView main;
    int tries =0;
    Button plusOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(onplugbroadcast_receiver, new IntentFilter("usb_connected"));
        registerReceiver(onplugbroadcast_receiver, new IntentFilter("usb_disconnected"));
        textView = (EditText)findViewById( R.id.editText3);
        textView.setKeyListener(null);
        plusOne = (Button)findViewById(R.id.button2);

        main = (TextView) findViewById( R.id.textField);

        plusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tries = tries +1;
                textView.setText(Integer.toString(tries));
            }
        });

    }


    BroadcastReceiver onplugbroadcast_receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context arg0, Intent intent) {

            String action = intent.getAction();
            if (action.equals("usb_connected")) {

                new CountDownTimer(14000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        main.setText("Seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.ring);
                        ring.start();
                        main.setText("Prepare to disconenct in a few seconds!");
                    }
                }.start();
            }
            if (action.equals("usb_disconnected")) {

                //Toast.makeText(getApplicationContext(), "usb_disconnected", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "usb_connected", Toast.LENGTH_SHORT).show();
                new CountDownTimer(14000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        main.setText("Seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.diconnect);
                        ring.start();
                        main.setText("Conenct to HU!");
                    }
                }.start();
                // DO WHATEVER YOU WANT.
            }
        }
    };




    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(onplugbroadcast_receiver, new IntentFilter());

    }

    @Override
    protected void onPause() {
        super.onPause();
        registerReceiver(onplugbroadcast_receiver, new IntentFilter());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putBoolean("tries", tries);
        savedInstanceState.putDouble("myDouble", 1.9);
        savedInstanceState.putInt("MyInt", 1);
        savedInstanceState.putString("MyString", "Welcome back to Android");
        // etc.
    }
}
