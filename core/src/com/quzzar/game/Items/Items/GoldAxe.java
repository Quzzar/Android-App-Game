package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Weapon;

public class GoldAxe extends Weapon {

    public GoldAxe() {
        super(ItemType.GOLD_AXE, "Gold Axe", 2, -2);
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
