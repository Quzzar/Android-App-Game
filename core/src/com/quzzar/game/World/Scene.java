package com.quzzar.game.World;

import com.badlogic.gdx.graphics.Texture;
import com.quzzar.game.Display.Background;

public class Scene {

    private Background background;

    public Scene(Texture backTexture){
        background = new Background(backTexture);
    }


}
