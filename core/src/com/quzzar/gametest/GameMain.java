package com.quzzar.gametest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture imgClick;

	boolean drawImage = false;

	@Override
	public void create () {

		batch = new SpriteBatch();
		img = new Texture("good_guy.png");

		imgClick = new Texture("Tolsimir.jpg");

		Image image = new Image(img);

		image.addListener( new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				drawImage = true;
			}
		});

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();


		if (drawImage) {
			batch.begin();
			batch.draw( imgClick, 0, 0, Gdx.graphics.getWidth(),
					Gdx.graphics.getHeight() );
			batch.end();
			drawImage = false;
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
