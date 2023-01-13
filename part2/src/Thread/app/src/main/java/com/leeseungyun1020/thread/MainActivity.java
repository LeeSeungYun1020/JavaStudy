package com.leeseungyun1020.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

import com.leeseungyun1020.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    HandlerClass handler;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        running = true;
        handler = new HandlerClass(Looper.getMainLooper());
        new LongTimeWork().start();
    }

    class LongTimeWork extends Thread {
        @Override
        public void run() {
            super.run();
            while (running) {
                SystemClock.sleep(500);
                handler.sendEmptyMessage(0);
                runOnUiThread(() -> {
                    binding.timeText2.setText(System.currentTimeMillis() + "");
                });
            }
        }
    }

    class HandlerClass extends Handler {
        public HandlerClass(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if (msg.what == 0) {
                binding.timeText1.setText(System.currentTimeMillis() + "");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        running = false;
    }
}