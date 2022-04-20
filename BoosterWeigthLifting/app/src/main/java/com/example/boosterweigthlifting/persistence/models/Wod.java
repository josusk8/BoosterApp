package com.example.boosterweigthlifting.persistence.models;


public class Wod {

    private int idWod;
    private int dia;
    private String fecha;
    private int semana;

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
