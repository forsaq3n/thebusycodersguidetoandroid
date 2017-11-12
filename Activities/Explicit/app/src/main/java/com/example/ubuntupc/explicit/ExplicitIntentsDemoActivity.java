package com.example.ubuntupc.explicit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExplicitIntentsDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intents_demo);
    }

    public void showOther(View view){
        startActivity(new Intent(this, OtherActivity.class));
    }
}
