package com.quzzar.game.Items.Items.Groups;

import com.quzzar.game.Items.Item;
import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;

public class Weapon extends Item {

    private double damageMod;
    private double speedMod;

    public Weapon(ItemType itemType, String displayName, double damageMod, double speedMod) {
        super(itemType, displayName);

        this.damageMod = damageMod;
        this.speedMod = speedMod;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.WEAPON;
    }

    public double getDamageMod() {
        return damageMod;
    }

    public double getSpeedMod() {
        return speedMod;
    }
}
