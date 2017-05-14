package com.example.josephstewart.timebank;

import java.util.ArrayList;

/**
 * Created by Ashley on 5/13/2017.
 */

public class UserData
{
    //private so we don't allow anyone to change the variable
    private int coins, startTime, endTime;
    private int currentPigTheme;
    private ArrayList<Integer> unlockedPigThemes;
    private ArrayList<String> whiteList;
    private long timeUsed, timeAllowed;

    //constructor - default
    public UserData()
    {
        coins = 0;
        startTime = 0;
        endTime = 2359;
        timeUsed = 0;
        timeAllowed = -1; //-1 means that there is no time / we are not tracking it rn
                        //-1 means unlimited time
        currentPigTheme = PigLibrary.PORKY;
        unlockedPigThemes = new ArrayList<Integer>();
        unlockedPigThemes.add(PigLibrary.PORKY); //adds default pig to the list of allowed pigs
        whiteList = new ArrayList<String>();
    }
    public int getCoins()
    {
        return coins;
    }
    public int getStartTime()
    {
        return startTime;
    }
    public int getEndTime()
    {
        return endTime;
    }
    public boolean isLocked()
    {
        return ((timeUsed >= timeAllowed) || timeAllowed == -1);
    }
    public ArrayList<String> whiteList()
    {
        return whiteList;
    }
    public long getTimeUsed()
    {
        return timeUsed;
    }

    //modifiers
    public void changeCoins(int i)
    {
        coins += i;
    }
    //validations
    public boolean setStartTime(int i)
    {
        //check to make sure it is less than endtime and greater than 0 --> return true
        if ((i < endTime) && (i > 0))
        {
            startTime = i;
            return true;
        }
        return false;
    }
    public boolean setEndTime(int i)
    {
        //end time: check to make sure it is greater than start time and less than 2359
        if ((i > startTime) && (i > 0))
        {
            endTime = i;
            return true;
        }
        return false;
    }
    /*   public boolean changetimeUsed(long i)
    {
        //takes an long adds to time
        return true;
    }
    */
}
