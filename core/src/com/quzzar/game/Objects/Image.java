package com.quzzar.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Image {

    private Texture texture;
    private Location location;
    private int width;
    private int height;

    public Image(Texture texture, Location location, int width, int height) {
        this.texture = texture;
        this.location = location;
        this.width = width;
        this.height = height;
    }

    public Texture getTexture() {
        return texture;
    }

    public Location getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean containsLocation(Location pressedLoc){
        return ( pressedLoc.getX() < (location.getX()+width/2) && pressedLoc.getX() > (location.getX()-width/2)
                && pressedLoc.getY() < (location.getY()+height/2) && pressedLoc.getY() > (location.getY()-height/2) );
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, location.getX()-width/2, location.getY()-height/2, width, height);
    }

}
