package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Location;

public class GameScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    private Button symbolBtn;


    public GameScreen(final GameMain game){

        this.game = game;

        this.batch = new SpriteBatch();

        final GameScreen gameScreen = this;


        symbolBtn = new Button(new Texture("symbol.png"),new Texture("badlogic.jpg"),
                new Location(0.1,0.1),0.1,0.1);

        // Register this class as an input processor
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                //Play game button
                if (symbolBtn.containsLocation(Input.getTouchedLocation())){
                    gameScreen.dispose();
                    game.setScreen(new InventoryScreen(game));
                }

                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        if(symbolBtn.containsLocation(Input.getTouchedLocation())){
            symbolBtn.drawPressed(batch);
        } else {
            symbolBtn.drawIdle(batch);
        }

        batch.end();

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
