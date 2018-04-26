package com.quzzar.game.Inventory;

public enum ItemType {

    SHORT_SWORD("badlogic.jpg",ItemGroup.WEAPON,+2,0,0),
    AXE("badlogic.jpg",ItemGroup.WEAPON,+3,-1,0),
    LEATHER_ARMOR("badlogic.jpg",ItemGroup.ARMOR,0,-1,+5),
    HEALTH_POTION("badlogic.jpg",ItemGroup.CONSUMABLE),
    BOOK("badlogic.jpg",ItemGroup.QUEST);


    private String imagePath;
    private ItemGroup itemGroup;
    private int damageMod;
    private int speedMod;
    private int defenseMod;


    ItemType(String imagePath, ItemGroup itemGroup, int damageMod, int speedMod, int defenseMod){
        this.imagePath = imagePath;
        this.itemGroup = itemGroup;
        this.damageMod = damageMod;
        this.speedMod = speedMod;
        this.defenseMod = defenseMod;
    }

    ItemType(String imagePath, ItemGroup itemGroup){
        this.imagePath = imagePath;
        this.itemGroup = itemGroup;
        this.damageMod = 0;
        this.speedMod = 0;
        this.defenseMod = 0;
    }

    public String getImagePath() {
        return imagePath;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public int getDamageMod() {
        return damageMod;
    }

    public int getSpeedMod() {
        return speedMod;
    }

    public int getDefenseMod() {
        return defenseMod;
    }
}
