package com.leeseungyun1020.activityapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.leeseungyun1020.activityapp2.databinding.ActivityAppBinding;

public class AppActivity extends AppCompatActivity {

    ActivityAppBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.dataText.setText(getIntent().getStringExtra("data1"));
        binding.dataText.append("\n" + getIntent().getDoubleExtra("data2", 0.0));

        binding.returnButton.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("data1", "data1");
            intent.putExtra("data2", 3.141592);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}