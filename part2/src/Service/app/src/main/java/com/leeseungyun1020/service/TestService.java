package com.leeseungyun1020.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class TestService extends Service {
    NotificationManager manager;
    static final String CHANNEL1_ID = "service";
    static final String CHANNEL1_NAME = "service";
    static final int MESSAGE1_ID = 10;
    volatile boolean isRunning = false;
    int i = 0;

    public TestService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // 서비스 가동시 호출
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("LSYD", "onStartCommand: service start");

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = manager.getNotificationChannel(CHANNEL1_ID);

            if(channel == null){
                channel = new NotificationChannel(CHANNEL1_ID, CHANNEL1_NAME, NotificationManager.IMPORTANCE_HIGH);
                channel.enableVibration(true);
                manager.createNotificationChannel(channel);
            }
        }

        Notification notification = new NotificationCompat.Builder(this, CHANNEL1_ID)
                .setSmallIcon(android.R.drawable.ic_menu_search)
                .setContentTitle("서비스 가동")
                .setContentText("시험 서비스가 가동 중입니다.")
                .build();
        startForeground(MESSAGE1_ID, notification);

        isRunning = true;
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        Log.d("LSYD", "onDestroy: service stop");
    }

    class ThreadClass extends Thread{
        @Override
        public void run() {
            super.run();
            while (isRunning) {
                SystemClock.sleep(1000);
                Log.d("LSYD", "run: " + ++i);
            }
        }
    }
}