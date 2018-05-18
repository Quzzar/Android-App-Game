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

    public Entity(EntityType entityType, String displayName, int health){
        this.entityType = entityType;
        this.displayName = displayName;

        this.maxHealth = health;
        this.health = health;

        EntityHandler.add(this.getEntityType(), this);

    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public int getHealth(){
        return health;
    }

    public void hurt(int damage) {
        health -= damage;
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

    public Image getImage(){
        return image;
    }

}
