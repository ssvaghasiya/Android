package com.example.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("https://www.google.com");
        String str = "<html><body><center><h1>Hello World</h1></center></body></html>";
        webView.loadData(str,"text/html","UTF-8");
    }
}
