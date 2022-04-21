package com.example.boosterweigthlifting.persistence.models;

public class WodDao {

    private int idWod;
    private int dia;
    private String fecha;
    private String comentario = "";
    private int semana;
    private int idUsuario;

    public WodDao() {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdWod() {
        return idWod;
    }

    public void setIdWod(int idWod) {
        this.idWod = idWod;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
