package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Weapon;

public class ShortSword extends Weapon{

    public ShortSword() {
        super(ItemType.SHORT_SWORD, "Short Sword", 3, -1);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public double getDamageMod() {
        return super.getDamageMod();
    }

    @Override
    public double getSpeedMod() {
        return super.getSpeedMod();
    }

}
