package com.example.boosterweigthlifting.ui.menu.rm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.boosterweigthlifting.R;
import com.example.boosterweigthlifting.ui.popup.InfoActivity;

import lecho.lib.hellocharts.view.LineChartView;

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

                switch (name){
                    case "Snatch":
                        url = "https://www.youtube.com/embed/9xQp2sldyts";
                        break;
                    case "Clean & Jerk":
                        url = "https://www.youtube.com/embed/PjY1rH4_MOA";
                        break;
                    case"Back Squat":
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





        return view;
    }


}