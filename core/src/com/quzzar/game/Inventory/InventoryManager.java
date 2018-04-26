package com.quzzar.game.Inventory;

import java.util.ArrayList;

public class InventoryManager {

    private ArrayList<Item> items;

    public InventoryManager(){

        items = new ArrayList<Item>();

    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
