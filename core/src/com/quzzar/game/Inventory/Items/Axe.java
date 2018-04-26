package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Weapon;

public class Axe extends Weapon {

    public Axe(int amount, int damageMod, int speedMod) {
        super(ItemType.AXE, amount, damageMod, speedMod);
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
