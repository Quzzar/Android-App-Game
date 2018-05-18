package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Fonts.FontType;
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
import com.quzzar.game.Objects.Font;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Objects.Player;
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


    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if (exitInfoBtn.containsLocation(Input.getTouchedLocation())){
                    itemInfoScreen.dispose();
                    game.setScreen(new EquipScreen(game, returningScreen));
                }

                Input.end();
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

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

