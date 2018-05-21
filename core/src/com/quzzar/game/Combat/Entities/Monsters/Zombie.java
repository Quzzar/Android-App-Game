package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Zombie extends Monster {
    public Zombie() {
        super(EntityType.ZOMBIE, "Zombie", 4, 2, 0, 2);
    }
}
