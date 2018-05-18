package com.quzzar.game.Combat.Entities.Monsters;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityType;
import com.quzzar.game.Objects.Location;

public class Goblin extends Monster {

    public Goblin() {
        super(EntityType.GOBLIN,"Goblin", 10, 3, 2, 7);
    }

}
