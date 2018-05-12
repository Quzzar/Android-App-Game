package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Display.InventoryDisplay;
import com.quzzar.game.Utility;

public class EquipScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    private InventoryDisplay inventoryDisplay;

    public EquipScreen(final GameMain game) {

        this.game = game;

        this.batch = new SpriteBatch();

        this.inventoryDisplay = new InventoryDisplay();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.setNone(false);

                inventoryDisplay.checkImagesPressed();
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

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        inventoryDisplay.draw(batch, Color.RED);

        batch.end();

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
