package com.leeseungyun1020.activityapp1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.leeseungyun1020.activityapp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent appIntent = new Intent("com.leeseungyun1020.app_activity");
        appIntent.putExtra("data1", "start");
        appIntent.putExtra("data2", 1.01);
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        binding.dataText.setText(intent.getStringExtra("data1"));
                        binding.dataText.append("\n" + intent.getDoubleExtra("data2", 0.0));
                    }
                }
        );

        binding.startOtherActivityButton.setOnClickListener(view -> {
            launcher.launch(appIntent);
        });
    }
}