package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.EntityHandler;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Display.Background;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Objects.Player;
import com.quzzar.game.Utility;

public class GameScreen implements Screen {

    private final GameMain game;
    private final GameScreen gameScreen = this;

    private SpriteBatch batch;

    private Button combatBtn;
    private Button symbolBtn;

    private Background background;

    public GameScreen(final GameMain game){

        this.game = game;

        this.batch = new SpriteBatch();

        background = new Background(new Texture("misc/dirt_1.jpg"));

        combatBtn = new Button(new Texture("game/combatBtn.png"),new Texture("game/combatBtn.png"),
                new Location(0.7,0.5),0.2, 0.2);
        symbolBtn = new Button(new Texture("game/symbol.png"),new Texture("game/symbol.png"),
                new Location(0.1,0.1),0.1);


    }

    @Override
    public void show() {

        // Register this class as an input processor
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if (combatBtn.containsLocation(Input.getTouchedLocation())){
                    Utility.print("GEE",""+ EntityHandler.mapSize());
                    game.setScreen(new CombatScreen(game, gameScreen, Monster.RANDOM()));
                }

                if (symbolBtn.containsLocation(Input.getTouchedLocation())){
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
        symbolBtn.draw(batch);

        batch.end();

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
        Utility.screenDispose(batch);
    }
}
