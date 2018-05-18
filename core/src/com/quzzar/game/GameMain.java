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

	@Override
	public void create() {
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}


}
