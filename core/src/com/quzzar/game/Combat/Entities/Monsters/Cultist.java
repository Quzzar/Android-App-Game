package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Cultist extends Monster {
    public Cultist() {
        super(EntityType.CULTIST, "Cultist", 8, 2, 3, 4);
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
