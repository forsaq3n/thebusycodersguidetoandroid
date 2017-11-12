package com.example.ubuntupc.lifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class OtherActivity extends LifecycleLoggingActivity {
    public static final String EXTRA_MESSAGE="msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);


        TextView tv=(TextView)findViewById(R.id.msg);

        tv.setText(getIntent().getStringExtra(EXTRA_MESSAGE));

    }

}
