package com.example.boosterweigthlifting.persistence.models;

public class RmSquat {

    private int idRmSquat;
    private String fecha;
    private float peso;
    private int idUsuario;

    public RmSquat() {
    }

    public int getIdRmSquat() {
        return idRmSquat;
    }

    public void setIdRmSquat(int idRmSquat) {
        this.idRmSquat = idRmSquat;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
