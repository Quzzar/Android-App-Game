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
import com.quzzar.game.Inventory.Display.Background;
import com.quzzar.game.Inventory.Display.SideMenu;
import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.Items.Groups.Armor;
import com.quzzar.game.Inventory.Items.Groups.Consumable;
import com.quzzar.game.Inventory.Items.Groups.Helmet;
import com.quzzar.game.Inventory.Items.Groups.Necklace;
import com.quzzar.game.Inventory.Items.Groups.Quest;
import com.quzzar.game.Inventory.Items.Groups.Ring;
import com.quzzar.game.Inventory.Items.Groups.Weapon;
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

    private Background background;

    public ItemInfoScreen(final GameMain game, final Item item) {

        this.game = game;
        this.item = item;

        this.batch = new SpriteBatch();

        final ItemInfoScreen itemInfoScreen = this;

        font = new BitmapFont();

        background = new Background(new Texture("misc/stone_3.jpg"));

        item.createImage(new Location(0.8, 0.5), 0.3, Utility.adjustedHeightScale(0.3,0.3));

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

        background.draw(batch);

        font.getData().setScale(8f);
        font.draw(batch,item.getDisplayName(),Input.xScaleToX(0.1),Input.yScaleToY(0.94));

        font.getData().setScale(4f);
        if(item.getItemGroup().equals(ItemGroup.RING)){
            Ring itemRing = (Ring) item;
            font.draw(batch,"Defense: "+itemRing.getDefenseMod(),Input.xScaleToX(0.1),Input.yScaleToY(0.8));
            font.draw(batch,"Speed: "+itemRing.getSpeedMod(),Input.xScaleToX(0.1),Input.yScaleToY(0.7));
        } else if(item.getItemGroup().equals(ItemGroup.NECKLACE)){
            Necklace itemNecklace = (Necklace) item;
            font.draw(batch,"Defense: "+itemNecklace.getDefenseMod(),Input.xScaleToX(0.1),Input.yScaleToY(0.8));
            font.draw(batch,"Speed: "+itemNecklace.getSpeedMod(),Input.xScaleToX(0.1),Input.yScaleToY(0.7));
        } else if(item.getItemGroup().equals(ItemGroup.HELMET)){
            Helmet itemHelmet = (Helmet) item;
            font.draw(batch,"Defense: "+itemHelmet.getDefenseMod(),Input.xScaleToX(0.1),Input.yScaleToY(0.8));
        } else if(item.getItemGroup().equals(ItemGroup.ARMOR)){
            Armor itemArmor = (Armor) item;
            font.draw(batch,"Defense: "+itemArmor.getDefenseMod(),Input.xScaleToX(0.1),Input.yScaleToY(0.8));
        } else if(item.getItemGroup().equals(ItemGroup.WEAPON)){
            Weapon itemWeapon = (Weapon) item;
            font.draw(batch,"Damage: "+itemWeapon.getDamageMod(),Input.xScaleToX(0.1),Input.yScaleToY(0.8));
            font.draw(batch,"Speed: "+itemWeapon.getSpeedMod(),Input.xScaleToX(0.1),Input.yScaleToY(0.7));
        } else if(item.getItemGroup().equals(ItemGroup.CONSUMABLE)){
            Consumable itemConsumable = (Consumable) item;
            font.draw(batch,"Damage Boost: "+itemConsumable.getDamageBoost(),Input.xScaleToX(0.1),Input.yScaleToY(0.8));
            font.draw(batch,"Defense Boost: "+itemConsumable.getDefenseBoost(),Input.xScaleToX(0.1),Input.yScaleToY(0.7));
            font.draw(batch,"Speed Boost: "+itemConsumable.getSpeedBoost(),Input.xScaleToX(0.1),Input.yScaleToY(0.6));
            font.draw(batch,"Health Increase: "+itemConsumable.getHealthIncrease(),Input.xScaleToX(0.1),Input.yScaleToY(0.5));
            font.draw(batch,"Time Duration: "+itemConsumable.getTimeDuration(),Input.xScaleToX(0.1),Input.yScaleToY(0.4));
        } else if(item.getItemGroup().equals(ItemGroup.QUEST)){
            Quest itemQuest = (Quest) item;
            font.draw(batch,"Owner Name: "+itemQuest.getOwnerName(),Input.xScaleToX(0.1),Input.yScaleToY(0.8));
            font.draw(batch,"Quest Title: "+itemQuest.getQuestTitle(),Input.xScaleToX(0.1),Input.yScaleToY(0.7));
        }

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

