package com.quzzar.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.Items.Axe;
import com.quzzar.game.Inventory.Items.HealthPotion;

public class InventoryScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    public InventoryScreen(final GameMain game) {

        this.game = game;

        this.batch = new SpriteBatch();



    }

    @Override
    public void show() {

        HealthPotion healthPot = new HealthPotion(1, 0, 0, 0, 0, 5);

        healthPot.getDamageBoost();


    }

    @Override
    public void render(float delta) {

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
