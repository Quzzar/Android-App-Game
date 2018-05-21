package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Ring;

public class RubyRing extends Ring{
    public RubyRing() {
        super(ItemType.RUBY_RING, "Ruby Ring", 0, 1);
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
