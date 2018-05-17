package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Ring;

public class OnyxRing extends Ring{
    public OnyxRing(int amount, int defenseMod, int speedMod) {
        super(ItemType.ONYX_RING, amount, "Onyx Ring", defenseMod, speedMod);
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
