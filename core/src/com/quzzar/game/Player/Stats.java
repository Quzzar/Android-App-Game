package com.quzzar.game.Player;

import com.quzzar.game.GameMain;
import com.quzzar.game.Items.Items.Groups.Armor;
import com.quzzar.game.Items.Items.Groups.Helmet;
import com.quzzar.game.Items.Items.Groups.Necklace;
import com.quzzar.game.Items.Items.Groups.Ring;
import com.quzzar.game.Items.Items.Groups.Weapon;
import com.quzzar.game.Screens.MenuScreen;

import java.io.Serializable;

public class Stats implements Serializable{

    final private double damageBase;
    final private double speedBase;
    final private double defenseBase;

    final private double maxHealth;

    private double health;
    private double damage;
    private double speed;
    private double defense;

    private Inventory inventory;

    public Stats(double maxHealth, double damageBase, double speedBase, double defenseBase){

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


    public double getMaxHealth() {
        return maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public void heal(double amount) {
        health += amount;
        if(health>maxHealth){
            health = maxHealth;
        }
    }

    public void hurt(double amount) {
        health -= amount;
    }

    public double getDamage() {
        return damage;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDefense() {
        return defense;
    }


}
