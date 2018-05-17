package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Necklace;

public class AmethystMedallion extends Necklace {
    public AmethystMedallion(int amount, int defenseMod, int speedMod) {
        super(ItemType.AMETHYST_MEDALLION, amount, "Amethyst Medallion", defenseMod, speedMod);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public int getDefenseMod() {
        return super.getDefenseMod();
    }

    @Override
    public int getSpeedMod() {
        return super.getSpeedMod();
    }
}
