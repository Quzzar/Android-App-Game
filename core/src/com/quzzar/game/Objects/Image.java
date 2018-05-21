package com.quzzar.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Utility;

import java.io.Serializable;

public class Image implements Serializable{

    private transient Texture texture;
    private Location location;
    private double width;
    private double height;

    public Image(Texture texture, Location location, double widthScale, double heightScale) {
        this.texture = texture;
        this.location = location;
        this.width = widthScale;
        this.height = heightScale;
    }

    public Image(Texture texture, Location location, double scale) {
        this.texture = texture;
        this.location = location;
        this.width = scale;
        this.height = Utility.adjustedHeightScale(scale,texture.getHeight()*(scale/texture.getWidth()));
    }

    public Texture getTexture() {
        return texture;
    }

    public Location getLocation() {
        return location;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setLocation(Location newLocation){
        location = newLocation;
    }

    public boolean containsLocation(Location pressedLoc){
        return ( pressedLoc.getX() < (location.getX()+width/2) && pressedLoc.getX() > (location.getX()-width/2)
                && pressedLoc.getY() < (location.getY()+height/2) && pressedLoc.getY() > (location.getY()-height/2) );
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, (int) (Gdx.graphics.getWidth()*(location.getX()-width/2)), (int) (Gdx.graphics.getHeight()*(location.getY()-height/2)),
                (int) (Gdx.graphics.getWidth()*width), (int) (Gdx.graphics.getHeight()*height));
    }

}
