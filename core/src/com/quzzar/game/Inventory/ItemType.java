package com.quzzar.game.Inventory;

public enum ItemType {

    SHORT_SWORD("badlogic.jpg",ItemGroup.WEAPON),
    AXE("badlogic.jpg",ItemGroup.WEAPON),
    LEATHER_ARMOR("badlogic.jpg",ItemGroup.ARMOR),
    HEALTH_POTION("badlogic.jpg",ItemGroup.CONSUMABLE),
    BOOK("badlogic.jpg",ItemGroup.QUEST);


    private String imagePath;
    private ItemGroup itemGroup;


    ItemType(String imagePath, ItemGroup itemGroup){
        this.imagePath = imagePath;
        this.itemGroup = itemGroup;
    }

    public String getImagePath() {
        return imagePath;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }



}
