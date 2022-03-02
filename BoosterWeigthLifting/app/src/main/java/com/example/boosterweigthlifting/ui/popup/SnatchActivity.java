package com.example.boosterweigthlifting.ui.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.boosterweigthlifting.R;


public class SnatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snatch);

        DisplayMetrics medidaVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);

        int ancho = medidaVentana.widthPixels;
        int alto = medidaVentana.heightPixels;

        getWindow().setLayout((int) (ancho * 0.85), (int) (alto * 0.5));

        WebView vSnatch = (WebView) findViewById(R.id.vSnatch);




        String URL = "https://www.youtube.com/embed/9xQp2sldyts";
        String videoStr = (new VideoHtmlString().getHtmlString(URL));

        vSnatch.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        WebSettings ws = vSnatch.getSettings();
        ws.setJavaScriptEnabled(true);
        vSnatch.loadData(videoStr, "text/html", "utf-8");


    }
}