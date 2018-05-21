package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityMap;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Display.Background;
import com.quzzar.game.Inventory.Display.HealthBar;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Utility;

public class GameScreen implements Screen {

    private final GameMain game;
    private final GameScreen gameScreen = this;

    private SpriteBatch batch;

    private Button combatBtn;
    private Button invBtn;

    private Background background;

    private HealthBar charHealthBar;

    public GameScreen(final GameMain game){

        this.game = game;

        this.batch = new SpriteBatch();

        background = new Background(new Texture("misc/dirt_1.jpg"));

        charHealthBar = new HealthBar(new Location(0.1,0.9), 0.2);

        combatBtn = new Button(new Texture("game/combatBtn.png"),new Texture("game/combatBtn.png"),
                new Location(0.7,0.5),0.2);
        this.invBtn = new Button(new Texture("game/invIcon.png"),new Texture("game/invIcon.png"),
                new Location(0.06),0.1);


    }

    @Override
    public void show() {

        // Register this class as an input processor
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if (combatBtn.containsLocation(Input.getTouchedLocation())){
                    Utility.print("GEE",""+ EntityMap.mapSize());
                    game.setScreen(new CombatScreen(game, gameScreen, Monster.RANDOM()));
                }

                if (invBtn.containsLocation(Input.getTouchedLocation())){
                    game.setScreen(new InventoryScreen(game, gameScreen));
                }

                Input.end();
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {

        Player.update();

        Gdx.gl.glClearColor(18, 69, 91, 0.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);


        combatBtn.draw(batch);
        invBtn.draw(batch);

        charHealthBar.draw(batch, Player.getStats().getHealth(), Player.getStats().getMaxHealth());

        batch.end();

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {
        Utility.screenPause();
    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {
        Utility.screenExit(batch);
    }
}
