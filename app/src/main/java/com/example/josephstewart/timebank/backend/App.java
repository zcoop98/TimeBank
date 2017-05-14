package com.example.josephstewart.timebank.backend;

import android.app.Application;
import android.content.Intent;

/**
 * Created by josephstewart on 5/14/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this,ScanService.class));
    }

}
