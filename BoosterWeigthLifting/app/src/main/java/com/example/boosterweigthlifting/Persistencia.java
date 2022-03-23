package com.example.boosterweigthlifting;

import android.util.Log;

import java.util.ArrayList;

public class Persistencia {

    private ArrayList<Wod> wods;

    public Persistencia() {
        rellenarAuto();
    }

    public ArrayList<Wod> getWods() {
        return wods;
    }

    public void setWods(ArrayList<Wod> wods) {
        this.wods = wods;
    }

    public void rellenarAuto() {

        wods = new ArrayList<Wod>();


        Ejercicio movPrincipal = new Ejercicio("Snatch", 85);
        Ejercicio pullMovPrincipal = new Ejercicio("Snatch Pull", 85);
        Ejercicio varMovSecundario = new Ejercicio("Hang Power Snatch", 85);
        Ejercicio sentadillas = new Ejercicio("Back Squat", 150);

        Wod wod = new Wod(movPrincipal, pullMovPrincipal, varMovSecundario,
                sentadillas);
        wod.makeWod(3, 0);
        wods.add(wod);
        Log.e("Relleno", "" + wods.get(0).getMovPrincipal().getNombre());

        movPrincipal = new Ejercicio("Clean Jerk", 110);
        pullMovPrincipal = new Ejercicio("Clean Pull", 110);
        varMovSecundario = new Ejercicio("Hang Squat Clean", 110);
        sentadillas = new Ejercicio("Front Squat", 140);
        wod = new Wod(movPrincipal, pullMovPrincipal, varMovSecundario,
                sentadillas);
        wod.makeWod(2, 0);
        wods.add(wod);
        Log.e("Relleno", "" + wods.get(1).getMovPrincipal().getNombre());

        movPrincipal = new Ejercicio("Clean +2 Jerk", 110);
        pullMovPrincipal = new Ejercicio("Clean Deadlift", 110);
        varMovSecundario = new Ejercicio("Push Jerk", 110);
        sentadillas = new Ejercicio("Pause Back Squat", 140);
        wod = new Wod(movPrincipal, pullMovPrincipal, varMovSecundario,
                sentadillas);
        wod.makeWod(1, 0);
        wods.add(wod);
        Log.e("Relleno", "" + wods.get(2).getMovPrincipal().getNombre());
        Log.e("Relleno", "OK");


    }
}
