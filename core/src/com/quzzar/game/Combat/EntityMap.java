package com.quzzar.game.Combat;


import java.util.ArrayList;
import java.util.List;

public class EntityMap{

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
