package com.quzzar.game.Combat;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EntityType {

    ANTELOPE(Arrays.asList("game/entities/enemies/antelope.png"), EntityGroup.MONSTER),
    ARCHON(Arrays.asList("game/entities/enemies/Archon.png"), EntityGroup.MONSTER),
    BADGER(Arrays.asList("game/entities/enemies/badger_1.png","game/entities/enemies/badger_2.png"), EntityGroup.MONSTER),
    BASILISK(Arrays.asList("game/entities/enemies/Basilisk.png"), EntityGroup.MONSTER),
    BOAR(Arrays.asList("game/entities/enemies/boar.png"), EntityGroup.MONSTER),
    CRAB(Arrays.asList("game/entities/enemies/crab.png"), EntityGroup.MONSTER),
    CULTIST(Arrays.asList("game/entities/enemies/cultist_1.png", "game/entities/enemies/cultist_2.png",
            "game/entities/enemies/cultist_3.png"), EntityGroup.MONSTER),
    DEMON(Arrays.asList("game/entities/enemies/demon_1.png", "game/entities/enemies/demon_2.png",
            "game/entities/enemies/demon_3.png"), EntityGroup.MONSTER),
    DJINN(Arrays.asList("game/entities/enemies/Djinn_1.png","game/entities/enemies/Djinn_2.png"), EntityGroup.MONSTER),
    DRUID(Arrays.asList("game/entities/enemies/druid.png"), EntityGroup.MONSTER),
    DRYAD(Arrays.asList("game/entities/enemies/dryad.png"), EntityGroup.MONSTER),
    FOX(Arrays.asList("game/entities/enemies/fox.png"), EntityGroup.MONSTER),
    FURY(Arrays.asList("game/entities/enemies/fury.png", "game/entities/enemies/furry.png"), EntityGroup.MONSTER),
    GOBLIN(Arrays.asList("game/entities/enemies/goblin_1.png","game/entities/enemies/goblin_2.png"), EntityGroup.MONSTER),
    HARPY(Arrays.asList("game/entities/enemies/Harpy.png"), EntityGroup.MONSTER),
    LEECH(Arrays.asList("game/entities/enemies/leech.png"), EntityGroup.MONSTER),
    ORC(Arrays.asList("game/entities/enemies/orc.png"), EntityGroup.MONSTER),
    OGRE(Arrays.asList("game/entities/enemies/ogre.png"), EntityGroup.MONSTER),
    SHADE(Arrays.asList("game/entities/enemies/Shade.png"), EntityGroup.MONSTER),
    WIZARD(Arrays.asList("game/entities/enemies/wizard_1.png", "game/entities/enemies/wizard_2.png"), EntityGroup.MONSTER),
    ZOMBIE(Arrays.asList("game/entities/enemies/zombie_1.png", "game/entities/enemies/zombie_2.png",
            "game/entities/enemies/zombie_3.png"), EntityGroup.MONSTER);

    private ArrayList<Texture> textures = new ArrayList<Texture>();
    private EntityGroup entityGroup;

    EntityType(List<String> imagePaths, EntityGroup entityGroup){

        for(String path : imagePaths){
            textures.add(new Texture(path));
        }

        this.entityGroup = entityGroup;
    }

    public ArrayList<Texture> getTextures() {
        return textures;
    }

    public EntityGroup getEntityGroup() {
        return entityGroup;
    }

}
