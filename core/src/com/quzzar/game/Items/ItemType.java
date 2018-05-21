package com.quzzar.game.Items;

import com.badlogic.gdx.graphics.Texture;
import com.quzzar.game.Objects.Image;

public enum ItemType {

    SHORT_SWORD("game/items/short_sword.png", com.quzzar.game.Items.ItemGroup.WEAPON),
    GOLD_AXE("game/items/axe.png", com.quzzar.game.Items.ItemGroup.WEAPON),
    LEATHER_ARMOR("game/items/leather_armor.png", com.quzzar.game.Items.ItemGroup.ARMOR),
    HEALTH_POTION("game/items/health_potion.png", com.quzzar.game.Items.ItemGroup.CONSUMABLE),
    BOOK("game/items/book.png", com.quzzar.game.Items.ItemGroup.QUEST),
    ONYX_RING("game/items/onyx_ring.png", com.quzzar.game.Items.ItemGroup.RING),
    RUBY_RING("game/items/ruby_ring.png", com.quzzar.game.Items.ItemGroup.RING),
    EMERALD_RING("game/items/emerald_ring.png", com.quzzar.game.Items.ItemGroup.RING),
    GOLD_RING("game/items/gold_ring.png", com.quzzar.game.Items.ItemGroup.RING),
    AMETHYST_MEDALLION("game/items/amethyst_medallion.png", com.quzzar.game.Items.ItemGroup.NECKLACE),
    BONE_AMULET("game/items/bone_amulet.png", com.quzzar.game.Items.ItemGroup.NECKLACE),
    BRASS_NECKLACE("game/items/brass_necklace.png", com.quzzar.game.Items.ItemGroup.NECKLACE),
    BONE_HELMET("game/items/bone_helmet.png", com.quzzar.game.Items.ItemGroup.HELMET),
    IRON_HELMET("game/items/iron_helmet.png", com.quzzar.game.Items.ItemGroup.HELMET),
    NOTHING("game/items/nothing.png", com.quzzar.game.Items.ItemGroup.GENERIC);


    private Texture texture;
    private com.quzzar.game.Items.ItemGroup itemGroup;

    ItemType(String imagePath, com.quzzar.game.Items.ItemGroup itemGroup){
        this.texture = new Texture(imagePath);
        this.itemGroup = itemGroup;
    }

    public Texture getTexture() {
        return texture;
    }

    public com.quzzar.game.Items.ItemGroup getItemGroup() {
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
