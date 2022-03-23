package com.example.boosterweigthlifting.ui.menu.rm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.boosterweigthlifting.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RmSelectedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RmSelectedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView ivSnatch;
    FragmentTransaction transaction;
    Fragment rmSelectedFragment, cleanJerkFragmentRM, snatchFragmentRM;


    public RmSelectedFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RmSelectedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RmSelectedFragment newInstance(String param1, String param2) {
        RmSelectedFragment fragment = new RmSelectedFragment();
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
        View view = inflater.inflate(R.layout.fragment_rm_selected, container, false);

        TextView tvSnatch = (TextView) view.findViewById(R.id.tvSnatch);
        TextView tvCyj = (TextView) view.findViewById(R.id.tvCyj);
        TextView tvSquat = (TextView) view.findViewById(R.id.tvSquat);
        Bundle bundle = new Bundle();


        tvSnatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("name", "Snatch");
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_fragmentRM, bundle);


            }
        });

        tvCyj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("name", "Clean & Jerk");
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_fragmentRM, bundle);


            }
        });

        tvSquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("name", "Back Squat");
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_fragmentRM, bundle);

            }
        });

        return view;
    }
}