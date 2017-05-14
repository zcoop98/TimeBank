package com.example.josephstewart.timebank.states;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.josephstewart.timebank.Background;
import com.example.josephstewart.timebank.Panel;
import com.example.josephstewart.timebank.TestState;

import java.util.ArrayList;

/**
 * Created by josephstewart on 5/13/17.
 */

public class StateManager {
    private ArrayList<State> states;
    private int currentState = 0;
    private Panel panel;

    public final int TEST_STATE = 0;

    private Background background;

    public StateManager(Panel panel, Background background)
    {
        this.panel = panel;
        states = new ArrayList<State>();

        this.background = background;
        TestState testState = new TestState(panel,this);

        states.add(testState);
    }

    public void changeBackground(Bitmap image)
    {
        background.changeBackground(image);
    }

    public void changeState(int state)
    {
        this.currentState = state;
    }

    public void onTouchEvent(MotionEvent event)
    {
        states.get(currentState).onTouchEvent(event);
    }

    public void update()
    {
        background.update();
        states.get(currentState).update();
    }

    public void onKeyDown(int keyCode, KeyEvent keyEvent)
    {
        states.get(currentState).onKeyDown(keyCode, keyEvent);
    }

    public void draw(Canvas canvas)
    {
        //System.out.println("manager draw!");
        background.draw(canvas);
        states.get(currentState).draw(canvas);
    }
}
