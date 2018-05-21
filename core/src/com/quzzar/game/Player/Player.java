package com.quzzar.game.Player;

import com.quzzar.game.DataHandling.DataUtility;
import com.quzzar.game.GameMain;
import com.quzzar.game.Inventory.Items.AmethystMedallion;
import com.quzzar.game.Inventory.Items.Book;
import com.quzzar.game.Inventory.Items.GoldAxe;
import com.quzzar.game.Inventory.Items.Groups.Armor;
import com.quzzar.game.Inventory.Items.Groups.Helmet;
import com.quzzar.game.Inventory.Items.Groups.Necklace;
import com.quzzar.game.Inventory.Items.Groups.Ring;
import com.quzzar.game.Inventory.Items.Groups.Weapon;
import com.quzzar.game.Inventory.Items.HealthPotion;
import com.quzzar.game.Inventory.Items.HealthPotionLesser;
import com.quzzar.game.Screens.MenuScreen;

public class Player {

    private static Inventory inventory;
    private static Stats stats;

    private static boolean initialized = false;

    public static void create(){
        /* ONLY SHOULD BE CALLED FROM LoadData */
        if(!initialized){

            inventory = new Inventory(28);

            inventory.addItem(new GoldAxe());
            inventory.addItem(new Book("Old Book","A Forsaken Land","The Old Man on the Hill"));
            inventory.addItem(new HealthPotion());
            inventory.addItem(new HealthPotionLesser());
            inventory.addItem(new AmethystMedallion());

            stats = new Stats(10,3,5,1);

            initialized = true;
        }

    }

    public static void load(Inventory loadedInventory, Stats loadedStats){
        /* ONLY SHOULD BE CALLED FROM LoadData */
        if(!initialized){

            inventory = loadedInventory;
            stats = loadedStats;

            initialized = true;
        }

    }

    public static void update(){

        stats.update();

    }

    public static boolean isInitialized(){
        return initialized;
    }


    public static Inventory getInventory() {
        return inventory;
    }

    public static Stats getStats() {
        return stats;
    }


    public static void heal(int amount){
        stats.heal(amount);
    }

    public static void hurt(int amount){
        stats.hurt(amount);
    }


    public static void reset(){
        initialized = false;
        DataUtility.deleteAllFiles();
    }
}
