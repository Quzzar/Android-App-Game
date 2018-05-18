package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Orc extends Monster {
    public Orc() {
        super(EntityType.ORC, "Orc", 15, 10, 4, 2);
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
