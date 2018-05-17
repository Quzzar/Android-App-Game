package com.quzzar.game.Inventory;

import com.badlogic.gdx.graphics.Texture;
import com.quzzar.game.Objects.Image;

public enum ItemType {

    SHORT_SWORD("game/items/short_sword.png",ItemGroup.WEAPON),
    GOLD_AXE("game/items/axe.png",ItemGroup.WEAPON),
    LEATHER_ARMOR("game/items/leather_armor.png",ItemGroup.ARMOR),
    HEALTH_POTION("game/items/health_potion.png",ItemGroup.CONSUMABLE),
    BOOK("game/items/book.png",ItemGroup.QUEST),
    ONYX_RING("game/items/onyx_ring.png",ItemGroup.RING),
    RUBY_RING("game/items/ruby_ring.png",ItemGroup.RING),
    EMERALD_RING("game/items/emerald_ring.png",ItemGroup.RING),
    GOLD_RING("game/items/gold_ring.png",ItemGroup.RING),
    AMETHYST_MEDALLION("game/items/amethyst_medallion.png",ItemGroup.NECKLACE),
    BONE_AMULET("game/items/bone_amulet.png",ItemGroup.NECKLACE),
    BRASS_NECKLACE("game/items/brass_necklace.png",ItemGroup.NECKLACE),
    BONE_HELMET("game/items/bone_helmet.png",ItemGroup.HELMET),
    IRON_HELMET("game/items/iron_helmet.png",ItemGroup.HELMET),
    NOTHING("game/items/nothing.png",ItemGroup.GENERIC);


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

    public static ItemType getFromImage(Image image){
        for(ItemType itemType : ItemType.values()){
            if(itemType.getTexture().equals(image.getTexture())){
                return itemType;
            }
        }
        return null;
    }

}
