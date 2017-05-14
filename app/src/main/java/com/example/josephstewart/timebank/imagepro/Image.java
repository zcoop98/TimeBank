package com.example.josephstewart.timebank.imagepro;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.josephstewart.timebank.Panel;

import java.util.concurrent.Callable;

/**
 * Created by josephstewart on 5/13/17.
 */

public class Image {

    private static final int TRANSPARENT = 0;

    private Bitmap image;
    private int x,y;

    private Callable onUpdate;
    private Callable onClick;

    public Image(Bitmap image, int x, int y)
    {
        this.image = image;
        onUpdate = null;
        onClick = null;
    }

    public void setOnUpdate(Callable onUpdate)
    {
        this.onUpdate = onUpdate;
    }

    public void setOnClick(Callable onClick)
    {
        this.onClick = onClick;
    }

    public void update()
    {
        try {
            onUpdate.call();
        } catch (Exception e) {};
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image,x,y,null);
    }

    public void onTouchEvent(MotionEvent event)
    {
        if (event.getX() > x && event.getY() > y && event.getX() < x + image.getWidth() && event.getY() < y+image.getHeight()){
            if (image.getPixel((int)(event.getX()-x),(int)(event.getY()-y)) != 0x000000)
                try {onClick.call();} catch(Exception e) {}
        }
    }

}
