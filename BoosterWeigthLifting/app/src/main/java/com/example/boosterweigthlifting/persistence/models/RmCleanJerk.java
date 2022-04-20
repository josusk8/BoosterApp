package com.example.boosterweigthlifting.persistence.models;

public class RmCleanJerk {

    private int idRmCleanJerk;
    private String fecha;
    private float peso;
    private int idUsuario;

    public RmCleanJerk() {
    }

    public int getIdRmCleanJerk() {
        return idRmCleanJerk;
    }

    public void setIdRmCleanJerk(int idRmCleanJerk) {
        this.idRmCleanJerk = idRmCleanJerk;
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
