package com.quzzar.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.quzzar.game.Combat.Entities.Monsters.Furry;
import com.quzzar.game.Combat.Entities.Monsters.Goblin;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Screens.CombatScreen;
import com.quzzar.game.Screens.InventoryScreen;
import com.quzzar.game.Screens.MapScreen;
import com.quzzar.game.Screens.MenuScreen;

public class GameMain extends Game {

	public static GameMain instance;

	@Override
	public void create() {
		instance = this;
		this.setScreen(new MenuScreen(this));
	}

}
