package com.example.boosterweigthlifting.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.boosterweigthlifting.MainActivity;
import com.example.boosterweigthlifting.R;

public class Login extends AppCompatActivity {

    Button btnLogin;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Intent mainActivity= new Intent(getApplicationContext(), MainActivity.class);
                       startActivity(mainActivity);
                    }
                });

        tvRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Intent register = new Intent(getApplicationContext(),RegistrerActivity.class);
                       startActivity(register);
                    }
                });


        }
}
