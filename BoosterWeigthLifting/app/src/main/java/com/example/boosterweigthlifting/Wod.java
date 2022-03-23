package com.example.boosterweigthlifting;

import java.util.Date;

public class Wod {

    private PrilepinTabla prilepinTabla = new PrilepinTabla();
    int[][] tabla = prilepinTabla.getTabla();
    private Ejercicio movPrincipal;
    private Ejercicio pullMovPrincipal;
    private Ejercicio varMovSecundario;
    private Ejercicio sentadillas;
    private int semana;
    private int dia;
    private String comentario;
    private Date fecha;
    private boolean chek;



    public Wod(Ejercicio movPrincipal, Ejercicio pullMovPrincipal, Ejercicio varMovSecundario,
               Ejercicio sentadillas) {

        this.movPrincipal = movPrincipal;
        this.pullMovPrincipal = pullMovPrincipal;
        this.varMovSecundario = varMovSecundario;
        this.sentadillas = sentadillas;


    }

    public void makeWod(int semana, int dia) {

        this.semana = semana;
        this.dia = dia;

        switch (semana) {
            case 1:
                System.out.println("Case1");
                if (dia == 0) {
                    completarDesdeFila2();
                } else {
                    completarDesdeFila1();
                }
                break;

            case 2:
                if (dia == 0) {

                    completarDesdeFila3();
                } else {
                    completarDesdeFila2();
                }
                break;

            case 3:
                if (dia == 0) {
                    completarDesdeFila4();
                } else {
                    completarDesdeFila3();
                }
                break;

            case 4:
                if (dia == 0) {
                    completarDesdeFila1();
                } else {
                    completarDesdeFila4();
                }
                break;

        }

    }

    public Ejercicio usarFila1(Ejercicio mov) {

        int fila = 0;
        float[] peso = new float[2];
        peso[0] = (mov.getRm() * tabla[fila][0]) / 100;
        peso[1] = (mov.getRm() * tabla[fila][1]) / 100;
        mov.setPeso(peso);

        int[] porcentaje = new int[2];
        porcentaje[0] = tabla[fila][0];
        porcentaje[1] = tabla[fila][1];
        mov.setPorcentaje(porcentaje);

        int[] repsSerie = new int[2];
        repsSerie[0] = tabla[fila][2];
        repsSerie[1] = tabla[fila][3];
        mov.setRepsSerie(repsSerie);

        int[] repsTotal = new int[2];
        repsTotal[0] = tabla[fila][4];
        repsTotal[1] = tabla[fila][5];
        mov.setRepsTotal(repsTotal);

        mov.repsOptima = tabla[fila][6];
        return mov;

    }

    public Ejercicio usarFila2(Ejercicio mov) {
        int fila = 1;
        float[] peso = new float[2];
        peso[0] = (mov.getRm() * tabla[fila][0]) / 100;
        peso[1] = (mov.getRm() * tabla[fila][1]) / 100;
        mov.setPeso(peso);

        int[] porcentaje = new int[2];
        porcentaje[0] = tabla[fila][0];
        porcentaje[1] = tabla[fila][1];
        mov.setPorcentaje(porcentaje);

        int[] repsSerie = new int[2];
        repsSerie[0] = tabla[fila][2];
        repsSerie[1] = tabla[fila][3];
        mov.setRepsSerie(repsSerie);

        int[] repsTotal = new int[2];
        repsTotal[0] = tabla[fila][4];
        repsTotal[1] = tabla[fila][5];
        mov.setRepsTotal(repsTotal);

        mov.repsOptima = tabla[fila][6];
        return mov;

    }

    public Ejercicio usarFila3(Ejercicio mov) {

        int fila = 2;
        float[] peso = new float[2];
        peso[0] = (mov.getRm() * tabla[fila][0]) / 100;
        peso[1] = (mov.getRm() * tabla[fila][1]) / 100;
        mov.setPeso(peso);

        int[] porcentaje = new int[2];
        porcentaje[0] = tabla[fila][0];
        porcentaje[1] = tabla[fila][1];
        mov.setPorcentaje(porcentaje);

        int[] repsSerie = new int[2];
        repsSerie[0] = tabla[fila][2];
        repsSerie[1] = tabla[fila][3];
        mov.setRepsSerie(repsSerie);

        int[] repsTotal = new int[2];
        repsTotal[0] = tabla[fila][4];
        repsTotal[1] = tabla[fila][5];
        mov.setRepsTotal(repsTotal);

        mov.repsOptima = tabla[fila][6];
        return mov;


    }

    public Ejercicio usarFila4(Ejercicio mov) {

        int fila = 3;
        float[] peso = new float[2];
        peso[0] = (mov.getRm() * tabla[fila][0]) / 100;
        peso[1] = (mov.getRm() * tabla[fila][1]) / 100;
        mov.setPeso(peso);

        int[] porcentaje = new int[2];
        porcentaje[0] = tabla[fila][0];
        porcentaje[1] = tabla[fila][1];
        mov.setPorcentaje(porcentaje);

        int[] repsSerie = new int[2];
        repsSerie[0] = tabla[fila][2];
        repsSerie[1] = tabla[fila][3];
        mov.setRepsSerie(repsSerie);

        int[] repsTotal = new int[2];
        repsTotal[0] = tabla[fila][4];
        repsTotal[1] = tabla[fila][5];
        mov.setRepsTotal(repsTotal);

        mov.repsOptima = tabla[fila][6];
        return mov;

    }

    public void completarDesdeFila1() {

        movPrincipal = usarFila1(movPrincipal);
        pullMovPrincipal = usarFila2(pullMovPrincipal);
        varMovSecundario = usarFila3(varMovSecundario);
        sentadillas = usarFila4(sentadillas);
    }

    public void completarDesdeFila2() {
        movPrincipal = usarFila2(movPrincipal);
        pullMovPrincipal = usarFila3(pullMovPrincipal);
        varMovSecundario = usarFila4(varMovSecundario);
        sentadillas = usarFila1(sentadillas);
    }

    public void completarDesdeFila3() {
        movPrincipal = usarFila3(movPrincipal);
        pullMovPrincipal = usarFila4(pullMovPrincipal);
        varMovSecundario = usarFila1(varMovSecundario);
        sentadillas = usarFila2(sentadillas);
    }

    public void completarDesdeFila4() {
        movPrincipal = usarFila4(movPrincipal);
        pullMovPrincipal = usarFila1(pullMovPrincipal);
        varMovSecundario = usarFila2(varMovSecundario);
        sentadillas = usarFila3(sentadillas);
    }

    public Ejercicio getMovPrincipal() {
        return movPrincipal;
    }

    public void setMovPrincipal(Ejercicio movPrincipal) {
        this.movPrincipal = movPrincipal;
    }

    public Ejercicio getPullMovPrincipal() {
        return pullMovPrincipal;
    }

    public void setPullMovPrincipal(Ejercicio pullMovPrincipal) {
        this.pullMovPrincipal = pullMovPrincipal;
    }

    public Ejercicio getVarMovSecundario() {
        return varMovSecundario;
    }

    public void setVarMovSecundario(Ejercicio varMovSecundario) {
        this.varMovSecundario = varMovSecundario;
    }

    public Ejercicio getSentadillas() {
        return sentadillas;
    }

    public void setSentadillas(Ejercicio sentadillas) {
        this.sentadillas = sentadillas;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isChek() {
        return chek;
    }

    public void setChek(boolean chek) {
        this.chek = chek;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
