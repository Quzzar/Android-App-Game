package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Furry extends Monster {
    public Furry() {
        super(EntityType.FURRY, "Furry", 50, 2, 10, 5);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public int getDamage() {
        return super.getDamage();
    }

    @Override
    public int getDefense() {
        return super.getDefense();
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
}
