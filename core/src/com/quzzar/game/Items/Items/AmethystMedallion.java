package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Necklace;

public class AmethystMedallion extends Necklace {
    public AmethystMedallion() {
        super(ItemType.AMETHYST_MEDALLION, "Amethyst Medallion", 0, 2);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public double getDefenseMod() {
        return super.getDefenseMod();
    }

    @Override
    public double getSpeedMod() {
        return super.getSpeedMod();
    }
}
