package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;

public class Ogre extends Monster {
    public Ogre() {
        super(EntityType.OGRE, "Ogre", 20, 6, 4, 3);
    }
}
