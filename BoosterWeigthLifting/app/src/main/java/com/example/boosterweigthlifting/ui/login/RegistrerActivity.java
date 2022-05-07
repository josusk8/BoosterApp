package com.example.boosterweigthlifting.ui.login;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.persistence.interfaces.ApiAdapter;
import com.example.boosterweigthlifting.persistence.models.Usuario;
import com.example.boosterweigthlifting.persistence.utils.RetrofitClient;
import com.google.common.collect.Range;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrerActivity extends AppCompatActivity {

    EditText etEmailRegister;
    EditText etPasssword;
    EditText etNameRegister;
    EditText etSurnameRegister;
    EditText etWeigthRegister;
    RadioButton rbMen;
    RadioButton rbWoman;
    Button btnCreate;
    DatePicker dpDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        etEmailRegister = (EditText) findViewById(R.id.etEmailRegister);
        etPasssword = (EditText) findViewById(R.id.etPasswordRegister);
        etNameRegister = (EditText) findViewById(R.id.etNameRegister);
        etSurnameRegister = (EditText) findViewById(R.id.etSurnameRegister);
        etWeigthRegister = (EditText) findViewById(R.id.etWeigthRegister);
        rbMen = (RadioButton) findViewById(R.id.rbMen);
        rbWoman = (RadioButton) findViewById(R.id.rbWoman);

        dpDate = (DatePicker) findViewById(R.id.dpDate);

        dpDate.setMinDate(-2198236896L);
        dpDate.setMaxDate(Calendar.getInstance().getTimeInMillis());


        AwesomeValidation mAwesomeValidation = new AwesomeValidation(BASIC);

        String regexEmail = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
        mAwesomeValidation.addValidation(this, R.id.etEmailRegister, regexEmail, R.string.errorEmail);

        String regexName = "[\\D]+";
        mAwesomeValidation.addValidation(this, R.id.etNameRegister, regexName, R.string.errorName);

        String regexSurname = "[\\D]+";
        mAwesomeValidation.addValidation(this, R.id.etSurnameRegister, regexSurname, R.string.errorSurname);

        mAwesomeValidation.addValidation(this, R.id.etWeigthRegister, Range.closed(20.0f, 300f), R.string.errorKg);
        /*
         * La contraseña debe tener al entre 8 y 16 caracteres,
         * al menos un dígito, al menos una minúscula y al menos una mayúscula.
         * NO puede tener otros símbolos.
         */
        String regexPassword = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";
        mAwesomeValidation.addValidation(this, R.id.etPasswordRegister, regexPassword, R.string.errorPassword);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAwesomeValidation.validate()) {


                    try {

                        int dayOfMonth = dpDate.getDayOfMonth();
                        int month = dpDate.getMonth();
                        int year = dpDate.getYear();
                        String email = "";
                        String nombre = "";
                        String apellidos = "";
                        String pass = "";
                        String fechaNacimiento =
                                year + "-" + String.format("%02d", month) + "-" + String.format("%02d", dayOfMonth);
                        Float peso = 0f;
                        String sexo = "";

                        email = etEmailRegister.getText().toString().replaceAll("\\s+","");
                        pass = etPasssword.getText().toString().replaceAll("\\s+","");;
                        nombre = etNameRegister.getText().toString().replaceAll("\\s+","");;
                        apellidos = etSurnameRegister.getText().toString().replaceAll("\\s+","");;

                        if(rbMen.isChecked()){
                            sexo = "H";
                        }
                        if(rbWoman.isChecked()){
                            sexo = "M";
                        }

                        peso = Float.parseFloat(etWeigthRegister.getText().toString());

                        ApiAdapter apiAdapter = RetrofitClient.getClient().create(ApiAdapter.class);

                        Call<Usuario> call = apiAdapter.setUserString("" +
                                "{\n" +
                                "        \"apellidos\": \"" + apellidos + "\",\n" +
                                "        \"email\": \"" + email + "\",\n" +
                                "        \"fechaNacimiento\": \"" + fechaNacimiento + "\",\n" +
                                "        \"nombre\": \"" + nombre + "\",\n" +
                                "        \"pass\": \"" + pass + "\",\n" +
                                "        \"peso\":" + peso + ",\n" +
                                "        \"sexo\": \"" + sexo + "\"\n" +
                                "    }");

                        call.enqueue(new Callback<Usuario>() {
                            @Override
                            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                                Log.d("Estado", "auii1");

                                if (response.code() == 200) {
                                    Toast.makeText(view.getContext(), R.string.NewUserCreate, Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(view.getContext(), "Error: " + response.code(), Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Usuario> call, Throwable t) {

                                Toast.makeText(view.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });


                    } catch (Exception e) {
                    }

                }


            }
        });


    }
}