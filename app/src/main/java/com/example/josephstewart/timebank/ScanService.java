package com.example.josephstewart.timebank;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by josephstewart on 5/14/17.
 */

public class ScanService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int start_id) {
        return super.onStartCommand(intent, flags, start_id);
    }
}
