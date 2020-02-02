package com.imagegrafia.javabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class PageActivity extends AppCompatActivity {

    private Bundle bundle;
    private static final String TAG = "PAGEACTIVITY";
    private Context mContext;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        mContext = this;
        webView = findViewById(R.id.simpleWebView);

        bundle = getIntent().getExtras();

        if (!bundle.equals(null)) {
            String data = bundle.getString("titles");

            Log.d(TAG, "is coming");

            String url = "file:android_asset/"+data+".html";
            webView.loadUrl(url);

            WebSettings webSettings =webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
        }
    }
}
