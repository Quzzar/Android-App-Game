package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Consumable;

public class HealthPotion extends Consumable{

    public HealthPotion(int amount, double timeDuration, int damageBoost, int speedBoost, int defenseBoost, int healthIncrease) {
        super(ItemType.HEALTH_POTION, amount, timeDuration, damageBoost, speedBoost, defenseBoost, healthIncrease);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public double getTimeDuration() {
        return super.getTimeDuration();
    }

    @Override
    public int getDamageBoost() {
        return super.getDamageBoost();
    }

    @Override
    public int getSpeedBoost() {
        return super.getSpeedBoost();
    }

    @Override
    public int getDefenseBoost() {
        return super.getDefenseBoost();
    }

    @Override
    public int getHealthIncrease() {
        return super.getHealthIncrease();
    }
}
