package com.example.josephstewart.timebank.states;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.josephstewart.timebank.Panel;

/**
 * Created by josephstewart on 5/13/17.
 */

public abstract class State {
    protected StateManager manager;
    protected Panel panel;

    public State(Panel panel, StateManager manager) {
        this.panel = panel;
        this.manager = manager;
    }

    public abstract void init();
    public abstract void onTouchEvent(MotionEvent e);
    public abstract void draw(Canvas canvas);
    public abstract void update();
    public abstract void onKeyDown(int keyCode, KeyEvent keyEvent);
}
