package com.example.boosterweigthlifting.ui.menu.rm;

import static android.view.Gravity.CENTER_HORIZONTAL;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.boosterweigthlifting.Persistencia;
import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.Rm;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class FragmentRMActions {

    private View view;
    LineChartView lineChartView;
    Persistencia persistencia = new Persistencia();
    ArrayList<Rm> rms = persistencia.getRms();
    String[] fecha;
    float[] peso;


    public FragmentRMActions(View view) {
        this.view = view;


    }

    public void getPersistencia(String name) {

        int cont = 0;

        for (int i = 0; i < rms.size(); i++) {
            if (rms.get(i).getEjercicio().getNombre() == name) {
                cont++;
                Log.d("hola", "hola" + cont);

            }
        }
        fecha = new String[cont];
        peso = new float[cont];

        for (int i = 0; i < rms.size(); i++) {
            if (rms.get(i).getEjercicio().getNombre() == name) {
                fecha[cont - 1] = rms.get(i).getFecha().getDay() + "-"
                        + rms.get(i).getFecha().getMonth() + "-" + rms.get(i).getFecha().getYear();
                peso[cont - 1] = rms.get(i).getPeso();
                cont--;

            }


        }
    }

    public void makeGrafica(String name) {

        getPersistencia(name);

        lineChartView = view.findViewById(R.id.chart);

        List pesoValues = new ArrayList();
        List fechaValues = new ArrayList();


        Line line = new Line(pesoValues).setColor(Color.parseColor("#9C27B0"));

        for (int i = 0; i < fecha.length; i++) {
            fechaValues.add(i, new AxisValue(i).setLabel(fecha[i]));
        }

        for (int i = 0; i < peso.length; i++) {
            pesoValues.add(new PointValue(i, peso[i]));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(fechaValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("KG");
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        int yAxisDataMax = 0;
        for (int i = 0; i < peso.length; i++) {
            if (peso[i] > yAxisDataMax) {
                yAxisDataMax = (int) peso[i];
            }
        }
        viewport.top = yAxisDataMax;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);


    }

    @SuppressLint("ResourceAsColor")
    public void makeTabla(String name) {

        getPersistencia(name);

        TableLayout tl = (TableLayout) view.findViewById(R.id.tableLayoutRM);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.column = 2;


        for (int i = 0; i < peso.length; i++) {

            TableRow row = new TableRow(view.getContext());
            row.setLayoutParams(params);
            TextView tv = new TextView(view.getContext());
            tv.setGravity(CENTER_HORIZONTAL);
            TextView tv2 = new TextView(view.getContext());
            tv2.setGravity(CENTER_HORIZONTAL);
            Button btnBorrar = new Button((view.getContext()));
            btnBorrar.setText(R.string.delete);
            //btnBorrar.setTextColor(Color.WHITE);



            tv2.setText(String.valueOf(peso[i]));
            tv.setText(fecha[i]);
            row.addView(tv, 0);
            row.addView(tv2, 1);
            row.addView(btnBorrar, 2);
            tl.addView(row);

        }


    }
}
