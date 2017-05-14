package com.example.josephstewart.timebank;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.josephstewart.timebank.imagepro.Image;
import com.example.josephstewart.timebank.states.State;
import com.example.josephstewart.timebank.states.StateManager;

import java.util.concurrent.Callable;

/**
 * Created by josephstewart on 5/13/17.
 */

public class TestState extends State {

    private Image myImage;

    public TestState(Panel panel, StateManager manager) {
        super(panel,manager);

        myImage = new Image(BitmapFactory.decodeResource(panel.getResources(),R.drawable.test_button),10,10);
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
}
