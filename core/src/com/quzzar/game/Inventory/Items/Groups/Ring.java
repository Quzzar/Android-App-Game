package com.quzzar.game.Inventory.Items.Groups;

import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;

public class Ring extends Item {

    private int defenseMod;
    private int speedMod;

    public Ring(ItemType itemType, String displayName, int defenseMod, int speedMod) {
        super(itemType, displayName);

        this.defenseMod = defenseMod;
        this.speedMod = speedMod;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.RING;
    }

    public int getDefenseMod() {
        return defenseMod;
    }

    public int getSpeedMod() {
        return speedMod;
    }
}
