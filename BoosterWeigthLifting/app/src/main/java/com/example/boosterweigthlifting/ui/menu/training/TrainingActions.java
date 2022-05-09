package com.example.boosterweigthlifting.ui.menu.training;


import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boosterweigthlifting.Ejercicio;
import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.Wod;
import com.example.boosterweigthlifting.persistence.interfaces.ApiAdapter;
import com.example.boosterweigthlifting.persistence.models.MovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.PullMovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.Squat;
import com.example.boosterweigthlifting.persistence.models.VarMovimientoSecundario;
import com.example.boosterweigthlifting.persistence.utils.Globals;
import com.example.boosterweigthlifting.persistence.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingActions {
    View view;

    ImageButton week1;
    ImageButton week2;
    ImageButton week3;
    ImageButton week4;
    AutoCompleteTextView actv1;
    AutoCompleteTextView actv2;
    AutoCompleteTextView actv3;
    AutoCompleteTextView actv4;
    Button btnCalcular;
    TextView tvSalida;

    Ejercicio movPrincipal;
    Ejercicio movSecPrincipal;
    Ejercicio movVariante;
    Ejercicio sentadillas;
    Wod wod;
    com.example.boosterweigthlifting.persistence.models.Wod wodGrabar;
    com.example.boosterweigthlifting.persistence.models.Wod wodConId;

    int semana;

    public TrainingActions(View v) {
        this.view = v;

        btnCalcular = (Button) view.findViewById(R.id.btnCalcular);
        tvSalida = (TextView) view.findViewById(R.id.tvSalida);
        actv1 = (AutoCompleteTextView) view.findViewById(R.id.autoComplete1);
        actv2 = (AutoCompleteTextView) view.findViewById(R.id.autoComplete2);
        actv3 = (AutoCompleteTextView) view.findViewById(R.id.autoComplete3);
        actv4 = (AutoCompleteTextView) view.findViewById(R.id.autoComplete4);
        week1 = (ImageButton) view.findViewById(R.id.week1);
        week2 = (ImageButton) view.findViewById(R.id.week2);
        week3 = (ImageButton) view.findViewById(R.id.week3);
        week4 = (ImageButton) view.findViewById(R.id.week4);
        semana = 0;
    }


    public void setTraining(int semana, int dia) {

        movPrincipal = new Ejercicio(actv1.getText().toString(), Globals.lastRmSnatch);
        movSecPrincipal = new Ejercicio(actv2.getText().toString(), Globals.lastRmSnatch);
        movVariante = new Ejercicio(actv3.getText().toString(), Globals.lastRmSnatch);
        sentadillas = new Ejercicio(actv4.getText().toString(), Globals.lastRmSquat);

        wod = new Wod(movPrincipal, movSecPrincipal, movVariante, sentadillas);
        wod.makeWod(semana, 0);
        String salida =
                "A) " + wod.getMovPrincipal().getNombre() +
                        System.getProperty("line.separator") +
                        wod.getMovPrincipal().getPeso()[0] + "kg" + " - " + wod.getMovPrincipal().getPeso()[1] + "kg" +
                        System.getProperty("line.separator") +
                        wod.getMovPrincipal().getRepsSerie()[0] + " - " + wod.getMovPrincipal().getRepsSerie()[1] + " Series" +
                        System.getProperty("line.separator") +
                        wod.getMovPrincipal().getRepsTotal()[0] + " - " + wod.getMovPrincipal().getRepsTotal()[1] +
                        " Reps (" + wod.getMovPrincipal().getRepsOptima() + ")" +
                        System.getProperty("line.separator") +

                        System.getProperty("line.separator") +


                        "B) " + wod.getPullMovPrincipal().getNombre() +
                        System.getProperty("line.separator") +
                        wod.getPullMovPrincipal().getPeso()[0] + "kg" + " - " + wod.getPullMovPrincipal().getPeso()[1] + "kg" +
                        System.getProperty("line.separator") +
                        wod.getPullMovPrincipal().getRepsSerie()[0] + " - " + wod.getPullMovPrincipal().getRepsSerie()[1] + " Series" +
                        System.getProperty("line.separator") +
                        wod.getPullMovPrincipal().getRepsTotal()[0] + " - " + wod.getPullMovPrincipal().getRepsTotal()[1] +
                        " Reps (" + wod.getPullMovPrincipal().getRepsOptima() + ")" +
                        System.getProperty("line.separator") +

                        System.getProperty("line.separator") +


                        "C) " + wod.getVarMovSecundario().getNombre() +
                        System.getProperty("line.separator") +
                        wod.getVarMovSecundario().getPeso()[0] + "kg" + " - " + wod.getVarMovSecundario().getPeso()[1] + "kg" +
                        System.getProperty("line.separator") +
                        wod.getVarMovSecundario().getRepsSerie()[0] + " - " + wod.getVarMovSecundario().getRepsSerie()[1] + " Series" +
                        System.getProperty("line.separator") +
                        wod.getVarMovSecundario().getRepsTotal()[0] + " - " + wod.getVarMovSecundario().getRepsTotal()[1] +
                        " Reps (" + wod.getVarMovSecundario().getRepsOptima() + ")" +
                        System.getProperty("line.separator") +

                        System.getProperty("line.separator") +


                        "D) " + wod.getSentadillas().getNombre() +
                        System.getProperty("line.separator") +
                        wod.getSentadillas().getPeso()[0] + "kg" + " - " + wod.getSentadillas().getPeso()[1] + "kg" +
                        System.getProperty("line.separator") +
                        wod.getSentadillas().getRepsSerie()[0] + " - " + wod.getSentadillas().getRepsSerie()[1] + " Series" +
                        System.getProperty("line.separator") +
                        wod.getSentadillas().getRepsTotal()[0] + " - " + wod.getSentadillas().getRepsTotal()[1] +
                        " Reps (" + wod.getSentadillas().getRepsOptima() + ")" +
                        System.getProperty("line.separator");


        tvSalida.setText(salida);


    }

    public int setWeek1(View v) {
        week1.setBackground(view.getContext().getDrawable(R.drawable.buttons_week_selected));
        week2.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week3.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week4.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        semana = 1;
        Globals.semana = 1;
        return semana;
    }

    public int setWeek2(View v) {
        week2.setBackground(view.getContext().getDrawable(R.drawable.buttons_week_selected));
        week1.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week3.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week4.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        semana = 2;
        Globals.semana = 2;
        return semana;
    }

    public int setWeek3(View v) {
        week3.setBackground(view.getContext().getDrawable(R.drawable.buttons_week_selected));
        week2.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week1.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week4.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        semana = 3;
        Globals.semana = 3;
        return semana;
    }

    public int setWeek4(View v) {
        week4.setBackground(view.getContext().getDrawable(R.drawable.buttons_week_selected));
        week2.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week1.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week3.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        semana = 4;
        Globals.semana = 4;
        return semana;
    }


    public void setPersistencia() {

        wodGrabar = new com.example.boosterweigthlifting.persistence.models.Wod();
        wodGrabar.setDia(1);
        wodGrabar.setSemana(Globals.semana);
        wodGrabar.setIdUsuario(Globals.idUsuario);
        grabarWod(wodGrabar);


    }

    public void grabarWod(com.example.boosterweigthlifting.persistence.models.Wod wodGrabar) {

        /*
        Calendar calendario = Calendar.getInstance();
        Date time = calendario.getTime();
        int year = 0;
        int month = 0;
        int day = 0;
        year = time.getYear();
        month = time.getMonth();
        day = time.getDay();
        String fecha =
                year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
*/

        //WOD
        ApiAdapter apiAdapter = RetrofitClient.getClient().create(ApiAdapter.class);
        String jsonRawWod = "{\n" +
                "        \"idWod\": " + wodGrabar.getIdWod() + ",\n" +
                "        \"idUsuario\": " + wodGrabar.getIdUsuario() + ",\n" +
                "        \"comentario\": \"" + wodGrabar.getComentario() + "\",\n" +
                "        \"dia\": " + wodGrabar.getDia() + ",\n" +
                //  "        \"fecha\": \""+fecha+"\",\n" +
                "        \"semana\": " + wodGrabar.getSemana() + ",\n" +
                "        \"check\": " + wodGrabar.getCompleto() + "\n" +
                "    }";

        Call<com.example.boosterweigthlifting.persistence.models.Wod> call = apiAdapter.setWod(jsonRawWod);
        call.enqueue(new Callback<com.example.boosterweigthlifting.persistence.models.Wod>() {
            @Override
            public void onResponse(Call<com.example.boosterweigthlifting.persistence.models.Wod> call,
                                   Response<com.example.boosterweigthlifting.persistence.models.Wod> response) {
                String nuevo = view.getResources().getString(R.string.NewWodCreate);

                Toast.makeText(view.getContext(), nuevo + ": " +
                        response.body().getIdWod(), Toast.LENGTH_LONG).show();
                Globals.actualWod = response.body().getIdWod();

                guardarMovPrincipal();
                guardarPullPrincipal();
                guardarVarMovSecundario();
                guardarSentadillas();


                if (!response.isSuccessful()) {

                } else {
                    wodConId = response.body();

                }

            }

            @Override
            public void onFailure(Call<com.example.boosterweigthlifting.persistence.models.Wod> call, Throwable t) {
                Log.d("actualWodGrabar", "fallo");
            }
        });


    }

    public void guardarMovPrincipal() {

        ApiAdapter apiAdapter2 = RetrofitClient.getClient().create(ApiAdapter.class);
        String jsonRawWod2 = "{\n" +
                "        \"idWod\": " + Globals.actualWod + ",\n" +
                "        \"idUsuario\": " + Globals.idUsuario + ",\n" +
                "        \"nombre\": \"" + movPrincipal.getNombre() + "\",\n" +
                "        \"pesoMax\": " + movPrincipal.getPeso()[1] + ",\n" +
                "        \"pesoMin\": " + movPrincipal.getPeso()[0] + ",\n" +
                "        \"pocentajeMin\": " + movPrincipal.getPorcentaje()[0] + ",\n" +
                "        \"porcentajeMax\": " + movPrincipal.getPorcentaje()[1] + ",\n" +
                "        \"repsOptima\": " + movPrincipal.getRepsOptima() + ",\n" +
                "        \"serieMax\": " + movPrincipal.getRepsSerie()[1] + ",\n" +
                "        \"serieMin\": " + movPrincipal.getRepsSerie()[0] + ",\n" +
                "        \"repsTotalMax\": " + movPrincipal.getRepsTotal()[1] + ",\n" +
                "        \"repsTotalMin\": " + movPrincipal.getRepsTotal()[0] + ",\n" +
                "        \"rm\": " + movPrincipal.getRm() + "\n" +
                "    }";

        Call<MovimientoPrincipal> call2 = apiAdapter2.setMovPrincipal(jsonRawWod2);
        call2.enqueue(new Callback<MovimientoPrincipal>() {
            @Override
            public void onResponse(Call<MovimientoPrincipal> call, Response<MovimientoPrincipal> response) {

            }

            @Override
            public void onFailure(Call<MovimientoPrincipal> call, Throwable t) {

            }
        });


    }

    public void guardarPullPrincipal() {

        ApiAdapter apiAdapter3 = RetrofitClient.getClient().create(ApiAdapter.class);
        String jsonRawWod3 = "{\n" +
                "        \"idWod\": " + Globals.actualWod + ",\n" +
                "        \"idUsuario\": " + Globals.idUsuario + ",\n" +
                "        \"nombre\": \"" + movSecPrincipal.getNombre() + "\",\n" +
                "        \"pesoMax\": " + movSecPrincipal.getPeso()[1] + ",\n" +
                "        \"pesoMin\": " + movSecPrincipal.getPeso()[0] + ",\n" +
                "        \"pocentajeMin\": " + movSecPrincipal.getPorcentaje()[0] + ",\n" +
                "        \"porcentajeMax\": " + movSecPrincipal.getPorcentaje()[1] + ",\n" +
                "        \"repsOptima\": " + movSecPrincipal.getRepsOptima() + ",\n" +
                "        \"serieMax\": " + movSecPrincipal.getRepsSerie()[1] + ",\n" +
                "        \"serieMin\": " + movSecPrincipal.getRepsSerie()[0] + ",\n" +
                "        \"repsTotalMax\": " + movSecPrincipal.getRepsTotal()[1] + ",\n" +
                "        \"repsTotalMin\": " + movSecPrincipal.getRepsTotal()[0] + ",\n" +
                "        \"rm\": " + movSecPrincipal.getRm() + "\n" +
                "    }";

        Call<PullMovimientoPrincipal> call3 = apiAdapter3.setPullMovPrincipal(jsonRawWod3);
        call3.enqueue(new Callback<PullMovimientoPrincipal>() {
            @Override
            public void onResponse(Call<PullMovimientoPrincipal> call3, Response<PullMovimientoPrincipal> response) {

            }

            @Override
            public void onFailure(Call<PullMovimientoPrincipal> call3, Throwable t) {

            }
        });
    }

    public void guardarVarMovSecundario() {

        ApiAdapter apiAdapter4 = RetrofitClient.getClient().create(ApiAdapter.class);
        String jsonRawWod4 = "{\n" +
                "        \"idWod\": " + Globals.actualWod + ",\n" +
                "        \"idUsuario\": " + Globals.idUsuario + ",\n" +
                "        \"nombre\": \"" + movVariante.getNombre() + "\",\n" +
                "        \"pesoMax\": " + movVariante.getPeso()[1] + ",\n" +
                "        \"pesoMin\": " + movVariante.getPeso()[0] + ",\n" +
                "        \"pocentajeMin\": " + movVariante.getPorcentaje()[0] + ",\n" +
                "        \"porcentajeMax\": " + movVariante.getPorcentaje()[1] + ",\n" +
                "        \"repsOptima\": " + movVariante.getRepsOptima() + ",\n" +
                "        \"serieMax\": " + movVariante.getRepsSerie()[1] + ",\n" +
                "        \"serieMin\": " + movVariante.getRepsSerie()[0] + ",\n" +
                "        \"repsTotalMax\": " + movVariante.getRepsTotal()[1] + ",\n" +
                "        \"repsTotalMin\": " + movVariante.getRepsTotal()[0] + ",\n" +
                "        \"rm\": " + movVariante.getRm() + "\n" +
                "    }";

        Call<VarMovimientoSecundario> call4 = apiAdapter4.setVarSecundario(jsonRawWod4);
        call4.enqueue(new Callback<VarMovimientoSecundario>() {
            @Override
            public void onResponse(Call<VarMovimientoSecundario> call4, Response<VarMovimientoSecundario> response) {

            }

            @Override
            public void onFailure(Call<VarMovimientoSecundario> call4, Throwable t) {

            }
        });

    }

    public void guardarSentadillas() {

        ApiAdapter apiAdapter5 = RetrofitClient.getClient().create(ApiAdapter.class);
        String jsonRawWod5 = "{\n" +
                "        \"idWod\": " + Globals.actualWod + ",\n" +
                "        \"idUsuario\": " + Globals.idUsuario + ",\n" +
                "        \"nombre\": \"" + sentadillas.getNombre() + "\",\n" +
                "        \"pesoMax\": " + sentadillas.getPeso()[1] + ",\n" +
                "        \"pesoMin\": " + sentadillas.getPeso()[0] + ",\n" +
                "        \"pocentajeMin\": " + sentadillas.getPorcentaje()[0] + ",\n" +
                "        \"porcentajeMax\": " + sentadillas.getPorcentaje()[1] + ",\n" +
                "        \"repsOptima\": " + sentadillas.getRepsOptima() + ",\n" +
                "        \"serieMax\": " + sentadillas.getRepsSerie()[1] + ",\n" +
                "        \"serieMin\": " + sentadillas.getRepsSerie()[0] + ",\n" +
                "        \"repsTotalMax\": " + sentadillas.getRepsTotal()[1] + ",\n" +
                "        \"repsTotalMin\": " + sentadillas.getRepsTotal()[0] + ",\n" +
                "        \"rm\": " + sentadillas.getRm() + "\n" +
                "    }";

        Call<Squat> call5 = apiAdapter5.setSentadillaas(jsonRawWod5);
        call5.enqueue(new Callback<Squat>() {
            @Override
            public void onResponse(Call<Squat> call5, Response<Squat> response) {

            }

            @Override
            public void onFailure(Call<Squat> call5, Throwable t) {

            }
        });

    }
}


