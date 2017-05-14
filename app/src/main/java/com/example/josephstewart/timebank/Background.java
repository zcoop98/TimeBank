package com.example.josephstewart.timebank;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by josephstewart on 5/13/17.
 */

public class Background {

    Panel panel;
    private Bitmap image;
    private int x=0,y=0;

    public Background(Bitmap bitmap,Panel panel)
    {
        this.panel = panel;
        bitmap = panel.transformBitmap(bitmap);
        image = bitmap;
    }

    public void update()
    {
    }

    public void changeBackground(Bitmap bitmap)
    {
        bitmap = panel.transformBitmap(bitmap);
        image = bitmap;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image,x,y,null);
    }
}
