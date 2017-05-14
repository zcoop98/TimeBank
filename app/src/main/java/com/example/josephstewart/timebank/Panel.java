package com.example.josephstewart.timebank;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.josephstewart.timebank.states.StateManager;

/**
 * Created by josephstewart on 5/13/17.
 */

public class Panel extends SurfaceView implements SurfaceHolder.Callback {

    public final boolean DEBUGGING = true;

    private MainThread mainThread;
    private Background background;
    private StateManager manager;

    public Panel(Context context) {
        super(context);

        getHolder().addCallback(this);

        mainThread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //instantiate the background
        background = new Background(BitmapFactory.decodeResource(getResources(),R.drawable.background));

        manager = new StateManager(this,background);
        //Start the game loop
        mainThread.setRunning(true);
        mainThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        boolean retry = true;
        while (retry)
        {
            try {
                mainThread.setRunning(false);
                mainThread.join();
                retry = false;
            } catch (Exception e) {}
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        manager.onTouchEvent(event);
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent keyEvent)
    {
        manager.onKeyDown(keyCode,keyEvent);
        return true;
    }

    public void update()
    {
        manager.update();
    }

    @Override
    public void draw(Canvas canvas)
    {
        manager.draw(canvas);
    }
}
