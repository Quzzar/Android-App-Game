package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Ring;

public class OnyxRing extends Ring{
    public OnyxRing() {
        super(ItemType.ONYX_RING, "Onyx Ring", 4, 0);
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
