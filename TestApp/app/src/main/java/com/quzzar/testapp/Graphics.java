package com.quzzar.testapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Graphics {


    private Bitmap drawBitmap;
    private static Canvas canvas;

    public void draw(Canvas screenCanvas, GamePanel gamePanel){

        if (drawBitmap == null) {
            drawBitmap = Bitmap.createBitmap(gamePanel.getWidth(), gamePanel.getHeight(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(drawBitmap);
        }

        Paint screenBackground = new Paint();
        screenBackground.setColor(Color.BLACK);
        screenCanvas.drawBitmap(drawBitmap, 0, 0, screenBackground);

    }

    public static void clearScreen(){
        canvas.drawColor(Color.BLACK);
    }

    public static Canvas getCanvas(){
        return canvas;
    }



}
