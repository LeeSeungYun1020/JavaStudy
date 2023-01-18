package com.leeseungyun1020.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.leeseungyun1020.fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(FragmentName.BASIC, false);

        binding.basicFragmentButton.setOnClickListener((button) -> {
            replaceFragment(FragmentName.BASIC, true);
        });
        binding.listFragmentButton.setOnClickListener((button) -> {
            replaceFragment(FragmentName.LIST, true);
        });
        binding.dialogFragmentButton.setOnClickListener((button) -> {
            replaceFragment(FragmentName.DIALOG, true);
        });
    }

    private void replaceFragment(FragmentName name, boolean add) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (name) {
            case BASIC:
                BasicFragment basicFragment = BasicFragment.newInstance();
                // transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.setCustomAnimations(R.anim.fade_transit, R.anim.fade_transit);
                transaction.replace(R.id.fragmentContainerView, basicFragment);
                break;
            case LIST:
                ListFragment listFragment = ListFragment.newInstance();
                transaction.setCustomAnimations(R.anim.slide_left, R.anim.slide_right, R.anim.slide_left, R.anim.slide_right);
                transaction.replace(R.id.fragmentContainerView, listFragment);
                break;
            case DIALOG:
                DialogFragment dialogFragment = DialogFragment.newInstance();
                dialogFragment.show(manager, "dialog");
                break;
        }

        if (add)
            transaction.addToBackStack(null);
        transaction.commit();
    }

    private enum FragmentName {
        BASIC, LIST, DIALOG
    }
}