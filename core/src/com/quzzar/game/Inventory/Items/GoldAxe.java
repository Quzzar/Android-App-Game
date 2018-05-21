package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Weapon;

public class GoldAxe extends Weapon {

    public GoldAxe() {
        super(ItemType.GOLD_AXE, "Gold Axe", 2, -2);
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
