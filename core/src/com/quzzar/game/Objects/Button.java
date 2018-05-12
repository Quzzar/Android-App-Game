package com.quzzar.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Input;

public class Button{

    private Image idleImage;
    private Image pressedImage;

    public Button(Texture idle, Texture pressed, Location location, double widthScale, double heightScale){
        this.idleImage = new Image(idle,location,widthScale,heightScale);
        this.pressedImage = new Image(pressed,location,widthScale,heightScale);
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

    public double getWidth() {
        return idleImage.getWidth();
    }

    public double getHeight() {
        return idleImage.getHeight();
    }

    public boolean containsLocation(Location pressedLoc){
        return idleImage.containsLocation(pressedLoc);
    }

    public void draw(SpriteBatch batch){
        if(containsLocation(Input.getTouchedLocation())){
            drawPressed(batch);
        } else {
            drawIdle(batch);
        }
    }

    public void drawIdle(SpriteBatch batch){
        idleImage.draw(batch);
    }

    public void drawPressed(SpriteBatch batch){
        pressedImage.draw(batch);
    }

}
