package com.example.josephstewart.timebank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.josephstewart.timebank.backend.ScanService;

public class MainActivity extends Activity {

    public static boolean active = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        UserData.load(this);
        Intent i = new Intent(this, ScanService.class);
        this.startService(i);
    }

    @Override
    public void onStart() {
        super.onStart();
        setContentView(new Panel(this));
        active = true;
    }

    public void onStop() {
        super.onStop();
        active = false;
    }
}
