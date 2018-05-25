package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Display.EquipmentDisplay;
import com.quzzar.game.Display.SideMenu;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Utility;

public class InventoryScreen implements Screen {

    private final GameMain game;
    private final InventoryScreen inventoryScreen = this;
    private final Screen returningScreen;

    private SpriteBatch batch;

    private SideMenu sideMenu;

    private EquipmentDisplay equipmentDisplay;


    private Button mapBtn;

    private Button equipBtn;

    private Button settingsBtn;

    private Button exitToMainBtn;

    private Button backBtn;

    public InventoryScreen(final GameMain game, final Screen returningScreen) {

        this.game = game;
        this.returningScreen = returningScreen;

        this.batch = new SpriteBatch();

        this.sideMenu = new SideMenu(new Texture("misc/stone_1.jpg"));

        this.equipmentDisplay = new EquipmentDisplay();

        mapBtn = new Button(new Texture("game/inventory/mapButton.png"),new Texture("game/inventory/mapButton.png"),
                new Location(0.9,0.43),0.1,0.1);

        equipBtn = new Button(new Texture("game/inventory/equipIcon.png"),new Texture("game/inventory/equipIcon.png"),
                new Location(0.9,0.6),0.1);

        settingsBtn = new Button(new Texture("game/inventory/settingsBtn.png"),new Texture("game/inventory/settingsBtn.png"),
                new Location(0.77,0.1),0.1,0.1);

        exitToMainBtn = new Button(new Texture("game/inventory/exitBtn.png"),new Texture("game/inventory/exitBtn.png"),
                new Location(0.9,0.1),0.1,0.1);

        this.backBtn = new Button(new Texture("misc/back_1.png"),new Texture("misc/back_1.png"),
                new Location(0.1,0.9),0.1,Utility.adjustedHeightScale(0.1,0.1));

    }

    @Override
    public void show() {

        // Register this class as an input processor
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if (mapBtn.containsLocation(Input.getTouchedLocation())){
                    inventoryScreen.dispose();
                    game.setScreen(new MapScreen(game, returningScreen));
                }

                if (equipBtn.containsLocation(Input.getTouchedLocation())){
                    inventoryScreen.dispose();
                    game.setScreen(new EquipScreen(game, returningScreen));
                }

                if (backBtn.containsLocation(Input.getTouchedLocation())){
                    inventoryScreen.dispose();
                    game.setScreen(returningScreen);
                }

                if (settingsBtn.containsLocation(Input.getTouchedLocation())){
                    game.setScreen(new SettingsScreen(game, inventoryScreen));
                }

                if (exitToMainBtn.containsLocation(Input.getTouchedLocation())){
                    inventoryScreen.dispose();
                    returningScreen.dispose();
                    game.setScreen(new MenuScreen(game));
                }

                Input.end();
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {
        // To Keep the player's damage, speed, and defense updated
        Player.update();

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        sideMenu.draw(batch);
        equipmentDisplay.draw(batch);

        mapBtn.draw(batch);
        equipBtn.draw(batch);
        settingsBtn.draw(batch);
        exitToMainBtn.draw(batch);
        backBtn.draw(batch);

        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        Utility.screenPause();
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Utility.screenExit(batch);
    }
}
