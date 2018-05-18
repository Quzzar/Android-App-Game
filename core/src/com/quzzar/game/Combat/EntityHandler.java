package com.quzzar.game.Combat;

import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.Entities.Monsters.Cultist;
import com.quzzar.game.Combat.Entities.Monsters.Demon;
import com.quzzar.game.Combat.Entities.Monsters.Furry;
import com.quzzar.game.Combat.Entities.Monsters.Goblin;
import com.quzzar.game.Combat.Entities.Monsters.Orc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityHandler{

    private static List<MapInstance> entityMap = new ArrayList<MapInstance>();

    public static void add(EntityType entityType, Entity entity){
        if(!mapContains(entityType)){
            entityMap.add(new MapInstance(entityType,entity));
        }
    }

    public static void remove(EntityType entityType, Entity entity){
        entityMap.remove(new MapInstance(entityType,entity));
    }

    public static boolean mapContains(EntityType entityType){
        for(MapInstance mapInstance : entityMap){
            if(mapInstance.getEntityType().equals(entityType)){
                return true;
            }
        }
        return false;
    }

    public static Entity getEntity(EntityType entityType){
        for(MapInstance mapInstance : entityMap){
            if(mapInstance.getEntityType().equals(entityType)){
                return mapInstance.getEntity();
            }
        }
        return null;
    }

    public static int mapSize(){
        return entityMap.size();
    }

    public static EntityType getEntityType(Entity entity){
        return entity.getEntityType();
    }

    ////////

    private static List<Monster> monsters = Arrays.asList(new Goblin(), new Furry(), new Cultist(), new Demon(), new Goblin(), new Orc());

    public static List<Monster> getMonsters(){
        return monsters;
    }


}


class MapInstance {

    private Entity entity;
    private EntityType entityType;


    public MapInstance(EntityType entityType, Entity entity) {
        this.entity = entity;
        this.entityType = entityType;
    }

    public Entity getEntity() {
        return entity;
    }

    public EntityType getEntityType() {
        return entityType;
    }

}
