package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Display.SideMenu;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Utility;

public class InventoryScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    private SideMenu sideMenu;


    private Button mapBtn;

    private Button equipBtn;

    private Button settingsBtn;

    private Button exitToMainBtn;


    public InventoryScreen(final GameMain game) {

        this.game = game;

        this.batch = new SpriteBatch();

        final InventoryScreen inventoryScreen = this;

        this.sideMenu = new SideMenu(new Texture("game/inventory/equip_panel.png"));


        mapBtn = new Button(new Texture("game/inventory/mapButton.png"),new Texture("game/inventory/mapButton.png"),
                new Location(0.9,0.45),0.1,0.1);

        equipBtn = new Button(new Texture("game/inventory/equipBtn.png"),new Texture("game/inventory/equipBtn.png"),
                new Location(0.9,0.6),0.1,0.1);

        settingsBtn = new Button(new Texture("game/inventory/settingsBtn.png"),new Texture("game/inventory/settingsBtn.png"),
                new Location(0.9,0.75),0.1,0.1);

        exitToMainBtn = new Button(new Texture("game/inventory/exitBtn.png"),new Texture("game/inventory/exitBtn.png"),
                new Location(0.9,0.9),0.1,0.1);


        // Register this class as an input processor
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.setNone(false);

                if (mapBtn.containsLocation(Input.getTouchedLocation())){
                    inventoryScreen.dispose();
                    game.setScreen(new MapScreen(game));
                }

                if (equipBtn.containsLocation(Input.getTouchedLocation())){
                    inventoryScreen.dispose();
                    game.setScreen(new EquipScreen(game));
                }

                if (exitToMainBtn.containsLocation(Input.getTouchedLocation())){
                    inventoryScreen.dispose();
                    game.setScreen(new MenuScreen(game));
                }

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

        sideMenu.draw(batch);

        mapBtn.draw(batch);
        equipBtn.draw(batch);
        settingsBtn.draw(batch);
        exitToMainBtn.draw(batch);

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
