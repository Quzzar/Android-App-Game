package com.quzzar.game.Objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.quzzar.game.Input;

public class Line {

    private Location locationA;
    private Location locationB;

    public Line(Location locationA, Location locationB){

        this.locationA = locationA;
        this.locationB = locationB;

    }

    public Location getLocationA() {
        return locationA;
    }

    public Location getLocationB() {
        return locationB;
    }

    public void draw(ShapeRenderer renderer, float width){
        renderer.rectLine((float)Input.xScaleToX(locationA.getX()), (float)Input.yScaleToY(locationA.getY()),
                (float)Input.xScaleToX(locationB.getX()),(float)Input.yScaleToY(locationB.getY()),width, Color.BLACK,Color.BLACK);
    }

}
