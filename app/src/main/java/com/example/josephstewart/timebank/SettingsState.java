package com.example.josephstewart.timebank;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.josephstewart.timebank.Panel;
import com.example.josephstewart.timebank.imagepro.Image;

import java.util.List;


public class SettingsState
{
    private Image theImage;

    //getting applist
    void getInstalledApplications ()
    {

        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        final List AppsList = getInstalledApplications().queryIntentActivities( mainIntent, 0);
        for (Object object : AppsList)
        {
            ResolveInfo info = (ResolveInfo) object;
            Drawable icon = getBaseContext().getPackageManager().getApplicationIcon(info.activityInfo.applicationInfo);
            String strAppName  	= info.activityInfo.applicationInfo.publicSourceDir.toString();
            String strPackageName  = info.activityInfo.applicationInfo.packageName.toString();
            final String title 	= (String)((info != null) ? getBaseContext().getPackageManager().getApplicationLabel(info.activityInfo.applicationInfo) : "???");
        }
    }
    //returns image for apps
    Drawable getApplicationIcon (ApplicationInfo info)
    {
        if()
        {
            return

        }
    }



    /*
    SettingsState
    Should have way to change start of day
    Should have way to change end of day
    Should have way to add apps to the whitelist

     */
}
