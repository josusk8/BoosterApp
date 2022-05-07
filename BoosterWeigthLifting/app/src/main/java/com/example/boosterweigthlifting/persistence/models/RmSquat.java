package com.example.boosterweigthlifting.persistence.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RmSquat {

    @SerializedName("idRmSquat")
    @Expose
    private int idRmSquat;

    @SerializedName("fecha")
    @Expose
    private String fecha;

    @SerializedName("peso")
    @Expose
    private float peso;

    @SerializedName("idUsuario")
    @Expose
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
