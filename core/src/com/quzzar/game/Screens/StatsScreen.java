package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Display.SideMenu;
import com.quzzar.game.Utility;

public class StatsScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    private SideMenu sideMenu;

    public StatsScreen(final GameMain game) {

        this.game = game;

        this.batch = new SpriteBatch();

        sideMenu = new SideMenu(new Texture("misc/Tolsimir.jpg"));

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.setNone(false);

                return super.touchUp(screenX, screenY, pointer, button);
            }
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                Input.setNone(true);
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        sideMenu.draw(batch);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Utility.screenDispose(batch);
    }
}

