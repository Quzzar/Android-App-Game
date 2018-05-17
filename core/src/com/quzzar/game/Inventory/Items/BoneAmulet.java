package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Necklace;

public class BoneAmulet extends Necklace {
    public BoneAmulet(int amount, int defenseMod, int speedMod) {
        super(ItemType.BONE_AMULET, amount, "Bone Amulet", defenseMod, speedMod);
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
