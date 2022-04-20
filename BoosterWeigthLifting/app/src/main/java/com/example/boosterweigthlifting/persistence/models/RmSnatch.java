package com.example.boosterweigthlifting.persistence.models;

public class RmSnatch {

    private int idRmSnatch;
    private String fecha;
    private float peso;
    private int idUsuario;

    public RmSnatch() {
    }

    public int getIdRmSnatch() {
        return idRmSnatch;
    }

    public void setIdRmSnatch(int idRmSnatch) {
        this.idRmSnatch = idRmSnatch;
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
