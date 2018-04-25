package com.quzzar.gametest.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.quzzar.gametest.RenderingManager;

public class Player {

    private float x;
    private float y;
    private Sprite sprite;

    public Player(float x, float y){
        this.x = x;
        this.y = y;
        this.sprite = new Sprite(new Texture("good_guy.png"));
    }

    public void movePlayer(float newX, float newY){
        sprite.translate(newX, newY);
    }

    public void createPlayer(){

        sprite.setPosition(x, y);
        RenderingManager.addSprite(sprite);

    }

    public void deletePlayer(){

        RenderingManager.removeSprite(sprite);

    }

}
