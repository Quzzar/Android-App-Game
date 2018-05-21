package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Helmet;

public class IronHelmet extends Helmet {
    public IronHelmet() {
        super(ItemType.IRON_HELMET, "Iron Helmet", 2, -1);
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
