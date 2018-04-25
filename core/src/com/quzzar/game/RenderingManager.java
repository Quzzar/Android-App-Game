package com.quzzar.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class RenderingManager {

    private static ArrayList<Sprite> spritesRendered = new ArrayList<Sprite>();


    public static ArrayList<Sprite> getSpritesRendered(){
        return spritesRendered;
    }

    public static int getSpriteCount(){
        return spritesRendered.size();
    }

    public static void addSprite(Sprite sprite){
        if(!spritesRendered.contains(sprite)){
            spritesRendered.add(sprite);
        }
    }

    public static void removeSprite(Sprite sprite){
        if(spritesRendered.contains(sprite)){
            // Disposes texture to prevent data leakage
            sprite.getTexture().dispose();
            // Then removes from array
            spritesRendered.remove(sprite);
        }
    }

    public static void clearRender(){
        for(Sprite sprite : RenderingManager.getSpritesRendered()){
            sprite.getTexture().dispose();
        }
        spritesRendered.clear();
    }

}
