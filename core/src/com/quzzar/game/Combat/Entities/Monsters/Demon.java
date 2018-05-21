package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Demon extends Monster {
    public Demon() {
        super(EntityType.DEMON_GIRL, "Demon", 30, 3, 6, 8);
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
