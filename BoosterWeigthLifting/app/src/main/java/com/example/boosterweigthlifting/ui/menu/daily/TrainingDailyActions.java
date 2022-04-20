package com.example.boosterweigthlifting.ui.menu.daily;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.persistence.interfaces.ApiAdapter;
import com.example.boosterweigthlifting.persistence.models.MovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.PullMovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.Squat;
import com.example.boosterweigthlifting.persistence.models.VarMovimientoSecundario;
import com.example.boosterweigthlifting.persistence.models.Wod;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrainingDailyActions {
    View view;

    ArrayList<Wod> wods = new ArrayList<>();
    int position;
    TextView tvTittle;
    TextView tvFirstMov, tvFirstMovKg, tvFirstMovSeries, tvFirstMovReps;
    TextView tvPullFirtsMov, tvPullFirstMovKg, tvPullFirstMovSeries, tvPullFirstMovReps;
    TextView tvVariantSecMov, tvVariantSecMovKg, tvVariantSecMovSeries, tvVariantSecMovReps;
    TextView tvSquats, tvSquatsKg, tvSquatsSeries, tvSquatsReps;
    TextView tvComent;
    CheckBox checkBox;


    public TrainingDailyActions(View view) {
        this.view = view;

        wods = new ArrayList<Wod>(0);
        getWods();

        tvTittle = (TextView) view.findViewById(R.id.tvTittle);

        tvFirstMov = (TextView) view.findViewById(R.id.tvFirstMov);
        tvFirstMovKg = (TextView) view.findViewById(R.id.tvFirstMovKg);
        tvFirstMovSeries = (TextView) view.findViewById(R.id.tvFirstMovSeries);
        tvFirstMovReps = (TextView) view.findViewById(R.id.tvFirstMovReps);

        tvPullFirtsMov = (TextView) view.findViewById(R.id.tvPullFirstMov);
        tvPullFirstMovKg = (TextView) view.findViewById(R.id.tvPullFirstMovKg);
        tvPullFirstMovSeries = (TextView) view.findViewById(R.id.tvPullFirstMovSeries);
        tvPullFirstMovReps = (TextView) view.findViewById(R.id.tvPullFirstMovReps);

        tvVariantSecMov = (TextView) view.findViewById(R.id.tvVariantSecMov);
        tvVariantSecMovKg = (TextView) view.findViewById(R.id.tvVariantSecMovKg);
        tvVariantSecMovSeries = (TextView) view.findViewById(R.id.tvVariantSecMovSeries);
        tvVariantSecMovReps = (TextView) view.findViewById(R.id.tvVariantSecMovReps);

        tvSquats = (TextView) view.findViewById(R.id.tvSquats);
        tvSquatsKg = (TextView) view.findViewById(R.id.tvSquatsKg);
        tvSquatsSeries = (TextView) view.findViewById(R.id.tvSquatsSeries);
        tvSquatsReps = (TextView) view.findViewById(R.id.tvSquatsReps);

        tvComent = (TextView) view.findViewById(R.id.tvComment);
        checkBox = (CheckBox) view.findViewById(R.id.checkBox);


    }

    public void mostrarPrimero() {

        Log.d("mostrar", "tamaño " + wods.size());
        if (wods.size() >= 1) {
            Wod wod = wods.get(0);
            position = 1;
            rellenarCampos(wod);
            Log.d("mostrar", wod.getIdWod() + "");

        }

    }

    public void mostrarSiguiente() {

        grabar();

        Log.d("mostrarS", "tamaño " + wods.size());

        if (wods.size() == 0) {

        } else {

            if (wods.size() > (position)) {
                position++;
                Wod wod = wods.get(position - 1);
                rellenarCampos(wod);
                Log.d("mostrarS", wod.getIdWod() + "");

            } else {
                position = 0;
                Wod wod = wods.get(position);
                rellenarCampos(wod);

            }

        }


    }

    public void mostrarAtras() {

        grabar();

        if (wods.size() == 0) {

        } else {

            if (position == 0) {
                position = wods.size() - 1;
                Wod wod = wods.get(position);
                rellenarCampos(wod);

            } else {
                position--;
                Wod wod = wods.get(position);
                rellenarCampos(wod);

            }

        }


    }

    public void rellenarCampos(Wod wod) {

        MovimientoPrincipal movPrincipal = wod.getMovimientoPrincipal();
        PullMovimientoPrincipal pullMovPrincipal = wod.getPullMovimientoPrincipal();
        VarMovimientoSecundario varMovSecundario = wod.getVarMovimientoSecundario();
        Squat sentadillas = wod.getSquat();


        tvTittle.setText("WOD " + wod.getSemana() + " - " + wod.getIdWod());
        tvFirstMov.setText(movPrincipal.getNombre());
        tvFirstMovKg.setText("" + movPrincipal.getPesoMin() + " - " + movPrincipal.getPesoMax() + "kg");
        tvFirstMovSeries.setText("" + movPrincipal.getSerieMin() + " - " + movPrincipal.getSerieMax() + " serie");
        tvFirstMovReps.setText("" + movPrincipal.getRepsTotalMin() + " - "
                + movPrincipal.getRepsTotalMax() + " (" + movPrincipal.getRepsOptima() + ") rep");

        tvPullFirtsMov.setText(pullMovPrincipal.getNombre());
        tvPullFirstMovKg.setText("" + pullMovPrincipal.getPesoMin() + " - " + pullMovPrincipal.getPesoMax() + "kg");
        tvPullFirstMovSeries.setText("" + pullMovPrincipal.getSerieMin() + " - " + pullMovPrincipal.getSerieMax() + " serie");
        tvPullFirstMovReps.setText("" + pullMovPrincipal.getRepsTotalMin() + " - "
                + pullMovPrincipal.getRepsTotalMax() + " (" + pullMovPrincipal.getRepsOptima() + ") rep");

        tvVariantSecMov.setText(varMovSecundario.getNombre());
        tvVariantSecMovKg.setText("" + varMovSecundario.getPesoMin() + " - " + varMovSecundario.getPesoMax()+ "kg");
        tvVariantSecMovSeries.setText("" + varMovSecundario.getSerieMin() + " - " + varMovSecundario.getSerieMax() + " serie");
        tvVariantSecMovReps.setText("" + varMovSecundario.getRepsTotalMin() + " - "
                + varMovSecundario.getRepsTotalMax() + " (" + varMovSecundario.getRepsOptima() + ") rep");

        tvSquats.setText(sentadillas.getNombre());
        tvSquatsKg.setText("" + sentadillas.getPesoMin() + " - " + sentadillas.getPesoMax() + "kg");
        tvSquatsSeries.setText("" + sentadillas.getSerieMin() + " - " + sentadillas.getSerieMax() + " serie");
        tvSquatsReps.setText("" + sentadillas.getRepsTotalMin() + " - "
                + sentadillas.getRepsTotalMax() + " (" + sentadillas.getRepsOptima() + ") rep");


        //  checkBox.setChecked(wod.isChek());
        //  tvComent.setText(wod.getComentario());

    }

    public void grabar() {

        // wods.get(position).setComentario(tvComent.getText().toString());
        //wods.get(position).setChek(checkBox.isChecked());
        //persistencia.setWods(wods);

    }

    public void getWods() {

        String url1 = "http://10.0.2.2:8080/booster/v1/";
        String url2 = "http://192.168.31.249:8080/booster/v1/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiAdapter apiAdapter = retrofit.create(ApiAdapter.class);

        Call<ArrayList<Wod>> call = apiAdapter.getByIdUser(1);

        call.enqueue(new Callback<ArrayList<Wod>>() {

            @Override
            public void onResponse(Call<ArrayList<Wod>> call, Response<ArrayList<Wod>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                ArrayList<Wod> objectList = response.body();

                wods = objectList;
                rellenarWods();

            }

            @Override
            public void onFailure(Call<ArrayList<com.example.boosterweigthlifting.persistence.models.Wod>> call, Throwable t) {
                Log.d("Estado", t.getMessage());
                Toast.makeText(view.getContext(), "Codigo: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }


        });

    }

    public void rellenarWods(){


        String url1 = "http://10.0.2.2:8080/booster/v1/";
        String url2 = "http://192.168.31.249:8080/booster/v1/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiAdapter apiAdapter = retrofit.create(ApiAdapter.class);

        for (Wod wod: wods) {
            int idWod = wod.getIdWod();


            Call<ArrayList<MovimientoPrincipal>> call = apiAdapter.getMovimientoPrincipalByIdWod(idWod);
            call.enqueue(new Callback<ArrayList<MovimientoPrincipal>>() {
                @Override
                public void onResponse(Call<ArrayList<MovimientoPrincipal>> call, Response<ArrayList<MovimientoPrincipal>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    ArrayList<MovimientoPrincipal> objectList = response.body();
                    wod.setMovimientoPrincipal(objectList.get(0));


                }

                @Override
                public void onFailure(Call<ArrayList<MovimientoPrincipal>> call, Throwable t) {

                }
            });

            




        }

    }
}
