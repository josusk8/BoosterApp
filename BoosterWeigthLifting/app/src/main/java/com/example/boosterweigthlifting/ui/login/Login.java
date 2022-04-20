package com.example.boosterweigthlifting.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boosterweigthlifting.MainActivity;
import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.persistence.interfaces.ApiAdapter;
import com.example.boosterweigthlifting.persistence.models.Wod;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    Button btnLogin;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);

        String url1 = "http://10.0.2.2:8080/booster/v1/";
        String url2 = "http://192.168.31.249:8080/booster/v1/";

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(url2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiAdapter apiAdapter = retrofit.create(ApiAdapter.class);

        Call<ArrayList<Wod>> call = apiAdapter.getAllWod();

        call.enqueue(new Callback<ArrayList<Wod>>() {
            @Override
            public void onResponse(Call<ArrayList<Wod>> call, Response<ArrayList<Wod>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<Wod> objectList = response.body();

                Log.d("Estado2", objectList.get(0).getDia()+"");
                btnLogin.setText(objectList.get(0).getFecha()+"");


            }

            @Override
            public void onFailure(Call<ArrayList<Wod>> call, Throwable t) {
                Log.d("Estado", t.getMessage());
                Toast.makeText(getApplicationContext(),"Codigo: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(getApplicationContext(), RegistrerActivity.class);
                startActivity(register);
            }
        });


    }
}
