package com.example.boosterweigthlifting;

import java.util.Date;

public class Rm {
    private Ejercicio ejercicio;
    private Float peso;
    private Date fecha;

    public Rm(Ejercicio ejercicio, Float peso, Date fecha) {
        this.ejercicio = ejercicio;
        this.peso = peso;
        this.fecha = fecha;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
