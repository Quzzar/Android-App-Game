package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Wizard extends Monster {
    public Wizard() {
        super(EntityType.WIZARD, "Wizard", 15, 4, 3, 5);
    }
}
