package com.quzzar.game.Items.Items;

public class HealthPotionGreater extends com.quzzar.game.Items.Items.Groups.Consumable {

    public HealthPotionGreater() {
        super(com.quzzar.game.Items.ItemType.HEALTH_POTION, "Greater Health Potion", 0, 0, 0, 0, 10);
    }

    @Override
    public com.quzzar.game.Items.ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public double getTimeDuration() {
        return super.getTimeDuration();
    }

    @Override
    public double getDamageBoost() {
        return super.getDamageBoost();
    }

    @Override
    public double getSpeedBoost() {
        return super.getSpeedBoost();
    }

    @Override
    public double getDefenseBoost() {
        return super.getDefenseBoost();
    }

    @Override
    public double getHealthIncrease() {
        return super.getHealthIncrease();
    }
}
