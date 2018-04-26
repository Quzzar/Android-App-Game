package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.RenderingManager;
import com.quzzar.game.InputHandler;

public class GameScreen implements Screen {

    private final GameMain game;

    //public static Player player;

    private SpriteBatch batch;

    public GameScreen(final GameMain game){

        this.game = game;

        this.batch = new SpriteBatch();

        // Set player starting point to center of screen
        //player = new Player(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2 );

        //player.createPlayer();

        // Register this class as an input processor
        Gdx.input.setInputProcessor(new InputHandler());

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(Sprite sprite : RenderingManager.getSpritesRendered()){
            batch.draw(sprite, sprite.getX(), sprite.getY());
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
        RenderingManager.clearRender();
    }
}
