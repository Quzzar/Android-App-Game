package com.quzzar.testapp;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends GLSurfaceView implements SurfaceHolder.Callback{

    private MainThread thread;
    private Graphics graphics;

    private MapGeneration map;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        graphics = new Graphics();

        map = new MapGeneration();

        setFocusable(true);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);

        thread.setRunning(true);
        thread.start();

        map.generateMap();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try{
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public void draw(Canvas screenCanvas){
        super.draw(screenCanvas);
        this.graphics.draw(screenCanvas, this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent e){

        if(e.getAction()==MotionEvent.ACTION_DOWN){

            Graphics.clearScreen();
            map.generateMap();

        }

        return true;
    }

    public void update(){
        // calls every instant
    }

}
