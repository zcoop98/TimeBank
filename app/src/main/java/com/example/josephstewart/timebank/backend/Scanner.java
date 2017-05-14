package com.example.josephstewart.timebank.backend;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.view.Display;

import com.example.josephstewart.timebank.MainActivity;
import com.example.josephstewart.timebank.UserData;

import static android.content.Context.ACTIVITY_SERVICE;

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
            System.out.println("hi");
            if (!UserData.isLocked()) {
                boolean screen = isScreenOn();
                try {
                    this.sleep(1000);
                    if (screen && isScreenOn()) {
                        System.out.println("Screen is on!");
                        UserData.increaseTimeSpent(1, context);
                        System.out.println("User has spent " + UserData.getTimeUsed() + " on phone");
                        System.out.println("User has a total of " + (UserData.getTimeAllowed() - UserData.getTimeUsed()) + " seconds left");
                    }
                } catch (Exception e) {
                }
            } else {
                if (isScreenOn() && !MainActivity.active)
                {
                    Intent dialogIntent = new Intent(context, MainActivity.class);
                    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(dialogIntent);
                }
                try {this.sleep(200);} catch(Exception e){}
            }
        }
    }

    public void setLooping(boolean looping)
    {
        this.looping = looping;
    }

}
