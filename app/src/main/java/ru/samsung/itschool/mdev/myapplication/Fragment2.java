package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.samsung.itschool.mdev.myapplication.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private OnFragment2DataListener frlistener;
    private Fragment2Binding binding2;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragment2DataListener) {
            frlistener = (OnFragment2DataListener) context; // контекст - текущая активность, которая сделала имплементацию
        } else {
            Log.d("RRR","Error!");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding2 = Fragment2Binding.inflate(inflater, container, false);
        binding2.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frlistener.onFragment2DataListener("Текст из фрагмента в активность!");
            }
        });
        return binding2.getRoot();
    }

    public interface OnFragment2DataListener {
        void onFragment2DataListener(String str);
    }
}