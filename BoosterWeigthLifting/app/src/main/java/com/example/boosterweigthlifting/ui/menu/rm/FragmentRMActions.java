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
import android.widget.Toast;

import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.persistence.interfaces.ApiAdapter;
import com.example.boosterweigthlifting.persistence.models.RmCleanJerk;
import com.example.boosterweigthlifting.persistence.models.RmSnatch;
import com.example.boosterweigthlifting.persistence.models.RmSquat;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentRMActions {

    private View view;
    LineChartView lineChartView;
    String[] fecha = new String[0];
    float[] peso = new float[0];


    public FragmentRMActions(View view) {
        this.view = view;

    }

    public void getPersistencia(int type) {

        int idWod = 1;
        String url1 = "http://10.0.2.2:8080/booster/v1/";
        String url2 = "http://192.168.0.21:8080/booster/v1/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiAdapter apiAdapter = retrofit.create(ApiAdapter.class);

        switch (type) {
            case 1:

                Call<ArrayList<RmSnatch>> call = apiAdapter.getRmSnatchByIdWod(idWod);
                call.enqueue(new Callback<ArrayList<RmSnatch>>() {

                    @Override
                    public void onResponse(Call<ArrayList<RmSnatch>> call, Response<ArrayList<RmSnatch>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                            return;
                        }

                        ArrayList<RmSnatch> objectList = response.body();

                        int cont = objectList.size();
                        fecha = new String[cont];
                        peso = new float[cont];

                        for (int i = 0; i < objectList.size(); i++) {

                            fecha[cont - 1] = objectList.get(i).getFecha();
                            peso[cont - 1] = objectList.get(i).getPeso();
                            cont--;
                        }

                        makeGrafica();
                        makeTabla();

                    }

                    @Override
                    public void onFailure(Call<ArrayList<RmSnatch>> call, Throwable t) {
                        Log.d("Estado", t.getMessage());
                        Toast.makeText(view.getContext(), "Codigo: " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
                break;

            case 2:

                Call<ArrayList<RmCleanJerk>> call2 = apiAdapter.getRmCleanJerkByIdWod(idWod);
                call2.enqueue(new Callback<ArrayList<RmCleanJerk>>() {

                    @Override
                    public void onResponse(Call<ArrayList<RmCleanJerk>> call, Response<ArrayList<RmCleanJerk>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                            return;
                        }

                        ArrayList<RmCleanJerk> objectList = response.body();

                        int cont = objectList.size();
                        fecha = new String[cont];
                        peso = new float[cont];

                        for (int i = 0; i < objectList.size(); i++) {

                            fecha[cont - 1] = objectList.get(i).getFecha();
                            peso[cont - 1] = objectList.get(i).getPeso();
                            cont--;
                        }

                        makeGrafica();
                        makeTabla();

                    }

                    @Override
                    public void onFailure(Call<ArrayList<RmCleanJerk>> call, Throwable t) {
                        Log.d("Estado", t.getMessage());
                        Toast.makeText(view.getContext(), "Codigo: " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
                break;

            case 3:

                Call<ArrayList<RmSquat>> call3 = apiAdapter.getRmSquatByIdWod(idWod);
                call3.enqueue(new Callback<ArrayList<RmSquat>>() {

                    @Override
                    public void onResponse(Call<ArrayList<RmSquat>> call, Response<ArrayList<RmSquat>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                            return;
                        }

                        ArrayList<RmSquat> objectList = response.body();

                        int cont = objectList.size();
                        fecha = new String[cont];
                        peso = new float[cont];

                        for (int i = 0; i < objectList.size(); i++) {

                            fecha[cont - 1] = objectList.get(i).getFecha();
                            peso[cont - 1] = objectList.get(i).getPeso();
                            cont--;
                        }

                        makeGrafica();
                        makeTabla();

                    }

                    @Override
                    public void onFailure(Call<ArrayList<RmSquat>> call, Throwable t) {
                        Log.d("Estado", t.getMessage());
                        Toast.makeText(view.getContext(), "Codigo: " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

                break;
        }

    }

    public void makeGrafica() {

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
    public void makeTabla() {

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
