package ru.samsung.itschool.mdev.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.samsung.itschool.mdev.myapplication.databinding.Fragment1Binding;


public class Fragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;
    private Fragment1Binding binging1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("key");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binging1 = Fragment1Binding.inflate(inflater,container,false);
        binging1.textViewFragment1.setText(mParam1);
        return binging1.getRoot();
    }
}