package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Weapon;

public class GoldAxe extends Weapon {

    public GoldAxe(int amount, int damageMod, int speedMod) {
        super(ItemType.GOLD_AXE, amount, "Gold Axe", damageMod, speedMod);
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
