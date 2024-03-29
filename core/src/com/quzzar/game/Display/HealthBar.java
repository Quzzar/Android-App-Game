package com.quzzar.game.Display;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HealthBar {

    private Location location;
    private double scale;

    private List<Texture> barTextures = new ArrayList<Texture>();

    public HealthBar(Location location, double scale){

        this.location = location;
        this.scale = scale;

        for (int i = 10; i >= 0; i--) {
            barTextures.add(new Texture("game/bars/healthBar/bar_"+i+".png"));
        }

    }

    private Texture getBarTexture(double health, double maxHealth){

        //Get health into 0.0 - 1.0
        double factor = 1.0/maxHealth;
        double newHealth = factor*health;

        int frameNum = (int) Math.floor((barTextures.size()-1)*newHealth);
        if(frameNum<0){
            frameNum = 0;
        }
        return barTextures.get(frameNum);
    }

    public void draw(SpriteBatch batch, double health, double maxHealth){
        Image image = new Image(getBarTexture(health, maxHealth),location,scale);
        image.draw(batch);
    }

}
