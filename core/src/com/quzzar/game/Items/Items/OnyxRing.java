package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.Items.Groups.Ring;

public class OnyxRing extends Ring{
    public OnyxRing() {
        super(com.quzzar.game.Items.ItemType.ONYX_RING, "Onyx Ring", 4, 0);
    }

    @Override
    public com.quzzar.game.Items.ItemGroup getItemGroup() {
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
