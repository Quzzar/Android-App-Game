package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Badger extends Monster {
    public Badger() {
        super(EntityType.BADGER, "Badger", 5, 2, 1, 8);
    }
}
