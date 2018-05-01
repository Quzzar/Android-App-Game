package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Inventory.Display.InventoryDisplay;

public class EquipScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    private InventoryDisplay inventoryDisplay;

    public EquipScreen(final GameMain game) {

        this.game = game;

        this.batch = new SpriteBatch();

        this.inventoryDisplay = new InventoryDisplay();

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

    }

}
