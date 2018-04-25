package com.quzzar.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.quzzar.game.Screens.MenuScreen;

public class GameMain extends Game {

	@Override
	public void create() {
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	public static int getScreenWidth(){
		return Gdx.graphics.getWidth();
	}

	public static int getScreenHeight(){
		return Gdx.graphics.getHeight();
	}

}
