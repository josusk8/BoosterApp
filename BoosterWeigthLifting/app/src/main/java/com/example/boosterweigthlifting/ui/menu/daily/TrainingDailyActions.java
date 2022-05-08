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
import com.example.boosterweigthlifting.persistence.utils.Globals;
import com.example.boosterweigthlifting.persistence.utils.RetrofitClient;

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
    int  idWod = 0;
    Wod actualWod;

    TextView tvTittle;
    TextView tvFirstMov, tvFirstMovKg, tvFirstMovSeries, tvFirstMovReps;
    TextView tvPullFirtsMov, tvPullFirstMovKg, tvPullFirstMovSeries, tvPullFirstMovReps;
    TextView tvVariantSecMov, tvVariantSecMovKg, tvVariantSecMovSeries, tvVariantSecMovReps;
    TextView tvSquats, tvSquatsKg, tvSquatsSeries, tvSquatsReps;
    TextView tvComent;
    CheckBox checkBox;


    public TrainingDailyActions(View view) {
        this.view = view;

        actualWod = new Wod();
        wods = new ArrayList<Wod>();
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

        //Arreglar la persistencia en el checkbox y el comentario
        tvComent.setEnabled(false);
        checkBox.setEnabled(false);

    }

    public void mostrarPrimero() {

        if (wods.size() >= 1) {
            Wod wod = wods.get(0);
            position = 1;
            rellenarCampos(wod);

        }

    }

    public void mostrarSiguiente() {

        if (wods.size() == 0) {

        } else {

            if (wods.size() > (position)) {
                position++;
                Wod wod = wods.get(position - 1);
                rellenarCampos(wod);
                //grabar(wod);


            } else {
                position = 0;
                Wod wod = wods.get(position);
                rellenarCampos(wod);
                //grabar(wod);


            }

        }


    }

    public void mostrarAtras() {

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
               // grabar(wod);
            }

        }


    }

    public void rellenarCampos(Wod wod) {

        actualWod = wod;

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
        tvVariantSecMovKg.setText("" + varMovSecundario.getPesoMin() + " - " + varMovSecundario.getPesoMax() + "kg");
        tvVariantSecMovSeries.setText("" + varMovSecundario.getSerieMin() + " - " + varMovSecundario.getSerieMax() + " serie");
        tvVariantSecMovReps.setText("" + varMovSecundario.getRepsTotalMin() + " - "
                + varMovSecundario.getRepsTotalMax() + " (" + varMovSecundario.getRepsOptima() + ") rep");

        tvSquats.setText(sentadillas.getNombre());
        tvSquatsKg.setText("" + sentadillas.getPesoMin() + " - " + sentadillas.getPesoMax() + "kg");
        tvSquatsSeries.setText("" + sentadillas.getSerieMin() + " - " + sentadillas.getSerieMax() + " serie");
        tvSquatsReps.setText("" + sentadillas.getRepsTotalMin() + " - "
                + sentadillas.getRepsTotalMax() + " (" + sentadillas.getRepsOptima() + ") rep");

        if (wod.getCompleto() == 1) {
            checkBox.setChecked(true);
        }else{
            checkBox.setChecked(false);
        }

         tvComent.setText(wod.getComentario());

    }

    public void grabar(Wod wod) {

        actualWod.setComentario(tvComent.getText().toString());
        if(checkBox.isChecked()){
            actualWod.setCompleto(1);
        }else{
            actualWod.setCompleto(0);
        }


        ApiAdapter apiAdapter = RetrofitClient.getClient().create(ApiAdapter.class);

        String jsonRawWod = "{\n" +
                "        \"idWod\": "+actualWod.getIdWod()+",\n" +
                "        \"idUsuario\": "+actualWod.getIdUsuario()+",\n" +
                "        \"comentario\": \""+actualWod.getComentario()+"\",\n" +
                "        \"dia\": "+actualWod.getDia()+",\n" +
                "        \"fecha\": \"2022"+actualWod.getFecha().toString()+"-04-08\",\n" +
                "        \"semana\": "+actualWod.getSemana()+",\n" +
                "        \"check\": "+actualWod.getCompleto()+"\n" +
                "    }";

        Call<Wod> call = apiAdapter.setWod(jsonRawWod);
        call.enqueue(new Callback<Wod> () {
            @Override
            public void onResponse(Call<Wod>  call, Response<Wod>  response) {

                if(!response.isSuccessful()){

                }else{
                    /*Wod body = response.body();
                    actualWod = body;*/
                }

            }

            @Override
            public void onFailure(Call<Wod>  call, Throwable t) {
                Log.d("actualWodGrabar", "fallo");
            }
        });


    }

    public void getWods() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Globals.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiAdapter apiAdapter = retrofit.create(ApiAdapter.class);

        Call<ArrayList<Wod>> call = apiAdapter.getWodByIdUser(Globals.idUsuario);

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

    public void rellenarWods() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Globals.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiAdapter apiAdapter = retrofit.create(ApiAdapter.class);

        for (Wod wod : wods) {
            int idWod = wod.getIdWod();

            Call<ArrayList<MovimientoPrincipal>> call = apiAdapter.getMovimientoPrincipalByIdWod(idWod);
            call.enqueue(new Callback<ArrayList<MovimientoPrincipal>>() {
                @Override
                public void onResponse(Call<ArrayList<MovimientoPrincipal>> call, Response<ArrayList<MovimientoPrincipal>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }

                    try {
                        ArrayList<MovimientoPrincipal> objectList = response.body();
                        wod.setMovimientoPrincipal(objectList.get(0));
                    } catch (Exception e) {
                        Log.e("Exception: ", e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<MovimientoPrincipal>> call, Throwable t) {

                }
            });


            Call<ArrayList<PullMovimientoPrincipal>> call2 = apiAdapter.getPullMovimientoPrincipalByIdWod(idWod);
            call2.enqueue(new Callback<ArrayList<PullMovimientoPrincipal>>() {
                @Override
                public void onResponse(Call<ArrayList<PullMovimientoPrincipal>> call, Response<ArrayList<PullMovimientoPrincipal>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }

                    try {
                        ArrayList<PullMovimientoPrincipal> objectList = response.body();
                        wod.setPullMovimientoPrincipal(objectList.get(0));
                    } catch (Exception e) {
                        Log.e("Exception: ", e.getMessage());
                    }

                }

                @Override
                public void onFailure(Call<ArrayList<PullMovimientoPrincipal>> call, Throwable t) {

                }
            });

            Call<ArrayList<VarMovimientoSecundario>> call3 = apiAdapter.getVarMovimientoSecundarioByIdWod(idWod);
            call3.enqueue(new Callback<ArrayList<VarMovimientoSecundario>>() {
                @Override
                public void onResponse(Call<ArrayList<VarMovimientoSecundario>> call, Response<ArrayList<VarMovimientoSecundario>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }

                    try {
                        ArrayList<VarMovimientoSecundario> objectList = response.body();
                        wod.setVarMovimientoSecundario(objectList.get(0));
                    } catch (Exception e) {
                        Log.e("Exception: ", e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<VarMovimientoSecundario>> call, Throwable t) {

                }
            });

            Call<ArrayList<Squat>> call4 = apiAdapter.getSquatByIdWod(idWod);
            call4.enqueue(new Callback<ArrayList<Squat>>() {
                @Override
                public void onResponse(Call<ArrayList<Squat>> call, Response<ArrayList<Squat>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    try {
                        ArrayList<Squat> objectList = response.body();
                        wod.setSquat(objectList.get(0));
                    } catch (Exception e) {
                        Log.e("Exception: ", e.getMessage());
                    }

                    mostrarPrimero();

                }

                @Override
                public void onFailure(Call<ArrayList<Squat>> call, Throwable t) {

                }
            });


        }

    }
}
