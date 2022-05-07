package com.example.boosterweigthlifting.ui.menu.rm;

import static android.view.Gravity.CENTER_HORIZONTAL;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.persistence.interfaces.ApiAdapter;
import com.example.boosterweigthlifting.persistence.models.RmCleanJerk;
import com.example.boosterweigthlifting.persistence.models.RmSnatch;
import com.example.boosterweigthlifting.persistence.models.RmSquat;
import com.example.boosterweigthlifting.persistence.utils.Globals;
import com.example.boosterweigthlifting.persistence.utils.RetrofitClient;

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

public class FragmentRMActions extends Fragment {

    private View view;
    LineChartView lineChartView;
    String[] fecha = new String[0];
    float[] peso = new float[0];
    int[] id = new int[0];
    TableLayout tl;
    int type;
    Button btnBorrar;


    public FragmentRMActions(View view) {
        this.view = view;

        tl = (TableLayout) view.findViewById(R.id.tableLayoutRM);

    }

    public void getPersistencia(int type) {

        int idUser = Globals.idUsuario;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Globals.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiAdapter apiAdapter = retrofit.create(ApiAdapter.class);

        switch (type) {

            case 1:
                Call<ArrayList<RmSnatch>> call = apiAdapter.getRmSnatchByIdUser(idUser);
                call.enqueue(new Callback<ArrayList<RmSnatch>>() {

                    @Override
                    public void onResponse(Call<ArrayList<RmSnatch>> call, Response<ArrayList<RmSnatch>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                            return;
                        }

                        try {
                            ArrayList<RmSnatch> objectList = response.body();
                            int cont = objectList.size();
                            fecha = new String[cont];
                            peso = new float[cont];
                            id = new int[cont];

                            for (int i = 0; i < objectList.size(); i++) {

                                fecha[cont - 1] = objectList.get(i).getFecha();
                                peso[cont - 1] = objectList.get(i).getPeso();
                                id[cont - 1] = objectList.get(i).getIdRmSnatch();
                                cont--;
                            }

                            makeGrafica();
                            makeTabla();

                            for (Float max : peso) {
                                if (max > Globals.lastRmSnatch) {
                                    Globals.lastRmSnatch = max;
                                }
                            }

                        } catch (Exception e) {
                            Log.e("Exception: ", e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<RmSnatch>> call, Throwable t) {
                        Log.d("Estado", t.getMessage());
                        Toast.makeText(view.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
                break;

            case 2:
                Call<ArrayList<RmCleanJerk>> call2 = apiAdapter.getRmCleanJerkByIdUser(idUser);
                call2.enqueue(new Callback<ArrayList<RmCleanJerk>>() {

                    @Override
                    public void onResponse(Call<ArrayList<RmCleanJerk>> call, Response<ArrayList<RmCleanJerk>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                            return;
                        }

                        try {
                            ArrayList<RmCleanJerk> objectList = response.body();
                            int cont = objectList.size();
                            fecha = new String[cont];
                            peso = new float[cont];
                            id = new int[cont];

                            for (int i = 0; i < objectList.size(); i++) {
                                fecha[cont - 1] = objectList.get(i).getFecha();
                                peso[cont - 1] = objectList.get(i).getPeso();
                                id[cont - 1] = objectList.get(i).getIdRmCleanJerk();
                                cont--;
                            }

                            makeGrafica();
                            makeTabla();


                        } catch (Exception e) {
                            Log.e("Exception: ", e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<RmCleanJerk>> call, Throwable t) {
                        Log.d("Estado", t.getMessage());
                        Toast.makeText(view.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
                break;

            case 3:
                Call<ArrayList<RmSquat>> call3 = apiAdapter.getRmSquatByIdUser(idUser);
                call3.enqueue(new Callback<ArrayList<RmSquat>>() {

                    @Override
                    public void onResponse(Call<ArrayList<RmSquat>> call, Response<ArrayList<RmSquat>> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(view.getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                            return;
                        }

                        try {
                            ArrayList<RmSquat> objectList = response.body();
                            int cont = objectList.size();
                            fecha = new String[cont];
                            peso = new float[cont];
                            id = new int[cont];

                            for (int i = 0; i < objectList.size(); i++) {
                                fecha[cont - 1] = objectList.get(i).getFecha();
                                peso[cont - 1] = objectList.get(i).getPeso();
                                id[cont - 1] = objectList.get(i).getIdRmSquat();
                                cont--;
                            }

                            makeGrafica();
                            makeTabla();


                        } catch (Exception e) {
                            Log.e("Exception: ", e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<RmSquat>> call, Throwable t) {
                        Log.d("Estado", t.getMessage());
                        Toast.makeText(view.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

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


        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.column = 2;


        for (int i = 0; i < peso.length; i++) {

            ArrayList<Button> aButton = new ArrayList<Button>();

            TableRow row = new TableRow(view.getContext());
            row.setLayoutParams(params);
            TextView tv = new TextView(view.getContext());
            tv.setGravity(CENTER_HORIZONTAL);
            TextView tv2 = new TextView(view.getContext());
            tv2.setGravity(CENTER_HORIZONTAL);

            aButton.add(new Button((view.getContext())));
            aButton.get(aButton.size() - 1).setText(R.string.delete);
            //btnBorrar.setTextColor(Color.WHITE);

            tv2.setText(String.valueOf(peso[i]));
            tv.setText(fecha[i]);
            aButton.get(aButton.size() - 1).setId(id[i]);


            row.addView(tv, 0);
            row.addView(tv2, 1);
            row.addView(aButton.get(aButton.size() - 1), 2);
            tl.addView(row);

            aButton.get(aButton.size() - 1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Delete Id: " + view.getId() + "", Toast.LENGTH_LONG).show();
                    deleteRow(view.getId(), Globals.type);
                    Log.d("aqui", Globals.type + "");
                }
            });

        }


    }

    public void deleteRow(int idRM, int type) {

        try {

            switch (type) {
                case 1:
                    ApiAdapter apiAdapter = RetrofitClient.getClient().create(ApiAdapter.class);
                    Call<Void> call = apiAdapter.deleteSnatch(Globals.idUsuario, idRM);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Log.d("aqui", "okkkk" + "");
                            vaciarVariables();
                            getPersistencia(Globals.type);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Log.d("aqui", "mal");
                        }
                    });

                    break;

                case 2:
                    ApiAdapter apiAdapter2 = RetrofitClient.getClient().create(ApiAdapter.class);
                    Call<Void> call2 = apiAdapter2.deleteCleanJerk(Globals.idUsuario, idRM);
                    call2.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call2, Response<Void> response) {
                            Log.d("aqui", "ok");
                            vaciarVariables();
                            getPersistencia(Globals.type);
                        }

                        @Override
                        public void onFailure(Call<Void> call2, Throwable t) {
                            Log.d("aqui", "mal");
                        }
                    });

                    break;

                case 3:
                    ApiAdapter apiAdapter3 = RetrofitClient.getClient().create(ApiAdapter.class);
                    Call<Void> call3 = apiAdapter3.deleteSquat(Globals.idUsuario, idRM);
                    call3.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call3, Response<Void> response) {
                            Log.d("aqui", "ok");
                            vaciarVariables();
                            getPersistencia(Globals.type);
                        }

                        @Override
                        public void onFailure(Call<Void> call3, Throwable t) {
                            Log.d("aqui", "mal");
                        }
                    });
                    break;

            }

        } catch (Exception e) {

        }
    }

    public void vaciarVariables() {

        fecha = new String[0];
        peso = new float[0];
        id = new int[0];


        int count = tl.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = tl.getChildAt(i);
            if (child instanceof TableRow) ((ViewGroup) child).removeAllViews();
        }
        tl = (TableLayout) view.findViewById(R.id.tableLayoutRM);
    }
}
