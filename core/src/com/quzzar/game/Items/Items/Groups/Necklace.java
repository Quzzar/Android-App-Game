package com.quzzar.game.Items.Items.Groups;

public class Necklace extends com.quzzar.game.Items.Item {

    private double defenseMod;
    private double speedMod;

    public Necklace(com.quzzar.game.Items.ItemType itemType, String displayName, double defenseMod, double speedMod) {
        super(itemType, displayName);

        this.defenseMod = defenseMod;
        this.speedMod = speedMod;
    }

    @Override
    public com.quzzar.game.Items.ItemGroup getItemGroup() {
        return com.quzzar.game.Items.ItemGroup.NECKLACE;
    }

    public double getDefenseMod() {
        return defenseMod;
    }

    public double getSpeedMod() {
        return speedMod;
    }
}
