package fiek.unipr.stayfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import fiek.unipr.stayfit.R;

public class exercisesFragment extends Fragment {

    public exercisesFragment() {
        // Required empty public constructor
    }

    public static exercisesFragment newInstance(String param1, String param2) {
        return new exercisesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercises, container, false);
    }
}