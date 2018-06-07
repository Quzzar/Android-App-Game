package com.quzzar.game.Combat.Entities.Groups;

import com.quzzar.game.Combat.Entity;
import com.quzzar.game.Combat.EntityType;
import com.quzzar.game.Generation.EnemyCreation;

import java.util.Random;

public class Monster extends Entity {

    private double damage;
    private double defense;
    private double speed;

    public Monster(EntityType entityType, String displayName, double health, double damage, double defense, double speed, boolean poisonous) {
        super(entityType, displayName, health);

        this.damage = damage;
        this.defense = defense;
        this.speed = speed;

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


    public static Entity RANDOM(){
        return EnemyCreation.createWeakEnemy();
    }


}
