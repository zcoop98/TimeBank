package com.example.josephstewart.timebank;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.example.josephstewart.timebank.Panel;
import com.example.josephstewart.timebank.R;
import com.example.josephstewart.timebank.imagepro.Image;
import com.example.josephstewart.timebank.states.State;
import com.example.josephstewart.timebank.states.StateManager;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by Tsuna on 5/14/2017.
 */

public class MainState extends State
{

    private Image pig;
    private Image coin;
    private Image counter;
    private Image settings;

    public MainState(Panel panel, StateManager manager) {
        super(panel,manager);

        pig = new Image(panel, R.drawable.default_pig,10,10);
        pig.setOnClick(new Callable() {
            public Object call() {
                //do stuff
                return null;
            }
        });
        pig.setOnUpdate(new Callable() {
            public Object call() {
                //update the image
                return null;
            }
        });

        coin = new Image(panel, R.drawable.default_coin,10,10);
        coin.setOnClick(new Callable() {
            public Object call() {
                //do stuff
                return null;
            }
        });
        coin.setOnUpdate(new Callable() {
            public Object call() {
                //update the image
                return null;
            }
        });

        counter = new Image(panel, R.drawable.default_counter,10,10);
        counter.setOnClick(new Callable() {
            public Object call() {
                //do stuff
                return null;
            }
        });
        counter.setOnUpdate(new Callable() {
            public Object call() {
                //update the image
                return null;
            }
        });

        settings = new Image(panel, R.drawable.default_settings,10,10);
        settings.setOnClick(new Callable() {
            public Object call() {
                //do stuff
                return null;
            }
        });
        settings.setOnUpdate(new Callable() {
            public Object call() {
                //update the image
                return null;
            }
        });
    }

    @Override
    public void init()
    {

    }

    @Override
    public void onTouchEvent(MotionEvent e)
    {
        //myImage.onTouchEvent(e);
    }

    @Override
    public void draw(Canvas canvas)
    {
        //myImage.draw(canvas);
    }

    @Override
    public void update()
    {
        //myImage.update();
    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent keyEvent)
    {

    }
}
