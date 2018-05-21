package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Consumable;

public class HealthPotionGreater extends Consumable{

    public HealthPotionGreater() {
        super(ItemType.HEALTH_POTION, "Greater Health Potion", 0, 0, 0, 0, 10);
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
