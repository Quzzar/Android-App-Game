package com.quzzar.game.Objects;

import com.quzzar.game.Inventory.Inventory;
import com.quzzar.game.Inventory.Items.AmethystMedallion;
import com.quzzar.game.Inventory.Items.BoneAmulet;
import com.quzzar.game.Inventory.Items.BoneHelmet;
import com.quzzar.game.Inventory.Items.Book;
import com.quzzar.game.Inventory.Items.BrassNecklace;
import com.quzzar.game.Inventory.Items.EmeraldRing;
import com.quzzar.game.Inventory.Items.GoldAxe;
import com.quzzar.game.Inventory.Items.GoldRing;
import com.quzzar.game.Inventory.Items.Groups.Armor;
import com.quzzar.game.Inventory.Items.Groups.Weapon;
import com.quzzar.game.Inventory.Items.HealthPotion;
import com.quzzar.game.Inventory.Items.IronHelmet;
import com.quzzar.game.Inventory.Items.LeatherArmor;
import com.quzzar.game.Inventory.Items.OnyxRing;
import com.quzzar.game.Inventory.Items.RubyRing;
import com.quzzar.game.Inventory.Items.ShortSword;

public class Player {

    final private static int damageBase = 3;
    final private static int speedBase = 5;
    final private static int defenseBase = 0;

    private static Inventory inventory;

    private static int damage;
    private static int speed;
    private static int defense;

    private static boolean newPlayer = true;

    public static boolean create(){
        if(newPlayer){

            inventory = new Inventory(28);

            inventory.addItem(new GoldAxe(1,3,-1));
            inventory.addItem(new ShortSword(1,2,0));
            inventory.addItem(new LeatherArmor(1,3));
            inventory.addItem(new Book(1,"A Forsaken Land","The Old Man on the Hill"));
            inventory.addItem(new HealthPotion(1,2,0,0,0,5));
            inventory.addItem(new AmethystMedallion(1,0,0));
            inventory.addItem(new BoneAmulet(1,2,-2));
            inventory.addItem(new BrassNecklace(1,0,0));
            inventory.addItem(new EmeraldRing(1,1,0));
            inventory.addItem(new GoldRing(1,0,2));
            inventory.addItem(new OnyxRing(1,15,0));
            inventory.addItem(new RubyRing(1,2,0));
            inventory.addItem(new BoneHelmet(1,1));
            inventory.addItem(new IronHelmet(1,2));

            newPlayer = false;

            return true;
        }else{
            return false;
        }

    }

    public static void update(){
        defense = defenseBase;
        damage = damageBase;
        speed = speedBase;

        if(!inventory.getArmor().isNothing()){
            defense += ((Armor)inventory.getArmor()).getDefenseMod();
        }

        if(!inventory.getFirstHand().isNothing()){
            damage += ((Weapon)inventory.getFirstHand()).getDamageMod();
            speed += ((Weapon)inventory.getFirstHand()).getSpeedMod();
        }

        if(!inventory.getSecondHand().isNothing()){
            damage += ((Weapon)inventory.getSecondHand()).getDamageMod();
            speed += ((Weapon)inventory.getSecondHand()).getSpeedMod();
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
