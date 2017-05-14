package com.example.josephstewart.timebank.states;

import com.example.josephstewart.timebank.imagepro.Image;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.josephstewart.timebank.Panel;

/**
 * Created by Tsuna on 5/14/2017.
 */

public class LoadingState
{
    private Image myLogo;
    public LoadingState(Panel panel, StateManager manager) {
        super(panel,manager);

        myLogo = new Image(panel,R.drawable.test_button,10,10);
        myLogo.setOnClick(new Callable() {
            public Object call() {
                System.out.println("Clicked!");
                return null;
            }
        });
        myImage.setOnUpdate(new Callable() {
            public Object call() {
                //update the image
                return null;
            }
        });
    }

    @Override
    public void init() {

    }

    @Override
    public void onTouchEvent(MotionEvent e) {
        myImage.onTouchEvent(e);
    }

    @Override
    public void draw(Canvas canvas) {
        myImage.draw(canvas);
    }

    @Override
    public void update() {
        myImage.update();
    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent keyEvent) {
    }

    /*
     *LogoState
This just displays the logo then switches to MainState


public TestState(Panel panel, StateManager manager) {
        super(panel,manager);

        myImage = new Image(panel,R.drawable.test_button,10,10);
        myImage.setOnClick(new Callable() {
            public Object call() {
                System.out.println("Clicked!");
                return null;
            }
        });
        myImage.setOnUpdate(new Callable() {
            public Object call() {
                //update the image
                return null;
            }
        });
    }

    @Override
    public void init() {

    }

    @Override
    public void onTouchEvent(MotionEvent e) {
        myImage.onTouchEvent(e);
    }

    @Override
    public void draw(Canvas canvas) {
        myImage.draw(canvas);
    }

    @Override
    public void update() {
        myImage.update();
    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent keyEvent) {
    }

    */
}

