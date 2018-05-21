package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Necklace;

public class BrassNecklace extends Necklace {
    public BrassNecklace() {
        super(ItemType.BRASS_NECKLACE, "Brass Necklace", 1, 1);
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
