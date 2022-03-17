package com.example.boosterweigthlifting;

import java.util.ArrayList;

public class PrilepinTabla {

    private int[][] tabla = new int[4][7] ;

    public PrilepinTabla(){

        int fila=0;

        tabla[fila][0]=50;
        tabla[fila][1]=70;
        tabla[fila][2]=3;
        tabla[fila][3]=6;
        tabla[fila][4]=18;
        tabla[fila][5]=30;
        tabla[fila][6]=24;

        fila=1;
        tabla[fila][0]=70;
        tabla[fila][1]=79;
        tabla[fila][2]=3;
        tabla[fila][3]=6;
        tabla[fila][4]=12;
        tabla[fila][5]=24;
        tabla[fila][6]=18;


        fila=2;
        tabla[fila][0]=80;
        tabla[fila][1]=89;
        tabla[fila][2]=2;
        tabla[fila][3]=4;
        tabla[fila][4]=10;
        tabla[fila][5]=20;
        tabla[fila][6]=15;


        fila=3;
        tabla[fila][0]=90;
        tabla[fila][1]=120;
        tabla[fila][2]=1;
        tabla[fila][3]=2;
        tabla[fila][4]=4;
        tabla[fila][5]=10;
        tabla[fila][6]=7;


    }

    public int[][] getTabla() {
        return tabla;
    }


}


