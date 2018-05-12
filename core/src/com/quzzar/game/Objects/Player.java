package com.quzzar.game.Objects;

import com.quzzar.game.Inventory.Inventory;
import com.quzzar.game.Inventory.Items.Axe;
import com.quzzar.game.Inventory.Items.HealthPotion;
import com.quzzar.game.Inventory.Items.ShortSword;

public class Player {

    private static int damage;
    private static int speed;
    private static int defense;

    private static Inventory inventory;


    private static boolean newPlayer = true;

    public static boolean create(){
        if(newPlayer){

            damage = 3;
            speed = 0;
            defense = 0;
            inventory = new Inventory(30);


            inventory.addItem(new Axe(1,3,-1));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new Axe(1,3,-1));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));


            newPlayer = false;

            return true;
        }else{
            return false;
        }

    }

    public static boolean isCreated(){
        return !newPlayer;
    }

    public static int getDamage() {
        return damage;
    }

    public static int getSpeed() {
        return speed;
    }

    public static int getDefense() {
        return defense;
    }

    public static Inventory getInventory() {
        return inventory;
    }
}
