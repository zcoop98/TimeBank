package com.example.josephstewart.timebank;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import com.example.josephstewart.timebank.states.StateManager;

/**
 * Created by josephstewart on 5/13/17.
 */

public class Panel extends SurfaceView implements SurfaceHolder.Callback {

    public final boolean DEBUGGING = true;

    public static final int REL_HEIGHT = 2560;
    public static final int REL_WIDTH = 1440;

    private static int sysHeight;
    private static int sysWidth;

    private MainThread mainThread;
    private Background background;
    private StateManager manager;

    public Panel(Context context) {
        super(context);

        getHolder().addCallback(this);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        sysHeight = size.y;
        sysWidth = size.x;

        System.out.println("sysHeight = " + sysHeight);
        System.out.println("sysWidth = " + sysWidth);

        mainThread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    public int getSysHeight()
    {
        return sysHeight;
    }

    public int getSysWidth()
    {
        return sysWidth;
    }

    public Bitmap transformBitmap(Bitmap toTransform)
    {
        if (sysHeight == REL_HEIGHT && sysWidth == REL_WIDTH)
            return toTransform;
        double xScale = ((double)sysWidth)/((double)REL_WIDTH);
        double yScale = ((double)sysHeight)/((double)REL_HEIGHT);
        int newWidth = (int)(xScale * toTransform.getWidth());
        int newHeight = (int)(yScale * toTransform.getHeight());
        return Bitmap.createScaledBitmap(toTransform,newWidth,newHeight,false);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background), this);
        try {
            if (!mainThread.isRunning()) {
                //instantiate the background


                manager = new StateManager(this, background);
                //Start the game loop
                mainThread.setRunning(true);
                mainThread.start();
            }
        }
        catch (Exception e) {

            background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background), this);

            manager = new StateManager(this, background);
            mainThread.run();

        }
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
        if (event.getAction() == MotionEvent.ACTION_UP)
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

    @SuppressLint("MissingSuperCall")
    @Override
    public void draw(Canvas canvas)
    {
        manager.draw(canvas);
    }
}
