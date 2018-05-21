package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Fury extends Monster {
    public Fury() {
        super(EntityType.FURY, "Fury", 10, 2, 10, 5);
    }

    @Override
    public double getHealth() {
        return super.getHealth();
    }

    @Override
    public double getDamage() {
        return super.getDamage();
    }

    @Override
    public double getDefense() {
        return super.getDefense();
    }

    @Override
    public double getSpeed() {
        return super.getSpeed();
    }
}
