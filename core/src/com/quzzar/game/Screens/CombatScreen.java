package com.quzzar.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Combat.CombatHandler;
import com.quzzar.game.Combat.Entities.Groups.Monster;
import com.quzzar.game.Combat.Entity;
import com.quzzar.game.Fonts.FontType;
import com.quzzar.game.GameMain;
import com.quzzar.game.Generation.ItemCreation;
import com.quzzar.game.Input;
import com.quzzar.game.Display.Announcement;
import com.quzzar.game.Display.Background;
import com.quzzar.game.Display.HealthBar;
import com.quzzar.game.Items.Item;
import com.quzzar.game.Objects.Button;
import com.quzzar.game.Objects.Font;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Utility;

public class CombatScreen implements Screen {

    private final GameMain game;
    private final Screen gameScreen;
    private final CombatScreen combatScreen = this;

    private SpriteBatch batch;

    private Image character;

    private Button hitBtn;
    private Button runBtn;
    private Button invBtn;

    private Font nameFont;

    private Entity enemy;

    private Background background;

    private HealthBar charHealthBar;
    private HealthBar enemyHealthBar;

    private Announcement rewardAnnouncement;


    public CombatScreen(final GameMain game, final Screen gameScreen, final Entity enemy) {

        this.game = game;
        this.gameScreen = gameScreen;
        this.enemy = enemy;

        this.batch = new SpriteBatch();

        rewardAnnouncement = new Announcement(100);

        charHealthBar = new HealthBar(new Location(0.1,0.9), 0.2);
        enemyHealthBar = new HealthBar(new Location(0.9,0.9), 0.2);

        nameFont = new Font(FontType.AK_SANS, 3f);

        background = new Background(new Texture("game/combat/combatBck.png"));

        this.invBtn = new Button(new Texture("game/invIcon.png"),new Texture("game/invIcon.png"),
                new Location(0.06),0.1);

        this.character = new Image(new Texture("game/combat/character.png"), new Location(0.2,0.3),0.6);

        this.hitBtn = new Button(new Texture("game/combat/hitBtn.png"),new Texture("game/combat/hitBtn.png"),
                new Location(0.7,0.1),0.2,0.1);
        this.runBtn = new Button(new Texture("game/combat/runBtn.png"),new Texture("game/combat/runBtn.png"),
                new Location(0.85,0.1),0.2,0.1);

        enemy.createImage(new Location(0.8,0.45));

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Input.begin();

                if(!enemy.isDead()){

                    if (hitBtn.containsLocation(Input.getTouchedLocation())){
                        if(enemy instanceof Monster){
                            Monster enemyMonster = (Monster) enemy;
                            CombatHandler.doCombat(enemyMonster);
                        }
                    }

                    if (runBtn.containsLocation(Input.getTouchedLocation())){
                        combatScreen.dispose();
                        game.setScreen(gameScreen);
                    }

                    if (invBtn.containsLocation(Input.getTouchedLocation())){
                        game.setScreen(new InventoryScreen(game, combatScreen));
                    }

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

        character.draw(batch);

        if(enemy.isDead()){

            boolean complete = enemy.drawFadeOut(batch);

            if(complete){

                if(rewardAnnouncement.isReady()){
                    Item rewardItem = ItemCreation.createCommonItem();
                    Player.getInventory().addItem(rewardItem);
                    rewardAnnouncement.setText(rewardItem.getDisplayName()+" Acquired");
                } else if(rewardAnnouncement.isFinished()){
                    combatScreen.dispose();
                    game.setScreen(gameScreen);
                }

                rewardAnnouncement.run(batch);
            }

        } else {
            if(((Monster) enemy).isPoisonous()){
                batch.setColor(Color.GREEN);
                enemy.draw(batch);
                batch.setColor(Color.WHITE);
            } else {
                enemy.draw(batch);
            }
        }

        nameFont.writeText(batch,enemy.getDisplayName(),new Location(0.65,0.95));

        if(!enemy.isDead()){
            hitBtn.draw(batch);
            runBtn.draw(batch);
        }

        invBtn.draw(batch);

        charHealthBar.draw(batch, Player.getStats().getHealth(), Player.getStats().getMaxHealth());
        enemyHealthBar.draw(batch, enemy.getHealth(), enemy.getMaxHealth());

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

