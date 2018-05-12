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

public class MapScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    private final Image mapImg;

    private final Button arrowBtn;

    public MapScreen(final GameMain game) {

        this.game = game;

        this.batch = new SpriteBatch();

        final MapScreen mapScreen = this;

        mapImg = new Image(new Texture("mapImg.jpg"),
                new Location(0.5, 0.5),
                0.2,0.4);

        arrowBtn = new Button(new Texture("mapArrow.png"), new Texture("mapArrow.png"),
                new Location(0.5, 0.3),
                0.1, 0.3);

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                //Change map area button
                //Currently has same function as play button
                if (arrowBtn.containsLocation(Input.getTouchedLocation())){
                    mapScreen.dispose();
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

        if(arrowBtn.containsLocation(Input.getTouchedLocation())){
            arrowBtn.drawPressed(batch);
        } else {
            arrowBtn.drawIdle(batch);
        }

        mapImg.draw(batch);

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