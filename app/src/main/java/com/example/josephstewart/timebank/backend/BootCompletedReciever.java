package com.example.josephstewart.timebank.backend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by josephstewart on 5/14/17.
 */

public class BootCompletedReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("19723");
        System.out.println(intent.getAction());
    }

}
