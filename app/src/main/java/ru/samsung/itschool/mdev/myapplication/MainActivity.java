package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import ru.samsung.itschool.mdev.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnFragment2DataListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //binding.button.setOnClickListener(v -> loadFragment(new Fragment1()));
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog md = new MyDialog();
                md.show(getSupportFragmentManager(),null);
            }
        });

        binding.button2.setOnClickListener(v -> loadFragment(new Fragment2()));
    }

    public void loadFragment(Fragment f) {
        // Менеджер переключения фрагментов
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // Передача данных во фрагмент
        Bundle args = new Bundle();
        args.putString("key", "Какая-то строка!");
        f.setArguments(args);

        ft.replace(R.id.body, f);
        ft.addToBackStack("stack");
        ft.commit();
    }

    @Override
    public void onFragment2DataListener(String str) {
        Snackbar.make(findViewById(R.id.root),str,Snackbar.LENGTH_SHORT).show();
    }
}