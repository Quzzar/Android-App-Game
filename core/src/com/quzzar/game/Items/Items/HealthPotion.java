package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Consumable;

public class HealthPotion extends Consumable{

    public HealthPotion() {
        super(ItemType.HEALTH_POTION, "Health Potion", 0, 0, 0, 0, 5);
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
    public double getDamageBoost() {
        return super.getDamageBoost();
    }

    @Override
    public double getSpeedBoost() {
        return super.getSpeedBoost();
    }

    @Override
    public double getDefenseBoost() {
        return super.getDefenseBoost();
    }

    @Override
    public double getHealthIncrease() {
        return super.getHealthIncrease();
    }
}
