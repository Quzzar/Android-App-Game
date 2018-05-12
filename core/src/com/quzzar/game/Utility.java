package com.quzzar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Player;

public class Utility {

    public static void print(String tag, String message){
        Gdx.app.log(tag, message);
    }

    public static Item getItemFromImage(Image image){
        for(Item item : Player.getInventory().getContents()){
            if(item.getTexture().equals(image.getTexture())){
                return item;
            }
        }
        return null;
    }

    public static void screenDispose(SpriteBatch batch){
        Input.setNone(true);
        batch.dispose();
        Gdx.input.setInputProcessor(null);
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
