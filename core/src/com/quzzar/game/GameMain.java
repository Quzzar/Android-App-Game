package com.quzzar.game;

import com.badlogic.gdx.Game;
import com.quzzar.game.World.Map;
import com.quzzar.game.Screens.MenuScreen;

public class GameMain extends Game {

	public static GameMain instance;

	@Override
	public void create() {
		instance = this;
		Map.initialize();
		this.setScreen(new MenuScreen(this));
	}

}
