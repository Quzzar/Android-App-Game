package com.quzzar.game.Inventory;

import com.badlogic.gdx.graphics.Texture;

public enum ItemType {

    SHORT_SWORD("badlogic.jpg",ItemGroup.WEAPON),
    AXE("badlogic.jpg",ItemGroup.WEAPON),
    LEATHER_ARMOR("badlogic.jpg",ItemGroup.ARMOR),
    HEALTH_POTION("badlogic.jpg",ItemGroup.CONSUMABLE),
    BOOK("badlogic.jpg",ItemGroup.QUEST);


    private Texture texture;
    private ItemGroup itemGroup;


    ItemType(String imagePath, ItemGroup itemGroup){
        this.texture = new Texture(imagePath);
        this.itemGroup = itemGroup;
    }

    public Texture getTexture() {
        return texture;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }



}
