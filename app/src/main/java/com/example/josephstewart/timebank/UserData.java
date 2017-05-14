package com.example.josephstewart.timebank;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ashley on 5/13/2017.
 */

public class UserData
{
    //private so we don't allow anyone to change the variable
    private static final int USE_LIMIT = 30;
    private static int coins, startTime, endTime;
    private static int currentPigTheme;
    private static ArrayList<Integer> unlockedPigThemes;
    private static ArrayList<String> whiteList;
    private static long timeUsed, timeAllowed;
    private static boolean isInit = false;
    private static int useCount = 0;

    //constructor - default
    public UserData()
    {

    }

    private static void doTutorial() {}

    public static void save(Context context)
    {

    }

    public static void saveTimeUsed(Context context)
    {

    }

    public static void load(Context context) {
        try {
            FileInputStream fin = context.openFileInput("user_data");
            InputStreamReader isr = new InputStreamReader(fin);
            BufferedReader reader = new BufferedReader(isr);
            String rawData[] = reader.readLine().split("!SP!");
            coins = Integer.parseInt(rawData[0]);
            startTime = Integer.parseInt(rawData[1]);
            endTime = Integer.parseInt(rawData[2]);
            currentPigTheme = Integer.parseInt(rawData[3]);
            unlockedPigThemes = new ArrayList<Integer>();
            String[] rawUnlockedPigThemes = rawData[4].split("!D!");

            for (int i = 0; i < rawUnlockedPigThemes.length; i ++)
            {
                unlockedPigThemes.add(Integer.parseInt(rawUnlockedPigThemes[i]));
            }

            String[] rawWhitelist = rawData[5].split("!D!");

            whiteList = new ArrayList<String>();
            for (int i = 0; i < rawWhitelist.length; i ++)
            {
                whiteList.add(rawWhitelist[i]);
            }

            loadTimeUsed(context);
            isInit = true;
        } catch (Exception e) {
            coins = 0;
            startTime = 0;
            endTime = 2359;
            timeUsed = 0;
            timeAllowed = 20; //-1 means that there is no time / we are not tracking it rn
            //-1 means unlimited time
            currentPigTheme = PigLibrary.PORKY;
            unlockedPigThemes = new ArrayList<Integer>();
            unlockedPigThemes.add(PigLibrary.PORKY); //adds default pig to the list of allowed pigs
            whiteList = new ArrayList<String>();
            save(context);
            saveTimeUsed(context);
            doTutorial();
            isInit = true;
        }
    }

    public static void loadTimeUsed(Context context) {
        try {
            FileInputStream fin = context.openFileInput("time_data");
            InputStreamReader isr = new InputStreamReader(fin);
            BufferedReader reader = new BufferedReader(isr);
            String rawData[] = reader.readLine().split("!SP!");
            timeUsed = Long.parseLong(rawData[0]);
            timeAllowed = Long.parseLong(rawData[1]);
        } catch (Exception e) {}
    }

    public static int getCoins()
    {
        if (isInit) return coins;
        return 0;
    }
    public static int getStartTime()
    {
        if (isInit) return startTime;
        return 0;
    }
    public static int getEndTime()
    {
        if (isInit) return endTime;
        return 0;
    }
    public static boolean isLocked()
    {
        if (isInit) return ((timeUsed >= timeAllowed) || timeAllowed == -1);
        return false;
    }
    public static ArrayList<String> whiteList()
    {
        if (isInit) return whiteList;
        return null;
    }
    public static ArrayList<Integer> getUnlockedPigThemes() {if(isInit) return unlockedPigThemes;
    return null;}
    public static long getTimeUsed()
    {
        if (isInit) return timeUsed; return 0;
    }
    public static long getTimeAllowed() {if (isInit) return timeAllowed; return 0;}

    //modifiers
    public void changeCoins(int i)
    {
        if(isInit) coins += i;
    }

    public static void changePig(int pTheme)
    {
        if (isInit)
        for (int i = 0; i < unlockedPigThemes.size(); i++) {
            if (pTheme == unlockedPigThemes.get(i)) currentPigTheme = pTheme;
        }
    }

    //validations
    public static boolean setStartTime(int i)
    {
        //check to make sure it is less than endtime and greater than 0 --> return true
        if ((i < endTime) && (i > 0))
        {
            startTime = i;
            return true;
        }
        return false;
    }

    public static boolean setEndTime(int i)
    {
        //end time: check to make sure it is greater than start time and less than 2359
        if ((i > startTime) && (i > 0))
        {
            endTime = i;
            return true;
        }
        return false;
    }

    public static void increaseTimeSpent(long i, Context context)
    {
        timeUsed += i;
        useCount++;
        if(useCount >= USE_LIMIT) {
            useCount = 0;
            saveTimeUsed(context);
        }
    }
}
