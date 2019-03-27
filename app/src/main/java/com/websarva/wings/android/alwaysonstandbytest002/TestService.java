package com.websarva.wings.android.alwaysonstandbytest002;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.TextView;
import android.widget.Toast;

public class TestService extends Service {
    private int sarCount_num = 0;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "サービス起動", Toast.LENGTH_SHORT).show();
        try {
            Thread.sleep(10000);

        } catch (InterruptedException e) {
        }

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "サービス終了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
