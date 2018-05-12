package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Objects.*;
import com.quzzar.game.Utility;

public class MenuScreen implements Screen{

    private final GameMain game;

    private SpriteBatch batch;

    private final Button playBtn;
    private final Button exitBtn;
    private final Button settingsBtn;

    private final Image logoImg;

    public MenuScreen(final GameMain game){

        this.game = game;

        this.batch = new SpriteBatch();

        final MenuScreen menuScreen = this;

        logoImg = new Image(new Texture("menu/gamelogo.png"),
                new Location(0.5, 0.85),
                0.25,0.25);


        playBtn = new Button(new Texture("menu/play.png"), new Texture("menu/play_pressed.png"),
                new Location(0.5, 0.6),
                0.2, 0.2);

        settingsBtn = new Button(new Texture("menu/settings.png"), new Texture("menu/settings_pressed.png"),
                new Location(0.5, 0.4),
                0.15, 0.15);

        exitBtn = new Button(new Texture("menu/exit.png"), new Texture("menu/exit_pressed.png"),
                new Location(0.5, 0.2),
                0.2, 0.2);


        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.setNone(false);

                //Play game button
                if (playBtn.containsLocation(Input.getTouchedLocation())){
                    menuScreen.dispose();

                    Player.create();

                    game.setScreen(new GameScreen(game));
                }

                //Settings game button
                if (settingsBtn.containsLocation(Input.getTouchedLocation())){
                    menuScreen.dispose();
                    game.setScreen(new SettingsScreen(game));
                }

                //Exit button
                if (exitBtn.containsLocation(Input.getTouchedLocation())) {
                    menuScreen.dispose();
                    Gdx.app.exit();
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

        if(playBtn.containsLocation(Input.getTouchedLocation())){
            playBtn.drawPressed(batch);
        } else {
            playBtn.drawIdle(batch);
        }

        if(settingsBtn.containsLocation(Input.getTouchedLocation())){
            settingsBtn.drawPressed(batch);
        } else {
            settingsBtn.drawIdle(batch);
        }

        if(exitBtn.containsLocation(Input.getTouchedLocation())){
            exitBtn.drawPressed(batch);
        } else {
            exitBtn.drawIdle(batch);
        }

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
        Utility.screenDispose(batch);
    }


}
