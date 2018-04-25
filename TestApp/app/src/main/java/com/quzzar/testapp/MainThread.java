package com.quzzar.testapp;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    public static final int MAX_FPS = 30;

    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;

    private Canvas screenCanvas;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;

    }

    @Override
    public void run(){
        long startTime;
        long timeMilli;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;

        while(running){
            startTime = System.nanoTime();
            screenCanvas = null;

            try {
                screenCanvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {

                    this.gamePanel.update();

                    this.gamePanel.draw(screenCanvas);

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(screenCanvas!=null){
                    try{
                        surfaceHolder.unlockCanvasAndPost(screenCanvas);
                    } catch (Exception e) {e.printStackTrace();}
                }
            }
            timeMilli = (System.nanoTime() - startTime)/1000000;
            waitTime = targetTime - timeMilli;
            try {
                if(waitTime > 0){
                    this.sleep(waitTime);
                }
            } catch (Exception e) {e.printStackTrace();}

            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if(frameCount == MAX_FPS){
                averageFPS = 1000/(totalTime/frameCount/1000000);
                frameCount = 0;
                totalTime = 0;
                //System.out.print(averageFPS);
            }
        }
    }


    public void setRunning(boolean running){
        this.running = running;
    }

}
