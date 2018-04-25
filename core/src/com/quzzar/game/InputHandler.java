package com.quzzar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Screens.GameScreen;

public class InputHandler implements InputProcessor {

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        GameScreen.player.movePlayer(getTouchedLocation().getX(), getTouchedLocation().getY());

        Utility.print("DEBUG-COORD", "<"+screenX+","+screenY+"> and <"
                +getTouchedLocation().getX()+","+getTouchedLocation().getY()+">");

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    public static Location getTouchedLocation(){
        /*
            The y-value here is different (being screenHeight - touch.y)
            this is due to the two differences in coordinate systems by
            libGDX graphics and Java (Android). The libGDX graphics system has
            the y-coordinate start from the bottom left, while Java graphics
            is usually from the top left.
        */
        return new Location(Gdx.input.getX(), GameMain.getScreenHeight() - Gdx.input.getY());
    }

}
