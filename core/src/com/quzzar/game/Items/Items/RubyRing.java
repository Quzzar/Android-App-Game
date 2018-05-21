package com.quzzar.game.Items.Items;

import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;
import com.quzzar.game.Items.Items.Groups.Ring;

public class RubyRing extends Ring{
    public RubyRing() {
        super(ItemType.RUBY_RING, "Ruby Ring", 0, 1);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public double getDefenseMod() {
        return super.getDefenseMod();
    }

    @Override
    public double getSpeedMod() {
        return super.getSpeedMod();
    }
}
