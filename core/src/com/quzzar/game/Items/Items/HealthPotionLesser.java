package com.quzzar.game.Items.Items;

public class HealthPotionLesser extends com.quzzar.game.Items.Items.Groups.Consumable {

    public HealthPotionLesser() {
        super(com.quzzar.game.Items.ItemType.HEALTH_POTION, "Lesser Health Potion", 0, 0, 0, 0, 3);
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
