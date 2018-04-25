package com.quzzar.gametest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.gametest.objects.Player;

public class GameMain extends ApplicationAdapter {

	private SpriteBatch batch;

    public static Player player;

	@Override
	public void create () {

		batch = new SpriteBatch();

		// Set player starting point to center of screen
        player = new Player(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2 );

        player.createPlayer();

        //Extra comment added ///

		// Register this class as an input processor
		Gdx.input.setInputProcessor(new InputHandler());
	}

	@Override
	public void render () {

		if(Gdx.input.isTouched())

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for(Sprite sprite : RenderingManager.getSpritesRendered()){
            batch.draw(sprite, sprite.getX(), sprite.getY());
        }
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
        RenderingManager.clearRender();
	}

}
