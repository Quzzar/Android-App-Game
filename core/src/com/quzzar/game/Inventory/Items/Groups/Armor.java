package com.quzzar.game.Inventory.Items.Groups;

import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;

public class Armor extends Item {

    private int defenseMod;

    public Armor(ItemType itemType, String displayName, int defenseMod) {
        super(itemType, displayName);

        this.defenseMod = defenseMod;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.ARMOR;
    }

    public int getDefenseMod() {
        return defenseMod;
    }



}
