package com.example.boosterweigthlifting.ui.menu.rm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
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
import com.example.boosterweigthlifting.ui.popup.InfoActivity;

import lecho.lib.hellocharts.view.LineChartView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRM#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRM extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    LineChartView lineChartView;
    //Persistencia persistencia = new Persistencia();
    //ArrayList<Rm> rms = persistencia.getRms();

    String name;
    int type;
    DatePicker etDate;
    EditText editTextKg;


    public FragmentRM() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRM.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRM newInstance(String param1, String param2) {
        FragmentRM fragment = new FragmentRM();
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

        name = getArguments().getString("name").toString();
        type = getArguments().getInt("type");
        Globals.type = getArguments().getInt("type");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_r_m, container, false);

        TextView exercise = (TextView) view.findViewById(R.id.exercise);
        exercise.setText(name);


        FragmentRMActions fragmentRMActions = new FragmentRMActions(view);
        fragmentRMActions.getPersistencia(type);


        ImageButton btnInfo = (ImageButton) view.findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            String url;

            @Override
            public void onClick(View view) {

                switch (name) {
                    case "Snatch":
                        url = "https://www.youtube.com/embed/9xQp2sldyts";
                        break;
                    case "Clean & Jerk":
                        url = "https://www.youtube.com/embed/PjY1rH4_MOA";
                        break;
                    case "Back Squat":
                        url = "https://www.youtube.com/embed/QmZAiBqPvZw";
                        break;
                    default:
                        break;

                }

                Intent info = new Intent(getActivity(), InfoActivity.class);
                info.putExtra("url", url);
                startActivity(info);
            }
        });

        editTextKg = (EditText) view.findViewById(R.id.editTextKg);
        etDate = (DatePicker) view.findViewById(R.id.etDate);
        Button btnNewRm = (Button) view.findViewById(R.id.btnNewRm);
        btnNewRm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    int dayOfMonth = etDate.getDayOfMonth();
                    int month = etDate.getMonth();
                    int year = etDate.getYear();
                    String fecha =
                            year + "-" + String.format("%02d", month) + "-" + String.format("%02d", dayOfMonth);
                    Float peso = 0f;
                    peso = Float.parseFloat(editTextKg.getText().toString());

                    switch (Globals.type) {

                        case 1:
                            ApiAdapter apiAdapter = RetrofitClient.getClient().create(ApiAdapter.class);
                            Call<RmSnatch> call = apiAdapter.setUserRmSnacth("{\n" +
                                    "        \"fecha\": \"" + fecha + "\",\n" +
                                    "        \"peso\": " + peso + ",\n" +
                                    "        \"idUsuario\": " + Globals.idUsuario + "\n" +
                                    "    }");
                            call.enqueue(new Callback<RmSnatch>() {
                                @Override
                                public void onResponse(Call<RmSnatch> call, Response<RmSnatch> response) {

                                    if (response.code() == 200) {
                                        Toast.makeText(view.getContext(), R.string.NewRmCreate, Toast.LENGTH_LONG).show();
                                        fragmentRMActions.vaciarVariables();
                                        fragmentRMActions.getPersistencia(type);

                                    } else {
                                        Toast.makeText(view.getContext(), "Error: " + response.code(), Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onFailure(Call<RmSnatch> call, Throwable t) {
                                    Toast.makeText(view.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });
                            break;

                        case 2:
                            ApiAdapter apiAdapter2 = RetrofitClient.getClient().create(ApiAdapter.class);
                            Call<RmCleanJerk> call2 = apiAdapter2.setUserRmCleanJerk("{\n" +
                                    "        \"fecha\": \"" + fecha + "\",\n" +
                                    "        \"peso\": " + peso + ",\n" +
                                    "        \"idUsuario\": " + Globals.idUsuario + "\n" +
                                    "    }");
                            call2.enqueue(new Callback<RmCleanJerk>() {
                                @Override
                                public void onResponse(Call<RmCleanJerk> call, Response<RmCleanJerk> response) {

                                    if (response.code() == 200) {
                                        Toast.makeText(view.getContext(), R.string.NewRmCreate, Toast.LENGTH_LONG).show();
                                        fragmentRMActions.vaciarVariables();
                                        fragmentRMActions.getPersistencia(type);

                                    } else {
                                        Toast.makeText(view.getContext(), "Error: " + response.code(), Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onFailure(Call<RmCleanJerk> call, Throwable t) {
                                    Toast.makeText(view.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });
                            break;

                        case 3:
                            ApiAdapter apiAdapter3 = RetrofitClient.getClient().create(ApiAdapter.class);
                            Call<RmSquat> call3 = apiAdapter3.setUserRmSquat("{\n" +
                                    "        \"fecha\": \"" + fecha + "\",\n" +
                                    "        \"peso\": " + peso + ",\n" +
                                    "        \"idUsuario\": " + Globals.idUsuario + "\n" +
                                    "    }");
                            call3.enqueue(new Callback<RmSquat>() {
                                @Override
                                public void onResponse(Call<RmSquat> call, Response<RmSquat> response) {

                                    if (response.code() == 200) {
                                        Toast.makeText(view.getContext(), R.string.NewRmCreate, Toast.LENGTH_LONG).show();
                                        fragmentRMActions.vaciarVariables();
                                        fragmentRMActions.getPersistencia(type);

                                    } else {
                                        Toast.makeText(view.getContext(), "Error: " + response.code(), Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onFailure(Call<RmSquat> call, Throwable t) {
                                    Toast.makeText(view.getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });
                            break;

                    }


                } catch (Exception e) {

                }

            }
        });


        return view;
    }


}