package com.quzzar.game;

import com.badlogic.gdx.Gdx;
import com.quzzar.game.Objects.Location;

public class Input {

    public static Location getTouchedLocation(){
        /*
            The y-value here is different (being screenHeight - touch.y)
            this is due to the two differences in coordinate systems by
            libGDX graphics and Java (Android). The libGDX graphics system has
            the y-coordinate start from the bottom left, while Java graphics
            is usually from the top left.

            Update: Location now is set to contain a scaled value (0.0-1.0),
                the values have been adjusted to return scales.
        */

        return new Location(Gdx.input.getX()*1.0/Gdx.graphics.getWidth(),
                (Gdx.graphics.getHeight() - Gdx.input.getY())*1.0/Gdx.graphics.getHeight());
    }

}
