package com.example.josephstewart.timebank;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by josephstewart on 5/13/17.
 */

public class MainThread extends Thread {

    private int FPS = 30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private Panel gamePanel;
    private boolean running;
    private static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, Panel gamePanel)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    public boolean isRunning() {return running;}

    public void run()
    {
        //These variables are use for tracking average FPS
        long startTime;
        long timeMilis;
        long waitTime;
        long totalTime = 0;
        long frameCount = 0;
        long targetTime = 1000/FPS;

        //while the thread is running
        while (running) {
            //get time before update and draw are executed
            startTime = System.nanoTime();
            canvas = null;

            try {
                //lock canvas
                canvas = this.surfaceHolder.lockCanvas();

                //synchronize update and draw on surfaceHolder
                synchronized (surfaceHolder) {
                    //update the app and draw to the canvas
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            } catch (Exception e) {e.printStackTrace();}
            finally {
                if (canvas != null)
                {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {}
                }
            }

            //get time after update and draw are executed and then sleep how ever long it takes to make this whole process a 30th of a second
            timeMilis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMilis;

            try {
                this.sleep(waitTime);
            } catch (Exception e) {}

            //calc total time so far and increase frame count
            totalTime += System.nanoTime() - startTime;
            frameCount++;

            //if frame count reaches 30 then calc averageFPS
            if (frameCount == FPS) {
                averageFPS = (totalTime / frameCount) / (long)1000000;

                //System.out.println("Average FPS: " + averageFPS);
                //System.out.println("Total Frames: " + frameCount);
                //System.out.println("Total Time: " + totalTime);

                frameCount = 0;
                totalTime = 0;
            }
        }
    }

    public void setRunning(boolean b)
    {
        running = b;
    }
}
