package com.javier_de_la_vega.browser4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browser = (WebView)findViewById(R.id.webkit);

        browser.setWebViewClient( new WebViewClient(){
           @Override
            public boolean shouldOverrideUrlLoading( WebView view, String url){
               view.loadUrl(url);
               return (true);
           }

        });

        browser.loadUrl("http://commonsware.com");


    }
}
