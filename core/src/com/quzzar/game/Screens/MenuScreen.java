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

    private final Image logoImg;

    public MenuScreen(final GameMain game){

        this.game = game;

        this.batch = new SpriteBatch();

        final MenuScreen menuScreen = this;

        logoImg = new Image(new Texture("/mainMenu/gamelogo.jpg"),
                new Location(0.5, 0.8),
                0.2,0.2);


        playBtn = new Button(new Texture("/mainMenu/play.png"), new Texture("/mainMenu/play.png"),
                new Location(0.5, 0.65),
                0.2, 0.2);


        exitBtn = new Button(new Texture("/mainMenu/exit.png"), new Texture("/mainMenu/exit.png"),
                new Location(0.5, 0.4),
                0.2, 0.2);


        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                //Play game button
                if (playBtn.containsLocation(Input.getTouchedLocation())){
                    menuScreen.dispose();

                    Player.create();

                    game.setScreen(new GameScreen(game));
                }

                //Exit button
                if (exitBtn.containsLocation(Input.getTouchedLocation())) {
                    menuScreen.dispose();
                    Gdx.app.exit();
                }

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

        if(exitBtn.containsLocation(Input.getTouchedLocation())){
            exitBtn.drawPressed(batch);
        } else {
            exitBtn.drawIdle(batch);
        }

        if(playBtn.containsLocation(Input.getTouchedLocation())){
            playBtn.drawPressed(batch);
        } else {
            playBtn.drawIdle(batch);
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
        Gdx.input.setInputProcessor(null);
    }


}
