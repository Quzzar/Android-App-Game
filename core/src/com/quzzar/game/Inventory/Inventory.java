package com.quzzar.game.Inventory;

import com.quzzar.game.Inventory.Items.Nothing;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private ArrayList<Item> fullContents;

    private int equipSlots = 7;

    public Inventory(int size) {
        this.fullContents = new ArrayList<Item>();
        for(int i = 0; i < size+equipSlots; i++){
            fullContents.add(Nothing.create());
        }
    }

    public boolean addItem(Item newItem){
        for(int i = equipSlots; i < getTotalSize(); i++){
            if(fullContents.get(i).isNothing()){
                fullContents.set(i,newItem);
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(Item newItem){
        for(int i = 0; i < getTotalSize(); i++){
            if(fullContents.get(i).equals(newItem)){
                fullContents.set(i,Nothing.create());
                return true;
            }
        }
        return false;
    }

    // Index 0 = FirstHand
    public Item getFirstHand(){
        return fullContents.get(0);
    }

    // Index 1 = SecondHand
    public Item getSecondHand(){
        return fullContents.get(1);
    }

    // Index 2 = Armor
    public Item getArmor(){
        return fullContents.get(2);
    }

    // Index 3 = Helmet
    public Item getHelmet(){
        return fullContents.get(3);
    }

    // Index 4 = Necklace
    public Item getNecklace(){
        return fullContents.get(4);
    }

    // Index 5 = FirstRing
    public Item getFirstRing(){
        return fullContents.get(5);
    }

    // Index 5 = SecondRing
    public Item getSecondRing(){
        return fullContents.get(6);
    }


    /*
    public void setArmor(Armor armor) {
        if(armor==null){
            fullContents.set(2,Nothing.create());
        }else{
            fullContents.set(2,armor);
        }
    }
    */

    public ArrayList<Item> getFullContents() {
        return fullContents;
    }


    public List<Item> getContents() {
        return fullContents.subList(equipSlots, fullContents.size());
    }


    public int getTotalSize(){
        // The total number of inventory slots, includes equipment slots
        return fullContents.size();
    }

    public int getSize(){
        // The number of unfilled slots, includes equipment slots
        int count = 0;
        for(Item item : fullContents){
            if(!item.isNothing()){
                count++;
            }
        }
        return count;
    }

    public boolean isEquipped(Item item){
        return fullContents.indexOf(item)<equipSlots;
    }

}
