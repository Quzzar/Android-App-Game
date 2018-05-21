package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Ring;

public class EmeraldRing extends Ring{
    public EmeraldRing() {
        super(ItemType.EMERALD_RING, "Emerald Ring", 0, 1);
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
