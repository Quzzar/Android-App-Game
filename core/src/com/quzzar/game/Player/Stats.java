package com.quzzar.game.Player;

import com.quzzar.game.GameMain;
import com.quzzar.game.Inventory.Items.Groups.Armor;
import com.quzzar.game.Inventory.Items.Groups.Helmet;
import com.quzzar.game.Inventory.Items.Groups.Necklace;
import com.quzzar.game.Inventory.Items.Groups.Ring;
import com.quzzar.game.Inventory.Items.Groups.Weapon;
import com.quzzar.game.Screens.MenuScreen;

import java.io.Serializable;

public class Stats implements Serializable{

    final private int damageBase;
    final private int speedBase;
    final private int defenseBase;

    final private int maxHealth;

    private int health;
    private int damage;
    private int speed;
    private int defense;

    private Inventory inventory;

    public Stats(int maxHealth, int damageBase, int speedBase, int defenseBase){

        this.maxHealth = maxHealth;

        this.damageBase = damageBase;
        this.speedBase = speedBase;
        this.defenseBase = defenseBase;

        health = maxHealth;

        inventory = Player.getInventory();

    }

    public void update(){

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

        if(!inventory.getHelmet().isNothing()){
            defense += ((Helmet)inventory.getHelmet()).getDefenseMod();
        }

        if(!inventory.getNecklace().isNothing()){
            defense += ((Necklace)inventory.getNecklace()).getDefenseMod();
            speed += ((Necklace)inventory.getNecklace()).getSpeedMod();
        }

        if(!inventory.getFirstRing().isNothing()){
            defense += ((Ring)inventory.getFirstRing()).getDefenseMod();
            speed += ((Ring)inventory.getFirstRing()).getSpeedMod();
        }

        if(!inventory.getSecondRing().isNothing()){
            defense += ((Ring)inventory.getSecondRing()).getDefenseMod();
            speed += ((Ring)inventory.getSecondRing()).getSpeedMod();
        }

        // If player dies...
        if(health<=0){
            Player.reset();
            GameMain.instance.setScreen(new MenuScreen(GameMain.instance));
        }

    }


    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void heal(int amount) {
        health += amount;
        if(health>maxHealth){
            health = maxHealth;
        }
    }

    public void hurt(int amount) {
        health -= amount;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDefense() {
        return defense;
    }


}
