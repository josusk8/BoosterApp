package com.example.boosterweigthlifting;

import java.util.ArrayList;
import java.util.Date;

public class Persistencia {

    private ArrayList<Wod> wods;
    private ArrayList<Rm> rms;

    public Persistencia() {

        if(wods == null){
            rellenarAuto();
        }
    }

    public ArrayList<Rm> getRms() {
        return rms;
    }

    public void setRms(ArrayList<Rm> rms) {
        this.rms = rms;
    }

    public ArrayList<Wod> getWods() {
        return wods;
    }

    public void setWods(ArrayList<Wod> wods) {
        this.wods = wods;
    }

    public void rellenarAuto() {
        rellenarWODs();
        rellenarRMs();
    }

    public void rellenarWODs(){


        wods = new ArrayList<Wod>();

        Ejercicio movPrincipal = new Ejercicio("Snatch", 85);
        Ejercicio pullMovPrincipal = new Ejercicio("Snatch Pull", 85);
        Ejercicio varMovSecundario = new Ejercicio("Hang Power Snatch", 85);
        Ejercicio sentadillas = new Ejercicio("Back Squat", 150);

        Wod wod = new Wod(movPrincipal, pullMovPrincipal, varMovSecundario,
                sentadillas);
        wod.makeWod(1, 0);
        wods.add(wod);


        movPrincipal = new Ejercicio("Clean Jerk", 110);
        pullMovPrincipal = new Ejercicio("Clean Pull", 110);
        varMovSecundario = new Ejercicio("Hang Squat Clean", 110);
        sentadillas = new Ejercicio("Front Squat", 140);
        wod = new Wod(movPrincipal, pullMovPrincipal, varMovSecundario,
                sentadillas);
        wod.makeWod(2, 0);
        wod.setChek(true);
        wod.setComentario("La sentadilla no puede completarla.\nDolor en lumbar");
        wods.add(wod);


        movPrincipal = new Ejercicio("Clean +2 Jerk", 110);
        pullMovPrincipal = new Ejercicio("Clean Deadlift", 110);
        varMovSecundario = new Ejercicio("Push Jerk", 110);
        sentadillas = new Ejercicio("Pause Back Squat", 140);
        wod = new Wod(movPrincipal, pullMovPrincipal, varMovSecundario,
                sentadillas);
        wod.makeWod(3, 0);
        wods.add(wod);
    }

    public void rellenarRMs(){

        rms = new ArrayList<Rm>();

        Ejercicio snatch = new Ejercicio("Snatch");
        Ejercicio clean = new Ejercicio("Clean & Jerk");
        Ejercicio squat = new Ejercicio("Back Squat");

        Date fecha1 = new Date(1616584068000l);
        Date fecha2 = new Date(1637752068000l);
        Date fecha3 = new Date(1645700868000l);
        Date fecha4 = new Date(1642251892000l);
        Date fecha5 = new Date(1642770292000l);
        Date fecha6 = new Date(1648127092000l);

        rms.add(new Rm(snatch, 85f, fecha3));
        rms.add(new Rm(snatch, 75f, fecha2));
        rms.add(new Rm(snatch, 70f, fecha1));


        rms.add(new Rm(clean, 135f, fecha6));
        rms.add(new Rm(clean, 120f, fecha5));
        rms.add(new Rm(clean, 102f, fecha4));
        rms.add(new Rm(clean, 100f, fecha3));
        rms.add(new Rm(clean, 85f, fecha2));
        rms.add(new Rm(clean, 80f, fecha1));



        rms.add(new Rm(squat, 155f, fecha6));
        rms.add(new Rm(squat, 150f, fecha5));
        rms.add(new Rm(squat, 145f, fecha3));
        rms.add(new Rm(squat, 140f, fecha2));
        rms.add(new Rm(squat, 130f, fecha1));


    }
}
