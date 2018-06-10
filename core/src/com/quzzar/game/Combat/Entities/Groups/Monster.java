package com.quzzar.game.Combat.Entities.Groups;

import com.quzzar.game.Combat.Entity;
import com.quzzar.game.Combat.EntityType;
import com.quzzar.game.Generation.EnemyCreation;

import java.util.Random;

public class Monster extends Entity {

    private double damage;
    private double defense;
    private double speed;
    private boolean poisonous;

    public Monster(EntityType entityType, String displayName, double health, double damage, double defense, double speed, boolean poisonous) {
        super(entityType, displayName, health);

        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.poisonous = poisonous;

    }

    public Monster(EntityType entityType, String displayName, double health, double damage, double defense, double speed) {
        super(entityType, displayName, health);

        this.damage = damage;
        this.defense = defense;
        this.speed = speed;

        Random rand = new Random();
        this.poisonous = (rand.nextInt(3)==1);

    }

    public double getDamage() {
        return damage;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpeed() {
        return speed;
    }

    public void setDamage(double amount) { damage = amount; }

    public void setSpeed(double amount) { speed = amount; }

    public void setDefense(double amount) { defense = amount; }

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setPoisonous(boolean bool) { poisonous = bool; }

    public static Entity RANDOM(){
        return EnemyCreation.createWeakEnemy();
    }

}
