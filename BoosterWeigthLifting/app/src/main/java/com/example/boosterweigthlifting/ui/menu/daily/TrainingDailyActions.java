package com.example.boosterweigthlifting.ui.menu.daily;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.boosterweigthlifting.Ejercicio;
import com.example.boosterweigthlifting.Persistencia;
import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.Wod;

import java.util.ArrayList;

public class TrainingDailyActions {
    View view;
    Persistencia persistencia;
    ArrayList<Wod> wods;
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

        persistencia = new Persistencia();
        wods = persistencia.getWods();


    }

    public void mostrarPrimero() {



        if (wods.size() > 1) {

            Wod wod = wods.get(0);
            position = 0;
            rellenarCampos(wod);

        }

    }

    public void mostrarSiguiente() {

        grabar();


        if (wods.size() > (position + 1)) {
            position++;
            Wod wod = wods.get(position);
            rellenarCampos(wod);

        }else{
            position = 0;
            Wod wod = wods.get(position);
            rellenarCampos(wod);

        }
    }

    public void mostrarAtras() {

        grabar();

        if (position == 0) {
            position = wods.size()-1;
            Wod wod = wods.get(position);
            rellenarCampos(wod);

        } else {
            position--;
            Wod wod = wods.get(position);
            rellenarCampos(wod);

        }

    }

    public void rellenarCampos(Wod wod){

        Ejercicio movPrincipal = wod.getMovPrincipal();
        Ejercicio varMovSecundario = wod.getVarMovSecundario();
        Ejercicio pullMovPrincipal = wod.getPullMovPrincipal();
        Ejercicio sentadillas = wod.getSentadillas();

        tvTittle.setText("WOD " + wod.getSemana() + " - " + wod.getDia() + 1 );
        tvFirstMov.setText(movPrincipal.getNombre());
        tvFirstMovKg.setText("" + movPrincipal.getPeso()[0] + " - " + movPrincipal.getPeso()[1]+"kg");
        tvFirstMovSeries.setText("" + movPrincipal.getRepsSerie()[0] + " - " + movPrincipal.getRepsSerie()[1]+" serie");
        tvFirstMovReps.setText("" + movPrincipal.getRepsTotal()[0] + " - "
                + movPrincipal.getRepsTotal()[1]+ " ("+movPrincipal.getRepsOptima()+") rep");

        tvPullFirtsMov.setText(pullMovPrincipal.getNombre());
        tvPullFirstMovKg.setText("" + pullMovPrincipal.getPeso()[0] + " - " + pullMovPrincipal.getPeso()[1]+"kg");
        tvPullFirstMovSeries.setText("" + pullMovPrincipal.getRepsSerie()[0] + " - " + pullMovPrincipal.getRepsSerie()[1]+" serie");
        tvPullFirstMovReps.setText("" + pullMovPrincipal.getRepsTotal()[0] + " - "
                + pullMovPrincipal.getRepsTotal()[1]+ " ("+pullMovPrincipal.getRepsOptima()+") rep");

        tvVariantSecMov.setText(varMovSecundario.getNombre());
        tvVariantSecMovKg.setText("" + varMovSecundario.getPeso()[0] + " - " + varMovSecundario.getPeso()[1]+"kg");
        tvVariantSecMovSeries.setText("" + varMovSecundario.getRepsSerie()[0] + " - " + varMovSecundario.getRepsSerie()[1]+" serie");
        tvVariantSecMovReps.setText("" + varMovSecundario.getRepsTotal()[0] + " - "
                + varMovSecundario.getRepsTotal()[1]+ " ("+varMovSecundario.getRepsOptima()+") rep");

        tvSquats.setText(sentadillas.getNombre());
        tvSquatsKg.setText("" + sentadillas.getPeso()[0] + " - " + sentadillas.getPeso()[1]+"kg");
        tvSquatsSeries.setText("" + sentadillas.getRepsSerie()[0] + " - " + sentadillas.getRepsSerie()[1]+" serie");
        tvSquatsReps.setText("" + sentadillas.getRepsTotal()[0] + " - "
                + sentadillas.getRepsTotal()[1]+ " ("+sentadillas.getRepsOptima()+") rep");


        checkBox.setChecked(wod.isChek());
        tvComent.setText (wod.getComentario());

    }

    public void grabar(){

        wods.get(position).setComentario(tvComent.getText().toString());
        wods.get(position).setChek(checkBox.isChecked());
        persistencia.setWods(wods);

    }
}
