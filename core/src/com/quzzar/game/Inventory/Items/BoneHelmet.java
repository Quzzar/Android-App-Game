package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Armor;
import com.quzzar.game.Inventory.Items.Groups.Helmet;

public class BoneHelmet extends Helmet {
    public BoneHelmet() {
        super(ItemType.BONE_HELMET, "Bone Helmet", 1);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public int getDefenseMod() {
        return super.getDefenseMod();
    }
}
