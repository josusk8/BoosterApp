package com.example.boosterweigthlifting.ui.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.boosterweigthlifting.R;

public class CleanJerkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_jerk);

        DisplayMetrics medidaVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);

        int ancho = medidaVentana.widthPixels;
        int alto = medidaVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 0.85), (int) (alto * 0.5));
    }
}