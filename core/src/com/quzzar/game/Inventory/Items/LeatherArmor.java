package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Armor;

public class LeatherArmor extends Armor {
    public LeatherArmor(int amount, int defenseMod) {
        super(ItemType.LEATHER_ARMOR, amount, "Leather Armor", defenseMod);
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
