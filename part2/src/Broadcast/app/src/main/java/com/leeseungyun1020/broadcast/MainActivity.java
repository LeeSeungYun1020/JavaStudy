package com.leeseungyun1020.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.leeseungyun1020.broadcast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TestReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerReceiver(receiver = new TestReceiver(), new IntentFilter("com.leeseungyun1020.testbroadcast"));

        binding.broadcastTestButton.setOnClickListener((button) -> {
            //Intent intent = new Intent(this, TestReceiver.class);
            // 내부에서 호출할 때는 바로 호출함
            Intent intent = new Intent("com.leeseungyun1020.testbroadcast");
            // 이름으로 바로 동작하지 않음 -> 코드상에서 등록하고 사용 필요
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }
}