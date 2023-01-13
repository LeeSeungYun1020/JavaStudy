package com.leeseungyun1020.service;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.leeseungyun1020.service.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Intent serviceIntent;
    TestService ipcService;
    TestServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        serviceIntent = new Intent(this, TestService.class);

        binding.startServiceButton.setOnClickListener((button) -> {
            if (!isServiceRunning("com.leeseungyun1020.service.TestService")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(serviceIntent);
                } else {
                    startService(serviceIntent);
                }
                connection = new TestServiceConnection();
                bindService(serviceIntent, connection, BIND_AUTO_CREATE);
            }
        });

        binding.stopServiceButton.setOnClickListener((button) -> {
            if (isServiceRunning("com.leeseungyun1020.service.TestService")) {
                unbindService(connection);
                stopService(serviceIntent);
            }
        });

        binding.getValueButton.setOnClickListener((button) -> {
            if (ipcService != null)
                binding.countText.setText(ipcService.getValue() + "");
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    boolean isServiceRunning(String name) {
        return ((ActivityManager) getSystemService(ACTIVITY_SERVICE))
                .getRunningServices(Integer.MAX_VALUE)
                .stream()
                .anyMatch(it -> Objects.equals(it.service.getClassName(), name));
    }

    class TestServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("LSYD", "onServiceConnected: ");
            ipcService = ((TestService.LocalBinder) iBinder).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("LSYD", "onServiceDisconnected: ");
            ipcService = null;
        }
    }
}