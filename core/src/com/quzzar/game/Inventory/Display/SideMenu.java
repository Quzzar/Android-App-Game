package com.quzzar.game.Inventory.Display;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;

public class SideMenu {

    private Image backPanel;

    private Image leftBackground;

    private Button itemsBtn;

    public SideMenu(Texture leftBackTex){

        backPanel = new Image(new Texture("game/inventory/back_panel.jpg"),
                new Location(0.85,0.5),
                0.3,1);



        leftBackground = new Image(leftBackTex,
                new Location(0.35,0.5),
                0.7,1);

    }

    public void draw(SpriteBatch batch){
        leftBackground.draw(batch);
        backPanel.draw(batch);
    }

    public Image getLeftBackground() {
        return leftBackground;
    }

    public Image getBackPanel() {
        return backPanel;
    }
}
