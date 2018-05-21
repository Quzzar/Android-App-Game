package com.quzzar.game.Objects;

import com.quzzar.game.Utility;

import java.io.Serializable;

public class Location implements Serializable{

    private double x;
    private double y;

    public Location(double xScale, double yScale) {
        this.x = xScale;
        this.y = yScale;
    }

    public Location(double xyScale) {
        this.x = xyScale;
        this.y = Utility.adjustedHeightScale(xyScale,xyScale);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
