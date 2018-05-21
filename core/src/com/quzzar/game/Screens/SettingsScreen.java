package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Display.Background;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Utility;

public class SettingsScreen implements Screen {

    private final GameMain game;
    private final SettingsScreen settingsScreen = this;
    private final Screen returningScreen;

    private SpriteBatch batch;

    private Button backBtn;

    private Background background;

    public SettingsScreen(final GameMain game, final Screen returningScreen) {

        this.game = game;
        this.returningScreen = returningScreen;

        this.batch = new SpriteBatch();

        this.background = new Background(new Texture("misc/stone_2.jpg"));

        backBtn = new Button(new Texture("menu/settings/toMain.png"),new Texture("menu/settings/toMain.png"),
                new Location(0.1,0.9),0.1,0.1);

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if (backBtn.containsLocation(Input.getTouchedLocation())){
                    settingsScreen.dispose();
                    game.setScreen(returningScreen);
                }

                Input.end();
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(18, 69, 91, 0.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);

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

