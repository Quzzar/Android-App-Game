package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Necklace;

public class BoneAmulet extends Necklace {
    public BoneAmulet() {
        super(ItemType.BONE_AMULET, "Bone Amulet", 3, -1);
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
