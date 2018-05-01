package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Weapon;

public class ShortSword extends Weapon{

    public ShortSword(int amount, int damageMod, int speedMod) {
        super(ItemType.SHORT_SWORD, amount, damageMod, speedMod);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public int getDamageMod() {
        return super.getDamageMod();
    }

    @Override
    public int getSpeedMod() {
        return super.getSpeedMod();
    }

}
