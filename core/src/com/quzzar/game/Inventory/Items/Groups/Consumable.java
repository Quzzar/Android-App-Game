package com.quzzar.game.Inventory.Items.Groups;

import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;

public class Consumable extends Item {

    private double timeDuration;

    private int damageBoost;
    private int speedBoost;
    private int defenseBoost;
    private int healthIncrease;

    public Consumable(ItemType itemType, int amount, String displayName,
                      double timeDuration, int damageBoost, int speedBoost, int defenseBoost, int healthIncrease) {
        super(itemType, amount, displayName);

        this.timeDuration = timeDuration;

        this.damageBoost = damageBoost;
        this.speedBoost = speedBoost;
        this.defenseBoost = defenseBoost;

        this.healthIncrease = healthIncrease;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.CONSUMABLE;
    }

    public double getTimeDuration() {
        return timeDuration;
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public int getSpeedBoost() {
        return speedBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public int getHealthIncrease() {
        return healthIncrease;
    }

}
