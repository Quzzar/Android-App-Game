package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.quzzar.game.Fonts.FontType;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Display.Background;
import com.quzzar.game.Items.Item;
import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.Items.Groups.Armor;
import com.quzzar.game.Items.Items.Groups.Consumable;
import com.quzzar.game.Items.Items.Groups.Helmet;
import com.quzzar.game.Items.Items.Groups.Necklace;
import com.quzzar.game.Items.Items.Groups.Quest;
import com.quzzar.game.Items.Items.Groups.Ring;
import com.quzzar.game.Items.Items.Groups.Weapon;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Font;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Utility;

public class ItemInfoScreen implements Screen {

    private final GameMain game;
    private final ItemInfoScreen itemInfoScreen = this;
    private final Screen returningScreen;

    private SpriteBatch batch;

    private Button exitInfoBtn;

    private Font titleFont;
    private Font textFont;

    private Item item;

    private Background background;

    private Button consumeBtn;
    private Button destroyBtn;

    public ItemInfoScreen(final GameMain game, final Screen returningScreen, final Item item) {

        this.game = game;
        this.returningScreen = returningScreen;
        this.item = item;

        this.batch = new SpriteBatch();

        titleFont = new Font(FontType.AK_SANS, 8f);
        textFont = new Font(FontType.AK_SANS, 4f);

        background = new Background(new Texture("misc/stone_3.jpg"));

        item.createImage(new Location(0.8, 0.5), 0.3, Utility.adjustedHeightScale(0.3,0.3));

        this.exitInfoBtn = new Button(new Texture("game/inventory/info/exitInfo.png"),new Texture("game/inventory/info/exitInfo.png"),
                new Location(0.9,0.9),0.1,Utility.adjustedHeightScale(0.1,0.1));


        this.consumeBtn = new Button(new Texture("game/inventory/info/consumeBtn.png"),new Texture("game/inventory/info/consumeBtn.png"),
                new Location(0.7,0.1),0.15,0.15);
        this.destroyBtn = new Button(new Texture("game/inventory/info/destroyBtn.png"),new Texture("game/inventory/info/destroyBtn.png"),
                new Location(0.9,0.1),0.15,0.15);


    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new GestureDetector(20, 0.4f, 0.4f, 0.15f,
                new GestureDetector.GestureListener() {
                    @Override
                    public boolean touchDown(float x, float y, int pointer, int button) {
                        Input.begin();

                        if (exitInfoBtn.containsLocation(Input.getTouchedLocation())){
                            itemInfoScreen.dispose();
                            game.setScreen(new EquipScreen(game, returningScreen));
                        }

                        // Consume button pressed
                        if(item.getItemGroup().equals(ItemGroup.CONSUMABLE)){

                            if (consumeBtn.containsLocation(Input.getTouchedLocation())){

                                Player.heal(((Consumable)item).getHealthIncrease());
                                Player.getInventory().removeItem(item);

                                itemInfoScreen.dispose();
                                game.setScreen(new EquipScreen(game, returningScreen));
                            }

                        }

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

                        // Destroy button long press
                        if (destroyBtn.containsLocation(Input.getTouchedLocation())){

                            Player.getInventory().removeItem(item);

                            itemInfoScreen.dispose();
                            game.setScreen(new EquipScreen(game, returningScreen));
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

        Gdx.gl.glClearColor(18, 69, 91, 0.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);

        titleFont.writeText(batch,item.getDisplayName(),new Location(0.1,0.94));

        double xVal = 0.1;
        double yVal = 0.7;
        double increment = 0.12;

        if(item.getItemGroup().equals(ItemGroup.RING)){
            Ring itemRing = (Ring) item;
            textFont.writeText(batch,"Defense: "+itemRing.getDefenseMod(),new Location(xVal,yVal-increment*0));
            textFont.writeText(batch,"Speed: "+itemRing.getSpeedMod(),new Location(xVal,yVal-increment*1));
        } else if(item.getItemGroup().equals(ItemGroup.NECKLACE)){
            Necklace itemNecklace = (Necklace) item;
            textFont.writeText(batch,"Defense: "+itemNecklace.getDefenseMod(),new Location(xVal,yVal-increment*0));
            textFont.writeText(batch,"Speed: "+itemNecklace.getSpeedMod(),new Location(xVal,yVal-increment*1));
        } else if(item.getItemGroup().equals(ItemGroup.HELMET)){
            Helmet itemHelmet = (Helmet) item;
            textFont.writeText(batch,"Defense: "+itemHelmet.getDefenseMod(),new Location(xVal,yVal-increment*0));
        } else if(item.getItemGroup().equals(ItemGroup.ARMOR)){
            Armor itemArmor = (Armor) item;
            textFont.writeText(batch,"Defense: "+itemArmor.getDefenseMod(),new Location(xVal,yVal-increment*0));
        } else if(item.getItemGroup().equals(ItemGroup.WEAPON)){
            Weapon itemWeapon = (Weapon) item;
            textFont.writeText(batch,"Damage: "+itemWeapon.getDamageMod(),new Location(xVal,yVal-increment*0));
            textFont.writeText(batch,"Speed: "+itemWeapon.getSpeedMod(),new Location(xVal,yVal-increment*1));
        } else if(item.getItemGroup().equals(ItemGroup.CONSUMABLE)){
            Consumable itemConsumable = (Consumable) item;
            textFont.writeText(batch,"Damage Boost: "+itemConsumable.getDamageBoost(),new Location(xVal,yVal-increment*0));
            textFont.writeText(batch,"Defense Boost: "+itemConsumable.getDefenseBoost(),new Location(xVal,yVal-increment*1));
            textFont.writeText(batch,"Speed Boost: "+itemConsumable.getSpeedBoost(),new Location(xVal,yVal-increment*2));
            textFont.writeText(batch,"Health Increase: "+itemConsumable.getHealthIncrease(),new Location(xVal,yVal-increment*3));
            textFont.writeText(batch,"Time Duration: "+itemConsumable.getTimeDuration(),new Location(xVal,yVal-increment*4));
        } else if(item.getItemGroup().equals(ItemGroup.QUEST)){
            Quest itemQuest = (Quest) item;
            textFont.writeText(batch,"Owner Name: "+itemQuest.getOwnerName(),new Location(xVal,yVal-increment*0));
            textFont.writeText(batch,"Quest Title: "+itemQuest.getQuestTitle(),new Location(xVal,yVal-increment*1));
        }


        // Add consume button
        if(item.getItemGroup().equals(ItemGroup.CONSUMABLE)){
            consumeBtn.draw(batch);
        }

        destroyBtn.draw(batch);


        exitInfoBtn.draw(batch);
        item.getImage().draw(batch);
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

