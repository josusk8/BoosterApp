package com.example.boosterweigthlifting.ui.popup;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boosterweigthlifting.R;


public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        DisplayMetrics medidaVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);

        int ancho = medidaVentana.widthPixels;
        int alto = medidaVentana.heightPixels;

        getWindow().setLayout((int) (ancho * 0.85), (int) (alto * 0.5));

        WebView wvInfo = (WebView) findViewById(R.id.wvInfo);

        Bundle extras = getIntent().getExtras();
        String URL = extras.get("url").toString();

        String videoStr = (new VideoHtmlString().getHtmlString(URL));

        wvInfo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        WebSettings ws = wvInfo.getSettings();
        ws.setJavaScriptEnabled(true);
        wvInfo.loadData(videoStr, "text/html", "utf-8");


    }
}