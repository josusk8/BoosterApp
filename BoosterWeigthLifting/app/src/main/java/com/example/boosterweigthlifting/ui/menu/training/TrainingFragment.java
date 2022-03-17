package com.example.boosterweigthlifting.ui.menu.training;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.boosterweigthlifting.Ejercicio;
import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.Wod;

import java.io.Console;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrainingFragment() {
        // Required empty public constructor
    }

    TrainingActions trainingActions;
    int semana;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrainingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrainingFragment newInstance(String param1, String param2) {
        TrainingFragment fragment = new TrainingFragment();
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
        View view = inflater.inflate(R.layout.fragment_training, container, false);

        AutoCompleteTextView actv1 = (AutoCompleteTextView) view.findViewById(R.id.autoComplete1);
        AutoCompleteTextView actv2 = (AutoCompleteTextView) view.findViewById(R.id.autoComplete2);
        AutoCompleteTextView actv3 = (AutoCompleteTextView) view.findViewById(R.id.autoComplete3);
        AutoCompleteTextView actv4 = (AutoCompleteTextView) view.findViewById(R.id.autoComplete4);

        ArrayList<String> movimiento_principal =
                new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.movimiento_principal)));
        ArrayList<String> pull_principal1 =
                new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.pull_principal1)));
        ArrayList<String> pull_principal2 =
                new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.pull_principal2)));
        ArrayList<String> movimiento_variante1 =
                new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.movimiento_variante1)));
        ArrayList<String> movimiento_variante2 =
                new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.movimiento_variante2)));
        ArrayList<String> sentadillas =
                new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.sentadillas)));

        ImageButton week1 = (ImageButton) view.findViewById(R.id.week1);
        ImageButton week2 = (ImageButton) view.findViewById(R.id.week2);
        ImageButton week3 = (ImageButton) view.findViewById(R.id.week3);
        ImageButton week4 = (ImageButton) view.findViewById(R.id.week4);

        week1.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainingActions = new TrainingActions(view);
                semana = trainingActions.setWeek1(view);
            }
        });

        week2.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainingActions = new TrainingActions(view);
                semana = trainingActions.setWeek2(view);
            }
        });

        week3.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainingActions = new TrainingActions(view);
                semana = trainingActions.setWeek3(view);
            }
        });

        week4.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainingActions = new TrainingActions(view);
                semana = trainingActions.setWeek4(view);
            }
        });


        Switch switch1 = (Switch) view.findViewById(R.id.switch1);
        TextView fuerzaTecnica = (TextView) view.findViewById(R.id.fuerzaTecnica);


        ArrayAdapter adapterA = new ArrayAdapter(requireContext(), R.layout.list_a, movimiento_principal);
        actv1.setAdapter(adapterA);

        actv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                Log.d("selected item", selectedItem);

                actv2.setText(getString(R.string.add));
                actv3.setText(getString(R.string.add));

                switch (selectedItem) {

                    case "Snatch":
                        ArrayAdapter adapterBSnatch = new ArrayAdapter(requireContext(), R.layout.list_a, pull_principal1);
                        actv2.setAdapter(adapterBSnatch);

                        ArrayAdapter adapterCSnacth = new ArrayAdapter(requireContext(), R.layout.list_a, movimiento_variante1);
                        actv3.setAdapter(adapterCSnacth);
                        break;

                    case "Hang Snatch":
                        ArrayAdapter adapterBSnatch2 = new ArrayAdapter(requireContext(), R.layout.list_a, pull_principal1);
                        actv2.setAdapter(adapterBSnatch2);

                        ArrayAdapter adapterCSnacth2 = new ArrayAdapter(requireContext(), R.layout.list_a, movimiento_variante1);
                        actv3.setAdapter(adapterCSnacth2);
                        break;

                    case "Clean and Jerk":
                        ArrayAdapter adapterBCleanJerk = new ArrayAdapter(requireContext(), R.layout.list_a, pull_principal2);
                        actv2.setAdapter(adapterBCleanJerk);

                        ArrayAdapter adapterCCleanJerk = new ArrayAdapter(requireContext(), R.layout.list_a, movimiento_variante2);
                        actv3.setAdapter(adapterCCleanJerk);
                        break;

                    case "Clean Squat Jerk":
                        ArrayAdapter adapterBCleanJerk2 = new ArrayAdapter(requireContext(), R.layout.list_a, pull_principal2);
                        actv2.setAdapter(adapterBCleanJerk2);

                        ArrayAdapter adapterCCleanJerk2 = new ArrayAdapter(requireContext(), R.layout.list_a, movimiento_variante2);
                        actv3.setAdapter(adapterCCleanJerk2);
                        break;


                    case "Clean +2 Jerk":
                        ArrayAdapter adapterBCleanJerk3 = new ArrayAdapter(requireContext(), R.layout.list_a, pull_principal2);
                        actv2.setAdapter(adapterBCleanJerk3);

                        ArrayAdapter adapterCCleanJerk3 = new ArrayAdapter(requireContext(), R.layout.list_a, movimiento_variante2);
                        actv3.setAdapter(adapterCCleanJerk3);
                        break;

                }

                ArrayAdapter adapterD = new ArrayAdapter(requireContext(), R.layout.list_a, sentadillas);
                actv4.setAdapter(adapterD);
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    fuerzaTecnica.setText(getString(R.string.tecnical));
                } else {
                    fuerzaTecnica.setText(getString(R.string.force));
                }
            }
        });


        Button btnCalcular = (Button) view.findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dia = 0;
                trainingActions = new TrainingActions(view);
                trainingActions.setTraining(semana, dia);

            }
        });


        return view;
    }


}



