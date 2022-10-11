package com.example.giuaky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.giuaky.databinding.ActivityMainBinding;
import com.example.giuaky.databinding.ActivityPageBinding;

public class Page extends AppCompatActivity {



    ActivityPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new SettingFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
        switch (item.getItemId()){
            case R.id.home:
                replaceFragment(new SettingFragment());
                break;
            case R.id.profile:
                replaceFragment(new ProfileFragment());
                break;
            case R.id.list:
                replaceFragment(new ListFragment());
                break;



        }



            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}