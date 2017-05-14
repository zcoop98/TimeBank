package com.example.josephstewart.timebank.backend;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.PowerManager;
import android.view.Display;

import com.example.josephstewart.timebank.UserData;

/**
 * Created by josephstewart on 5/14/17.
 */

public class Scanner extends Thread {

    Context context;
    private boolean looping;

    public Scanner (Context context)
    {
        super();
        this.context = context;
    }

    private boolean isScreenOn() {
        DisplayManager dm = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
        for (Display display : dm.getDisplays()) {
            if (display.getState() != Display.STATE_OFF) {
                return true;
            }
        }
        return false;
    }

    public void run() {
        looping = true;
        while(looping)
        {
            if (!UserData.isLocked()) {
                boolean screen = isScreenOn();
                try {
                    this.sleep(1000);
                    if (screen && isScreenOn()) UserData.increaseTimeSpent(1000, context);
                } catch (Exception e) {
                }
            } else {

            }
        }
    }

    public void setLooping(boolean looping)
    {
        this.looping = looping;
    }

}
