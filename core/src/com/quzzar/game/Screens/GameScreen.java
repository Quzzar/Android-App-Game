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
import com.quzzar.game.Utility;

public class GameScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    private Button symbolBtn;


    public GameScreen(final GameMain game){

        this.game = game;

        this.batch = new SpriteBatch();

        final GameScreen gameScreen = this;


        symbolBtn = new Button(new Texture("game/symbol.png"),new Texture("game/symbol.png"),
                new Location(0.1,0.1),0.1,0.1);


        // Register this class as an input processor
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.setNone(false);

                //Play game button
                if (symbolBtn.containsLocation(Input.getTouchedLocation())){
                    gameScreen.dispose();
                    game.setScreen(new InventoryScreen(game));
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
    public void render(float delta) {

        Gdx.gl.glClearColor(18, 69, 91, 0.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        symbolBtn.draw(batch);

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
        Utility.screenDispose(batch);
    }
}
