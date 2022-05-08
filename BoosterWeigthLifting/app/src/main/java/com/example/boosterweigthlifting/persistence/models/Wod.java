package com.example.boosterweigthlifting.persistence.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wod {

    @SerializedName("idWod")
    @Expose
    private int idWod;

    @SerializedName("dia")
    @Expose
    private int dia;

    @SerializedName("fecha")
    @Expose
    private String fecha;

    @SerializedName("comentario")
    @Expose
    private String comentario = "";

    @SerializedName("semana")
    @Expose
    private int semana;

    @SerializedName("idUsuario")
    @Expose
    private int idUsuario;

    @SerializedName("completo")
    @Expose
    private int completo = 0;

    private MovimientoPrincipal movimientoPrincipal;
    private PullMovimientoPrincipal pullMovimientoPrincipal;
    private VarMovimientoSecundario varMovimientoSecundario;
    private Squat squat;

    public Wod(){

        movimientoPrincipal = new MovimientoPrincipal();
        pullMovimientoPrincipal  = new PullMovimientoPrincipal();
        varMovimientoSecundario = new VarMovimientoSecundario();
        squat = new Squat();
    }


    public int getIdWod() {
        return idWod;
    }

    public void setIdWod(int idWod) {
        this.idWod = idWod;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCompleto() {
        return completo;
    }

    public void setCompleto(int completo) {
        this.completo = completo;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public MovimientoPrincipal getMovimientoPrincipal() {
        return movimientoPrincipal;
    }

    public void setMovimientoPrincipal(MovimientoPrincipal movimientoPrincipal) {
        this.movimientoPrincipal = movimientoPrincipal;
    }

    public PullMovimientoPrincipal getPullMovimientoPrincipal() {
        return pullMovimientoPrincipal;
    }

    public void setPullMovimientoPrincipal(PullMovimientoPrincipal pullMovimientoPrincipal) {
        this.pullMovimientoPrincipal = pullMovimientoPrincipal;
    }

    public VarMovimientoSecundario getVarMovimientoSecundario() {
        return varMovimientoSecundario;
    }

    public void setVarMovimientoSecundario(VarMovimientoSecundario varMovimientoSecundario) {
        this.varMovimientoSecundario = varMovimientoSecundario;
    }

    public Squat getSquat() {
        return squat;
    }

    public void setSquat(Squat squat) {
        this.squat = squat;
    }
}
