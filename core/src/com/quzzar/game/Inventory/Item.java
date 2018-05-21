package com.quzzar.game.Inventory;

import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;

import java.io.Serializable;

public class Item implements Serializable{

    private ItemType itemType;
    private String displayName;
    private Image image;

    public Item(ItemType itemType, String displayName){

        this.itemType = itemType;
        this.displayName = displayName;

    }

    public ItemGroup getItemGroup() {
        return itemType.getItemGroup();
    }

    public ItemType getItemType() {
        return itemType;
    }

    public Image getImage(){
        return image;
    }

    public boolean isNothing(){
        return itemType.equals(ItemType.NOTHING);
    }

    public void createImage(Location location, double wScale, double hScale){
        this.image = new Image(itemType.getTexture(), location, wScale, hScale);
    }

    public String getDisplayName(){
        return displayName;
    }

    public Item clone(){
        // WARNING: THIS FUNCTION MIGHT NOT PRODUCE A PERFECT CLONE
        Item newItem = new Item(itemType, displayName);
        if(getImage()!=null){
            newItem.createImage(getImage().getLocation(),getImage().getWidth(),getImage().getHeight());
        }
        return newItem;
    }

}
