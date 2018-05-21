package com.quzzar.game.Items.Items.Groups;

import com.quzzar.game.Items.Item;
import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;

public class Consumable extends Item {

    private double timeDuration;

    private double damageBoost;
    private double speedBoost;
    private double defenseBoost;
    private double healthIncrease;

    public Consumable(ItemType itemType, String displayName,
                      double timeDuration, double damageBoost, double speedBoost, double defenseBoost, double healthIncrease) {
        super(itemType, displayName);

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

    public double getDamageBoost() {
        return damageBoost;
    }

    public double getSpeedBoost() {
        return speedBoost;
    }

    public double getDefenseBoost() {
        return defenseBoost;
    }

    public double getHealthIncrease() {
        return healthIncrease;
    }

}
