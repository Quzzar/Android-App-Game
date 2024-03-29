package com.quzzar.game.Combat;

public class Skills {

    private double damage;
    private double healed;
    private double statDecrease;
    private double statIncrease;

    public Skills(String displayName, double healAmount, double damageAmount, double statDecrease, double statIncrease) {

        this.damage = damageAmount;
        this.healed = healAmount;
        this.statDecrease = statDecrease;
        this.statIncrease = statIncrease;

    }
    public double getDamage() { return damage; }

    public double getHealed() { return healed; }

    public double getStatDecrease() { return statDecrease; }

    public double getStatIncrease() { return statIncrease; }
}