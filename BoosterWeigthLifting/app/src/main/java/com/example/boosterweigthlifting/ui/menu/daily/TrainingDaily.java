package com.example.boosterweigthlifting.ui.menu.daily;

import static android.view.Gravity.CENTER;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;

import com.example.boosterweigthlifting.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingDaily#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingDaily extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrainingDaily() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrainingDaily.
     */
    // TODO: Rename and change types and number of parameters
    public static TrainingDaily newInstance(String param1, String param2) {
        TrainingDaily fragment = new TrainingDaily();
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

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_training_daily, container, false);

        ViewFlipper vfDaily = (ViewFlipper) view.findViewById(R.id.vfDaily);

        TableLayout tl = (TableLayout) vfDaily.getChildAt(0);
        TableRow tr1 = (TableRow) tl.getChildAt(0);

        //CREAR TABLE LAYOUT NUEVA
        TableLayout table = new TableLayout(getContext());
        table.setGravity(CENTER);
        TableRow.LayoutParams tableParams = new TableRow.LayoutParams();
        tableParams.width = TableRow.LayoutParams.MATCH_PARENT;
        tableParams.height = TableRow.LayoutParams.MATCH_PARENT;
        table.setLayoutParams(tableParams);

        // CREAR FILA 1
        TableRow fila1 = new TableRow(getContext());
        fila1.setGravity(Gravity.CENTER_HORIZONTAL);
        TableRow.LayoutParams fila1Params = new TableRow.LayoutParams();
        fila1Params.height = TableRow.LayoutParams.WRAP_CONTENT;
        fila1.setLayoutParams(fila1Params);

        TextView tv1 = new TextView(getContext());
        tv1.setGravity(CENTER);
        tv1.setText("WOD 1 - 18/03/2022");

        fila1.addView(tv1);
        table.addView(fila1);

        // CREAR FILA 2
        TableRow fila2 = new TableRow(getContext());
        fila2.setGravity(Gravity.CENTER_HORIZONTAL);
        TableRow.LayoutParams fila2Params = new TableRow.LayoutParams();
        fila2Params.height = TableRow.LayoutParams.WRAP_CONTENT;
        fila2.setLayoutParams(fila1Params);

        TextView tv2 = new TextView(getContext());
        tv2.setGravity(CENTER);
        tv2.setText("Snatch");
        fila2.addView(tv2);

        TextView tv3 = new TextView(getContext());
        tv3.setGravity(CENTER);
        tv3.setText("70kg");

        fila2.addView(tv3);
        table.addView(fila2);



        vfDaily.addView(table);



        TableRow tr = (TableRow) tl.getChildAt(0);

        TextView tv = (TextView) tr.getChildAt(0);

        Log.d("text", ""+tv.getText());





        ImageButton btnSiguiente = (ImageButton) view.findViewById(R.id.btnSiguiente);
        ImageButton btnAtras = (ImageButton) view.findViewById(R.id.btnAtras);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vfDaily.setInAnimation(view.getContext(), R.anim.slide_out_left);
                vfDaily.setOutAnimation(view.getContext(), R.anim.slide_in_left);
                vfDaily.showNext();
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vfDaily.setInAnimation(view.getContext(), R.anim.slide_out_right);
                vfDaily.setOutAnimation(view.getContext(), R.anim.slide_in_right);
                vfDaily.showPrevious();
            }
        });

        return view;
    }
}