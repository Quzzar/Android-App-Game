package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Quest;
import com.quzzar.game.Inventory.Items.Groups.Weapon;

public class MagicBook extends Weapon {
    public MagicBook() {
        super(ItemType.BOOK, "Magic Book", 1, 7);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public int getDamageMod() {
        return super.getDamageMod();
    }

    @Override
    public int getSpeedMod() {
        return super.getSpeedMod();
    }
}
