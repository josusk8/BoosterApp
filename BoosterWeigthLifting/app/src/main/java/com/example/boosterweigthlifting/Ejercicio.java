package com.example.boosterweigthlifting;

public class Ejercicio {

    private String nombre;
    private float rm;
    private float[] peso = new float[2];
    int[] porcentaje = new int[2];
    int[] repsSerie = new int[2];
    int[] repsTotal = new int[2];
    int repsOptima;

    public Ejercicio() {
    }

    public Ejercicio(String nombre) {
        this.nombre = nombre;
    }

    public Ejercicio(String nombre, float rm) {
        this.nombre = nombre;
        this.rm = rm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getRm() {
        return rm;
    }

    public void setRm(float rm) {
        this.rm = rm;
    }

    public float[] getPeso() {
        return peso;
    }

    public void setPeso(float[] peso) {
        this.peso = peso;
    }

    public int[] getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int[] porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int[] getRepsSerie() {
        return repsSerie;
    }

    public void setRepsSerie(int[] repsSerie) {
        this.repsSerie = repsSerie;
    }

    public int[] getRepsTotal() {
        return repsTotal;
    }

    public void setRepsTotal(int[] repsTotal) {
        this.repsTotal = repsTotal;
    }

    public int getRepsOptima() {
        return repsOptima;
    }

    public void setRepsOptima(int repsOptima) {
        this.repsOptima = repsOptima;
    }
}
