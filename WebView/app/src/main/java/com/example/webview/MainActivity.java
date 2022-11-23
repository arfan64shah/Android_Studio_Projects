package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity {

    WebView browser;
    EditText link;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = (WebView) findViewById(R.id.webview);
        link = (EditText) findViewById(R.id.editTextLink);
        button = (Button) findViewById(R.id.button);

        browser.setWebViewClient(new myWebViewClient());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = link.getText().toString();
                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);

                browser.loadUrl(url);
            }
        });

    }

    private class myWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}