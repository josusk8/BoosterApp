package com.example.boosterweigthlifting.ui.menu.rm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.ui.popup.SnatchActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CleanJerkFragmentRM#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CleanJerkFragmentRM extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    LineChartView lineChartView;
    String[] fecha = {"01/02/2021", "32/05/2022"};
    int[] peso = {75, 120};




    public CleanJerkFragmentRM() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CleanJerkFragmentRM.
     */
    // TODO: Rename and change types and number of parameters
    public static CleanJerkFragmentRM newInstance(String param1, String param2) {
        CleanJerkFragmentRM fragment = new CleanJerkFragmentRM();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clean_jerk_r_m, container, false);


        lineChartView = view.findViewById(R.id.chart);

        List pesoValues = new ArrayList();
        List fechaValues = new ArrayList();

    //



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
            if(peso[i] > yAxisDataMax){
                yAxisDataMax=peso[i];
            }
        }
        viewport.top = yAxisDataMax;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);





        Button btnCJ = (Button) view.findViewById(R.id.btnCJ);
        btnCJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent SnatchInfo = new Intent(getActivity(), SnatchActivity.class);
                startActivity(SnatchInfo);
            }
        });


        TableLayout tl = (TableLayout) view.findViewById(R.id.tableLayoutCyj);
        TableRow rowTable= (TableRow) view.findViewById(R.id.rowTable);
        TableRow row = new TableRow(getActivity());
        Button btnBorrar = new Button((getActivity()));

        btnBorrar.setText("borrar");

        TextView tv = new TextView(getActivity());
        TextView tv2 = new TextView(getActivity());
        tv.setText("dato1");
        tv2.setText("dato2");
        row.addView(tv,0);
        row.addView(tv2,1);
        row.addView(btnBorrar,2);
        tl.addView(row);










        return view;
    }


}