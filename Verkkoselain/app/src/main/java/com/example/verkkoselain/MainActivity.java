package com.example.verkkoselain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String urlText = "file:///android_asset/index.html";

    private WebView web;
    private EditText url;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        url = (EditText) findViewById(R.id.urlInput);
        url.setOnEditorActionListener(newListener);

        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
    }

    TextView.OnEditorActionListener newListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_NULL || actionId == EditorInfo.IME_ACTION_DONE) {
                url = (EditText) findViewById(R.id.urlInput);
                String newUrl = url.getText().toString();
                changeUrl(newUrl);
            }
            return true;
        }
    };

    private void changeUrl(String newUrl) {
        if (newUrl.equals("index.html")) {
            newUrl = urlText;
        }
        else if (!(newUrl.startsWith("https://") || newUrl.startsWith("http://"))) {
            newUrl = "https://" + newUrl;
        }
        web.loadUrl(newUrl);
    }

    public void refreshPage (View v) {
        web.reload();
    }
/*
    public void shoutOut (View v) {

        web.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                web.loadUrl("javascript:shoutOut()");
            }
        });
        //web.loadUrl("file///android_asset/index.html");
        //web.loadUrl("javascript:shoutOut()");
    } */


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void shoutOut(View v) {
        web.loadUrl("");
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

}