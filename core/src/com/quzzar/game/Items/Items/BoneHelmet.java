package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Helmet;

public class BoneHelmet extends Helmet {
    public BoneHelmet() {
        super(ItemType.BONE_HELMET, "Bone Helmet", 1, 0);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public double getDefenseMod() {
        return super.getDefenseMod();
    }
}
