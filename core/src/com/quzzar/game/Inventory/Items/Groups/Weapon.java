package com.quzzar.game.Inventory.Items.Groups;

import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;

public class Weapon extends Item {

    private int damageMod;
    private int speedMod;

    public Weapon(ItemType itemType, int amount, int damageMod, int speedMod) {
        super(itemType, amount);

        this.damageMod = damageMod;
        this.speedMod = speedMod;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.WEAPON;
    }

    public int getDamageMod() {
        return damageMod;
    }

    public int getSpeedMod() {
        return speedMod;
    }
}
