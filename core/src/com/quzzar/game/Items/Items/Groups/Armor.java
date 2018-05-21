package com.quzzar.game.Items.Items.Groups;

import com.quzzar.game.Items.Item;
import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;

public class Armor extends Item {

    private double defenseMod;
    private double speedMod;

    public Armor(ItemType itemType, String displayName, double defenseMod, double speedMod) {
        super(itemType, displayName);

        this.defenseMod = defenseMod;
        this.speedMod = speedMod;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.ARMOR;
    }

    public double getDefenseMod() {
        return defenseMod;
    }


    public double getSpeedMod() {
        return speedMod;
    }
}
