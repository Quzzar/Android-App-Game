package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.DataHandling.DataUtility;
import com.quzzar.game.DataHandling.LoadData;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Display.Background;
import com.quzzar.game.Objects.*;

public class MenuScreen implements Screen{

    private final GameMain game;
    private final MenuScreen menuScreen = this;

    private SpriteBatch batch;

    private final Button playBtn;
    private final Button settingsBtn;

    private final Image logoImg;

    private Background mainBackground;

    public MenuScreen(final GameMain game){

        this.game = game;

        this.batch = new SpriteBatch();

        logoImg = new Image(new Texture("menu/game_logo.png"),
                new Location(0.5, 0.88),
                0.35,0.3);

        if(DataUtility.hasSave()){
            playBtn = new Button(new Texture("menu/continueBtn.png"), new Texture("menu/continueBtn.png"),
                    new Location(0.5, 0.66),
                    0.2, 0.17);
        } else {
            playBtn = new Button(new Texture("menu/beginBtn.png"), new Texture("menu/beginBtn.png"),
                    new Location(0.5, 0.66),
                    0.2, 0.17);
        }

        settingsBtn = new Button(new Texture("menu/settingsBtn.png"), new Texture("menu/settingsBtn.png"),
                new Location(0.5, 0.5),
                0.15, 0.15);

        mainBackground = new Background(new Texture("menu/menuBackground.png"));

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                //Play game button
                if (playBtn.containsLocation(Input.getTouchedLocation())){
                    menuScreen.dispose();

                    LoadData.load();

                    game.setScreen(new GameScreen(game));
                }

                //Settings game button
                if (settingsBtn.containsLocation(Input.getTouchedLocation())){
                    game.setScreen(new SettingsScreen(game, menuScreen));
                }

                Input.end();
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        mainBackground.draw(batch);

        playBtn.draw(batch);

        settingsBtn.draw(batch);

        logoImg.draw(batch);

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
        /* Don't save player inventory here, as it's null */
        Input.end();
        batch.dispose();
        Gdx.input.setInputProcessor(null);
    }


}
