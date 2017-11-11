package com.javier_de_la_vega.browser3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browser = (WebView)findViewById(R.id.webkit);
        browser.setWebViewClient( new Callback());
        loadTime();
        
    }

    private void loadTime() {
        String page=
                "<html><body><a href='http://webview.used.to.be.less.annoying/clock'>"
                        + DateUtils.formatDateTime(this, new Date().getTime(),
                        DateUtils.FORMAT_SHOW_DATE
                                | DateUtils.FORMAT_SHOW_TIME)
                        + "</a></body></html>";
        browser.loadData(page, "text/html", "UTF-8");
    }

    private class Callback extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            loadTime();
            return true;
        }


    }
}
