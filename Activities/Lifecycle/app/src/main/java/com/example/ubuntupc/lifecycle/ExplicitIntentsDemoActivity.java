package com.example.ubuntupc.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class ExplicitIntentsDemoActivity extends LifecycleLoggingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intents_demo);
    }

    public void showOther(View v) {
        Intent other=new Intent(this, OtherActivity.class);

        other.putExtra(OtherActivity.EXTRA_MESSAGE,
                getString(R.string.other));
        startActivity(other);
    }

}
