package com.example.boosterweigthlifting.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boosterweigthlifting.MainActivity;
import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.persistence.interfaces.ApiAdapter;
import com.example.boosterweigthlifting.persistence.models.Usuario;
import com.example.boosterweigthlifting.persistence.utils.Globals;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    Button btnLogin;
    TextView tvRegister;
    TextInputEditText etEmail;
    TextInputEditText etPassword;
    String password = "";
    String email = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etPassword = (TextInputEditText) findViewById(R.id.etPassword);
/*
        etEmail.setText("josusk8@gmail.com");
        etPassword.setText("1234");
*/

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = etPassword.getText().toString();
                email = etEmail.getText().toString();
                connect();
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

    private void startApp() {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
    }

    private void connect() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Globals.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiAdapter apiAdapter = retrofit.create(ApiAdapter.class);
        Call<ArrayList<Usuario>> call = apiAdapter.getUsuarioByEmailAndPass(email, password);

        call.enqueue(new Callback<ArrayList<Usuario>>() {
                         Usuario usuario = new Usuario();

                         @Override
                         public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
                             //Toast.makeText(getApplicationContext(), "Login: " + response.code(), Toast.LENGTH_SHORT).show();

                             for (int i = 0; i < response.body().size(); i++) {
                                 String emailCompare = "";
                                 emailCompare = response.body().get(i).getEmail();

                                 if (email.contains(emailCompare)) {
                                     usuario = response.body().get(i);
                                 }
                             }

                             if (usuario.getNombre() == null) {
                                 Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();

                             } else {

                                 if (usuario.getPass().toString().equals(password.toString())) {
                                     Globals.idUsuario = usuario.getIdUsuario();
                                     startApp();
                                 } else {
                                     Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                 }

                             }

                             return;
                         }

                         @Override
                         public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                             Toast.makeText(getApplicationContext(), "Codigo: " + t.getMessage(), Toast.LENGTH_LONG).show();
                         }
                     }
        );

    }
}
