package com.quzzar.game.Inventory;

import com.badlogic.gdx.graphics.Texture;

public enum ItemType {

    SHORT_SWORD("game/items/short_sword.png",ItemGroup.WEAPON),
    AXE("game/items/axe.png",ItemGroup.WEAPON),
    LEATHER_ARMOR("game/items/leather_armor.png",ItemGroup.ARMOR),
    HEALTH_POTION("game/items/health_potion.png",ItemGroup.CONSUMABLE),
    BOOK("game/items/book.png",ItemGroup.QUEST);


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
