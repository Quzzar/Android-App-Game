package com.quzzar.game.Combat.Entities.Groups;

import com.quzzar.game.Combat.Entity;
import com.quzzar.game.Combat.EntityHandler;
import com.quzzar.game.Combat.EntityType;

import java.util.Random;

public class Monster extends Entity {

    private int damage;
    private int defense;
    private int speed;

    public Monster(EntityType entityType, String displayName, int health, int damage, int defense, int speed) {
        super(entityType, displayName, health);

        this.damage = damage;
        this.defense = defense;
        this.speed = speed;

    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }


    public static Entity RANDOM(){
        Monster randMonster = EntityHandler.getMonsters().get((new Random()).nextInt(EntityHandler.getMonsters().size()));
        return randMonster;
    }


}