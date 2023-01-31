package com.leeseungyun1020.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class SubActivity extends AppCompatActivity {
    static String TAG = "LSYD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Log.d(TAG, "sub onCreate: ");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, AFragment.newInstance("p1", "p2"));
        fragmentTransaction.commit();
        findViewById(R.id.start_button).setOnClickListener(button -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerView, AFragment.newInstance("p1", "p2"));
            transaction.addToBackStack(null);
            transaction.commit();
        });
        findViewById(R.id.end_button).setOnClickListener(button -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerView, BFragment.newInstance("p1", "p2"));
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "sub onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "sub onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "sub onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "sub onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "sub onDestroy: ");
    }
}