package com.quzzar.game;

import com.badlogic.gdx.Game;
import com.quzzar.game.Screens.GameScreen;

public class GameMain extends Game {

	@Override
	public void create() {
		this.setScreen(new GameScreen());
	}
}
