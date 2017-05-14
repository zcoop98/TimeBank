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

    public MainState(Panel panel, final StateManager manager) {
        super(panel, manager);

        pig = new Image(panel, R.drawable.default_pig,100,500);
        pig.setOnUpdate(new Callable() {
            public Object call() {
                //update the image
                return null;
            }
        });
        pig.scale(2);

        coin = new Image(panel, R.drawable.tcoin,10,10);
        coin.setOnUpdate(new Callable() {
            public Object call() {
                //update the image
                return null;
            }
        });
        coin.scale(.3);
    }

    @Override
    public void init()
    {

    }

    @Override
    public void onTouchEvent(MotionEvent e)
    {
        //counter.onTouchEvent(e);
        //settings.onTouchEvent(e);
    }

    @Override
    public void draw(Canvas canvas)
    {
        pig.draw(canvas);
        coin.draw(canvas);
        //counter.draw(canvas);
        //settings.draw(canvas);

    }

    @Override
    public void update()
    {
        pig.update();
        coin.update();
        //counter.update();
        //settings.update();
    }

    @Override
    public void onKeyDown(int keyCode, KeyEvent keyEvent)
    {

    }
}
