package com.quzzar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.DataHandling.SaveData;

public class Utility {

    public static void print(String tag, String message){
        Gdx.app.log(tag, message);
    }

    public static void screenExit(SpriteBatch batch){
        Input.end();
        batch.dispose();
        Gdx.input.setInputProcessor(null);
        SaveData.save();
    }

    public static void screenPause(){
        SaveData.save();
    }

    public static int getScreenWidth(){
        return Gdx.graphics.getWidth();
    }

    public static int getScreenHeight(){
        return Gdx.graphics.getHeight();
    }


    public static double adjustedHeightScale(double widthScale,double heightScale){
        /*
            When drawing an image, you may want the image to be unstretched
            (like a square). adjustedHeightScale() will account for the screen's
            differing width to height ratios and create a perfect square (1-to-1 ratio).
        */
        return heightScale*(getScreenWidth()*widthScale)/(getScreenHeight()*heightScale);
    }


}
