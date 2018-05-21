package com.quzzar.game.Combat;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Utility;

import java.util.Random;

public class Entity {

    private EntityType entityType;
    private String displayName;
    private Image image;

    final private int maxHealth;
    private int health;

    final private int fadeOutCountMax = 100;
    private int fadeOutCount = fadeOutCountMax;

    public Entity(EntityType entityType, String displayName, int health){
        this.entityType = entityType;
        this.displayName = displayName;

        this.maxHealth = health;
        this.health = health;

        EntityMap.add(this.getEntityType(), this);

    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public int getHealth(){
        return health;
    }

    public void heal(int amount) {
        health += amount;
        if(health>maxHealth){
            health = maxHealth;
        }
    }

    public void hurt(int amount) {
        health -= amount;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public EntityGroup getEntityGroup(){
        return entityType.getEntityGroup();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void createImage(Location location){

        double width = 0.3;
        double height = Utility.adjustedHeightScale(width,width);

        // Get random texture from Textures
        this.image = new Image(entityType.getTextures().get((new Random()).nextInt(entityType.getTextures().size())),
                location, width, height);
    }

    public void draw(SpriteBatch batch){
        image.draw(batch);
    }

    public boolean isDead(){
        return getHealth()<=0;
    }

    public boolean drawFadeOut(SpriteBatch batch){
        fadeOutCount--;
        batch.setColor(1.0f, 1.0f, 1.0f, fadeOutCount*1.0f/fadeOutCountMax);

        if(fadeOutCount>0){
            image.draw(batch);
        }

        batch.setColor(1.0f, 1.0f, 1.0f, 1.0f);

        return fadeOutCount<=0;
    }

    public Image getImage(){
        return image;
    }

}
