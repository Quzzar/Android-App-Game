package com.quzzar.game.World;

import com.badlogic.gdx.graphics.Texture;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;

public class Area {

    private Image areaImage;
    private boolean isExit;


    public Area(double xScale, double yScale, boolean isExit){

        if(isExit){
            this.areaImage = new Image(new Texture("game/map/area_exit_icon.png"),new Location(xScale,yScale),0.05);
        } else {
            this.areaImage = new Image(new Texture("game/map/area_icon.png"),new Location(xScale,yScale),0.05);
        }
        this.isExit = isExit;

    }

    public Area(double xScale, double yScale){

        this.areaImage = new Image(new Texture("game/map/area_icon.png"),new Location(xScale,yScale),0.05);
        this.isExit = false;

    }

    public Image getImage() {
        return areaImage;
    }

    public boolean isExit() {
        return isExit;
    }
}
