package com.example.boosterweigthlifting.ui.menu.training;


import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.boosterweigthlifting.Ejercicio;
import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.Wod;
import com.example.boosterweigthlifting.persistence.utils.Globals;

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
        semana=0;
    }
    public void setTraining(int semana, int dia) {



        Ejercicio movPrincipal = new Ejercicio(actv1.getText().toString(), Globals.lastRmSnatch);
        Ejercicio movSecPrincipal = new Ejercicio(actv2.getText().toString(), Globals.lastRmSnatch);
        Ejercicio movVariante = new Ejercicio(actv3.getText().toString(), Globals.lastRmSnatch);
        Ejercicio sentadillas = new Ejercicio(actv4.getText().toString(), Globals.lastRmSquat);

        Wod wod = new Wod(movPrincipal, movSecPrincipal, movVariante, sentadillas);
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
        return semana;
    }
    public int setWeek2(View v) {
        week2.setBackground(view.getContext().getDrawable(R.drawable.buttons_week_selected));
        week1.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week3.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week4.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        semana = 2;
        return semana;
    }
    public int setWeek3(View v) {
        week3.setBackground(view.getContext().getDrawable(R.drawable.buttons_week_selected));
        week2.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week1.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week4.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        semana = 3;
        return semana;
    }
    public int setWeek4(View v) {
        week4.setBackground(view.getContext().getDrawable(R.drawable.buttons_week_selected));
        week2.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week1.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        week3.setBackground(view.getContext().getDrawable(R.drawable.buttons_week));
        semana = 4;
        return semana;
    }

}


