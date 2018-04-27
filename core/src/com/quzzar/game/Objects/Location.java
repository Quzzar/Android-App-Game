package com.quzzar.game.Objects;

public class Location {

    private double x;
    private double y;

    public Location(double xScale, double yScale) {
        this.x = xScale;
        this.y = yScale;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
