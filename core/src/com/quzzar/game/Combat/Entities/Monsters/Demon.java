package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Demon extends Monster {
    public Demon() {
        super(EntityType.DEMON, "Demon", 30, 8, 7, 5);
    }

}
