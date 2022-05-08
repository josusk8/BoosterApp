package com.example.boosterweigthlifting.ui.menu.training;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
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
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        getPersistencia();

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


        ArrayAdapter adapterA = new ArrayAdapter(requireContext(), R.layout.list_a, movimiento_principal);
        actv1.setAdapter(adapterA);

        actv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String selectedItem = (String) adapterView.getItemAtPosition(i);

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

    public void getPersistencia() {

        Globals.lastRmSnatch = 0;
        Globals.lastRmCleanJerk = 0;
        Globals.lastRmSquat = 0;

        Log.d("Aqui last", Globals.lastRmSnatch + "");

        int idUser = Globals.idUsuario;

        ApiAdapter apiAdapter = RetrofitClient.getClient().create(ApiAdapter.class);

        Call<ArrayList<RmSnatch>> call = apiAdapter.getRmSnatchByIdUser(idUser);
        call.enqueue(new Callback<ArrayList<RmSnatch>>() {

            @Override
            public void onResponse(Call<ArrayList<RmSnatch>> call, Response<ArrayList<RmSnatch>> response) {
                Log.d("Aqui on response ", response.code() + "");
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    ArrayList<RmSnatch> objectList = response.body();
                    int cont = objectList.size();
                    String[] fecha = new String[cont];
                    float[] peso = new float[cont];

                    for (int i = 0; i < objectList.size(); i++) {
                        fecha[cont - 1] = objectList.get(i).getFecha();
                        peso[cont - 1] = objectList.get(i).getPeso();
                        cont--;
                    }

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
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        ApiAdapter apiAdapter2 = RetrofitClient.getClient().create(ApiAdapter.class);

        Call<ArrayList<RmCleanJerk>> call2 = apiAdapter2.getRmCleanJerkByIdUser(idUser);
        call2.enqueue(new Callback<ArrayList<RmCleanJerk>>() {

            @Override
            public void onResponse(Call<ArrayList<RmCleanJerk>> call2, Response<ArrayList<RmCleanJerk>> response) {
                Log.d("Aqui on response ", response.code() + "");
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    ArrayList<RmCleanJerk> objectList = response.body();
                    int cont = objectList.size();
                    String[] fecha = new String[cont];
                    float[] peso = new float[cont];

                    for (int i = 0; i < objectList.size(); i++) {
                        fecha[cont - 1] = objectList.get(i).getFecha();
                        peso[cont - 1] = objectList.get(i).getPeso();
                        cont--;
                    }

                    for (Float max : peso) {
                        if (max > Globals.lastRmCleanJerk) {
                            Globals.lastRmCleanJerk = max;
                        }

                    }

                } catch (Exception e) {
                    Log.e("Exception: ", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<RmCleanJerk>> call, Throwable t) {
                Log.d("Estado", t.getMessage());
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        ApiAdapter apiAdapter3 = RetrofitClient.getClient().create(ApiAdapter.class);

        Call<ArrayList<RmSquat>> call3 = apiAdapter3.getRmSquatByIdUser(idUser);
        call3.enqueue(new Callback<ArrayList<RmSquat>>() {

            @Override
            public void onResponse(Call<ArrayList<RmSquat>> call3, Response<ArrayList<RmSquat>> response) {
                Log.d("Aqui on response ", response.code() + "");
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    ArrayList<RmSquat> objectList = response.body();
                    int cont = objectList.size();
                    String[] fecha = new String[cont];
                    float[] peso = new float[cont];

                    for (int i = 0; i < objectList.size(); i++) {
                        fecha[cont - 1] = objectList.get(i).getFecha();
                        peso[cont - 1] = objectList.get(i).getPeso();
                        cont--;
                    }

                    for (Float max : peso) {
                        if (max > Globals.lastRmSquat) {
                            Globals.lastRmSquat = max;
                        }

                    }

                } catch (Exception e) {
                    Log.e("Exception: ", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<RmSquat>> call, Throwable t) {
                Log.d("Estado", t.getMessage());
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

}



