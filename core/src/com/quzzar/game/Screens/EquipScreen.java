package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Display.InventoryDisplay;
import com.quzzar.game.Items.Item;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Utility;

public class EquipScreen implements Screen {

    private final GameMain game;
    private final EquipScreen equipScreen = this;
    private final Screen returningScreen;

    private SpriteBatch batch;

    private InventoryDisplay inventoryDisplay;

    private Button backBtn;

    public EquipScreen(final GameMain game, final Screen returningScreen) {

        this.game = game;
        this.returningScreen = returningScreen;

        this.batch = new SpriteBatch();

        this.inventoryDisplay = new InventoryDisplay();

        this.backBtn = new Button(new Texture("misc/back_1.png"),new Texture("misc/back_1.png"),
                new Location(0.1,0.9),0.1,Utility.adjustedHeightScale(0.1,0.1));

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new GestureDetector(20, 0.4f, 0.6f, 0.15f,
                new GestureDetector.GestureListener() {
                    @Override
                    public boolean touchDown(float x, float y, int pointer, int button) {
                        Input.begin();

                        if (backBtn.containsLocation(Input.getTouchedLocation())){
                            equipScreen.dispose();
                            game.setScreen(new InventoryScreen(game, returningScreen));
                            return false;
                        }

                        inventoryDisplay.handleItemsPressed();
                        Input.end();
                        return false;
                    }
                    @Override
                    public boolean tap(float x, float y, int count, int button) {
                        return false;
                    }
                    @Override
                    public boolean longPress(float x, float y) {
                        Input.begin();

                        for(Item item : Player.getInventory().getFullContents()){
                            if(item.getImage().containsLocation(Input.getTouchedLocation())){
                                equipScreen.dispose();
                                game.setScreen(new ItemInfoScreen(game, returningScreen, item));
                                return false;
                            }
                        }

                        Input.end();
                        return false;
                    }
                    @Override
                    public boolean fling(float velocityX, float velocityY, int button) {
                        return false;
                    }
                    @Override
                    public boolean pan(float x, float y, float deltaX, float deltaY) {
                        return false;
                    }
                    @Override
                    public boolean panStop(float x, float y, int pointer, int button) {
                        return false;
                    }
                    @Override
                    public boolean zoom(float initialDistance, float distance) {
                        return false;
                    }
                    @Override
                    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
                        return false;
                    }
                    @Override
                    public void pinchStop() {

                    }
                }));

    }

    @Override
    public void render(float delta) {

        // To Keep the player's damage, speed, and defense updated
        Player.update();

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        inventoryDisplay.draw(batch, Color.RED);

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
        Utility.screenExit(batch);
    }

}
