package com.example.boosterweigthlifting.persistence.models;


public class Wod {


    private int idWod;
    private int dia;
    private String fecha;
    private String comentario = "";
    private int semana;
    private int idUsuario;
    private int check = 0;

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

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
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
