package com.example.josephstewart.timebank.backend;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by josephstewart on 5/14/17.
 */

public class ScanService extends Service {

    private static boolean running = false;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int start_id) {
        running = true;
        System.out.println("SCAN SERVICE STARTED");
        Scanner thread = new Scanner();
        thread.start();
        return super.onStartCommand(intent, flags, start_id);
    }

    @Override
    public void onDestroy() {
        running = false;
        System.out.println("Service stopped for some reason");
    }

    private static boolean isRunning() {
        return running;
    }
}
