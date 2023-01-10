package com.leeseungyun1020.activityapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.leeseungyun1020.activityapp2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.testButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AppActivity.class);
            intent.putExtra("data1", "test!");
            intent.putExtra("data2", 10.10);
            startActivity(intent);
        });
    }
}