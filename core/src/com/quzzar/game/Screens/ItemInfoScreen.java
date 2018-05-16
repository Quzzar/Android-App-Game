package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Display.SideMenu;
import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Objects.Player;
import com.quzzar.game.Utility;

public class ItemInfoScreen implements Screen {

    private final GameMain game;

    private SpriteBatch batch;

    private Button exitInfoBtn;

    private BitmapFont font;

    private Item item;

    public ItemInfoScreen(final GameMain game, final Item item) {

        this.game = game;
        this.item = item;

        this.batch = new SpriteBatch();

        final ItemInfoScreen itemInfoScreen = this;

        font = new BitmapFont();

        item.createImage(new Location(0.7, 0.2), 0.2, Utility.adjustedHeightScale(0.2,0.2));

        this.exitInfoBtn = new Button(new Texture("game/inventory/info/exitInfo.png"),new Texture("game/inventory/info/exitInfo.png"),
                new Location(0.9,0.9),0.1,Utility.adjustedHeightScale(0.1,0.1));

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if (exitInfoBtn.containsLocation(Input.getTouchedLocation())){
                    itemInfoScreen.dispose();
                    game.setScreen(new EquipScreen(game));
                }

                Input.end();
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(18, 69, 91, 0.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.getData().setScale(6f);
        font.draw(batch,item.getDisplayName(),Input.xScaleToX(0.1),Input.yScaleToY(0.8));

        exitInfoBtn.draw(batch);
        item.getImage().draw(batch);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Utility.screenDispose(batch);
    }
}

