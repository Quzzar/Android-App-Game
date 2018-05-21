package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Leech extends Monster {
    public Leech() {
        super(EntityType.LEECH, "Leech", 8, 4, 0, 1);
    }
}
