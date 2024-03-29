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
    private MapLoc mapLoc;


    public Stats(double maxHealth, double damageBase, double speedBase, double defenseBase){

        this.maxHealth = maxHealth;

        this.damageBase = damageBase;
        this.speedBase = speedBase;
        this.defenseBase = defenseBase;

        health = maxHealth;

        inventory = Player.getInventory();
        mapLoc = new MapLoc(0,2);

    }

    public void update(){

        defense = defenseBase;
        damage = damageBase;
        speed = speedBase;

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
            speed += ((Helmet)inventory.getHelmet()).getSpeedMod();
        }

        if(!inventory.getArmor().isNothing()){
            defense += ((Armor)inventory.getArmor()).getDefenseMod();
            speed += ((Armor)inventory.getArmor()).getSpeedMod();
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
        if(health>maxHealth)
            health = maxHealth;
    }

    public void hurt(double amount) { health -= amount; }

    public double getDamage() { return damage; }

    public void setDamage(double amount) { damage = amount; }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double amount) { speed = amount; }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double amount) { defense = amount; }

    public MapLoc getPlayerLocation(){
        return mapLoc;
    }


}
