package com.quzzar.game.Inventory.Items.Groups;

import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;

public class Necklace extends Item {

    private int defenseMod;
    private int speedMod;

    public Necklace(ItemType itemType, String displayName, int defenseMod, int speedMod) {
        super(itemType, displayName);

        this.defenseMod = defenseMod;
        this.speedMod = speedMod;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.NECKLACE;
    }

    public int getDefenseMod() {
        return defenseMod;
    }

    public int getSpeedMod() {
        return speedMod;
    }
}
