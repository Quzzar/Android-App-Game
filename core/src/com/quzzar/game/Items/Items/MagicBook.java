package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Weapon;

public class MagicBook extends Weapon {
    public MagicBook() {
        super(ItemType.BOOK, "Magic Book", 0.1, 3);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public double getDamageMod() {
        return super.getDamageMod();
    }

    @Override
    public double getSpeedMod() {
        return super.getSpeedMod();
    }
}
