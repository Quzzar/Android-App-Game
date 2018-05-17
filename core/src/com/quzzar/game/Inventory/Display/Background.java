package com.quzzar.game.Inventory.Display;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;

public class Background {

    private Image backImage;

    public Background(Texture backTexture){
        this.backImage = new Image(backTexture, new Location(0.5,0.5),1,1);
    }

    public void draw(SpriteBatch batch){
        backImage.draw(batch);
    }

}
