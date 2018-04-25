package com.quzzar.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button{

    private Image idleImage;
    private Image pressedImage;

    public Button(Texture idle, Texture pressed, Location location, int width, int height){
        this.idleImage = new Image(idle,location,width,height);
        this.pressedImage = new Image(pressed,location,width,height);
    }

    public Image getIdleImage(){
        return idleImage;
    }

    public Image getPressedImage(){
        return pressedImage;
    }

    public Texture getTexture() {
        return idleImage.getTexture();
    }

    public Location getLocation() {
        return idleImage.getLocation();
    }

    public int getWidth() {
        return idleImage.getWidth();
    }

    public int getHeight() {
        return idleImage.getHeight();
    }

    public boolean containsLocation(Location pressedLoc){
        return idleImage.containsLocation(pressedLoc);
    }

    public void drawIdle(SpriteBatch batch){
        idleImage.draw(batch);
    }

    public void drawPressed(SpriteBatch batch){
        pressedImage.draw(batch);
    }

}
