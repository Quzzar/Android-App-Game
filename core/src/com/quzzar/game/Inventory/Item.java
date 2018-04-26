package com.quzzar.game.Inventory;

public class Item {

    private ItemType itemType;
    private int amount;

    public Item(ItemType itemType, int amount){

        this.itemType = itemType;
        this.amount = amount;

    }

    public ItemGroup getItemGroup() {
        return itemType.getItemGroup();
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getAmount() {
        return amount;
    }

    public String getImagePath(){
        return itemType.getImagePath();
    }

}
