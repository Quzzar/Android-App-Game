package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.quzzar.game.Display.SideMenu;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.World.Map;
import com.quzzar.game.World.Region;
import com.quzzar.game.Objects.*;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Utility;

public class MapScreen implements Screen {

    private final GameMain game;
    private final MapScreen mapScreen = this;
    private final Screen returningScreen;

    private SpriteBatch batch;
    private ShapeRenderer renderer;

    private SideMenu sideMenu;

    private Button backBtn;

    private Region region;


    public MapScreen(final GameMain game, final Screen returningScreen) {

        this.game = game;
        this.returningScreen = returningScreen;

        this.batch = new SpriteBatch();
        this.renderer = new ShapeRenderer();

        this.region = Player.getStats().getPlayerLocation().getRegion();

        this.sideMenu = new SideMenu(region.getRegionTexture());

        backBtn = new Button(new Texture("misc/back_2.png"),new Texture("misc/back_2.png"),
                new Location(0.9,0.9),0.1,0.1);

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if (backBtn.containsLocation(Input.getTouchedLocation())){
                    mapScreen.dispose();
                    game.setScreen(new InventoryScreen(game, returningScreen));
                    return super.touchUp(screenX, screenY, pointer, button);
                }

                region.handleAreasPressed();
                if(Map.checkForRegionChange()){
                    mapScreen.dispose();
                    game.setScreen(new MapScreen(game, returningScreen));
                }
                Input.end();
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        sideMenu.draw(batch);

        batch.end();

        ///

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        region.drawPaths(renderer);

        renderer.end();

        ///

        batch.begin();

        region.drawAreas(batch, Color.GREEN);

        backBtn.draw(batch);

        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        Utility.screenPause();
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        renderer.dispose();
        Utility.screenExit(batch);
    }
}