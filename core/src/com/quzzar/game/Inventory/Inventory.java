package com.quzzar.game.Inventory;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> contents;
    private int size;

    private Item pressedItem;

    public Inventory(int size) {
        this.size = size;
        this.contents = new ArrayList<Item>();
    }

    public boolean addItem(Item item){
        if(contents.size()<size){
            contents.add(item);
            return true;
        } else{
            return false;
        }
    }

    public Item getPressedItem() {
        return pressedItem;
    }

    public void setPressedItem(Item pressedItem) {
        this.pressedItem = pressedItem;
    }

    public ArrayList<Item> getContents() {
        return contents;
    }
}
