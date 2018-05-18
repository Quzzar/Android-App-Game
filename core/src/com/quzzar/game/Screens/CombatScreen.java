package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.Entity;
import com.quzzar.game.Fonts.FontType;
import com.quzzar.game.GameMain;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Display.Background;
import com.quzzar.game.Inventory.Display.HealthBar;
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

import java.util.ArrayList;
import java.util.List;

public class CombatScreen implements Screen {

    private final GameMain game;
    private final Screen gameScreen;
    private final CombatScreen combatScreen = this;

    private SpriteBatch batch;

    private Image character;

    private Button hitBtn;
    private Button runBtn;

    private Button symbolBtn;

    private Font nameFont;

    private Entity enemy;

    private Background background;

    private HealthBar charHealthBar;
    private HealthBar enemyHealthBar;


    public CombatScreen(final GameMain game, final Screen gameScreen, final Entity enemy) {

        this.game = game;
        this.gameScreen = gameScreen;
        this.enemy = enemy;

        this.batch = new SpriteBatch();

        charHealthBar = new HealthBar(new Location(0.1,0.9), 0.2);
        enemyHealthBar = new HealthBar(new Location(0.9,0.9), 0.2);

        nameFont = new Font(FontType.AK_SANS, 3f);

        background = new Background(new Texture("game/combat/combatBck.png"));

        this.character = new Image(new Texture("game/combat/character.png"), new Location(0.2,0.4),0.6);

        this.hitBtn = new Button(new Texture("game/combat/hitBtn.png"),new Texture("game/combat/hitBtn.png"),
                new Location(0.7,0.1),0.2);
        this.runBtn = new Button(new Texture("game/combat/runBtn.png"),new Texture("game/combat/runBtn.png"),
                new Location(0.85,0.1),0.2);

        this.symbolBtn = new Button(new Texture("game/symbol.png"),new Texture("game/symbol.png"),
                new Location(0.1,0.1),0.1);

        enemy.createImage(new Location(0.8,0.45));

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if (hitBtn.containsLocation(Input.getTouchedLocation())){
                    Utility.print("HIT","Player Hit for "+ Player.getDamage());
                    enemy.hurt(Player.getDamage());
                    if(enemy instanceof Monster){
                        Monster enemyMonster = (Monster) enemy;
                        Utility.print("HIT",enemy.getDisplayName()+" Hit for "+ enemyMonster.getDamage());
                        Player.hurt(enemyMonster.getDamage());
                    }
                }

                if (runBtn.containsLocation(Input.getTouchedLocation())){
                    combatScreen.dispose();
                    game.setScreen(gameScreen);
                }

                if (symbolBtn.containsLocation(Input.getTouchedLocation())){
                    game.setScreen(new InventoryScreen(game, combatScreen));
                }

                Input.end();
                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {

        Player.update();

        if(enemy.getHealth()<=0){
            Utility.print("HIT","You defeated the "+enemy.getDisplayName()+"!");
            combatScreen.dispose();
            game.setScreen(gameScreen);
        }

        Gdx.gl.glClearColor(18, 69, 91, 0.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);

        character.draw(batch);
        enemy.draw(batch);

        nameFont.writeText(batch,enemy.getDisplayName(),new Location(0.7,0.95));

        hitBtn.draw(batch);
        runBtn.draw(batch);

        symbolBtn.draw(batch);

        charHealthBar.draw(batch, Player.getMaxHealth(), Player.getHealth());
        enemyHealthBar.draw(batch, enemy.getMaxHealth(), enemy.getHealth());

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

