package com.quzzar.game.Inventory;

public class Item {

    private ItemType itemType;
    private int amount;

    public Item(ItemType itemType, int amount){

        this.itemType = itemType;
        this.amount = amount;

    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getAmount() {
        return amount;
    }
}
