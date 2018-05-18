package com.quzzar.game.Combat;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EntityType {

    GOBLIN(Arrays.asList("game/entities/enemies/goblin_1.png","game/entities/enemies/goblin_2.png"), EntityGroup.MONSTER),
    CULTIST(Arrays.asList("game/entities/enemies/cultist_1.png", "game/entities/enemies/cultist_1.png",
            "game/entities/enemies/cultist_1.png"), EntityGroup.MONSTER),
    ORC(Arrays.asList("game/entities/enemies/orc.png"), EntityGroup.MONSTER),
    FURRY(Arrays.asList("game/entities/enemies/furry.png"), EntityGroup.MONSTER),
    DEMON_GIRL(Arrays.asList("game/entities/enemies/demon_girl.png"), EntityGroup.MONSTER);

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
