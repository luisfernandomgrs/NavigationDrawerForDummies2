package com.luisf.learning.appatmnavigationdrawer.ui.servicos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisf.learning.appatmnavigationdrawer.R;

public class ServicosFragment extends Fragment {

    public ServicosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_servicos, container, false);
    }
}