package com.quzzar.game.Display;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Fonts.FontType;
import com.quzzar.game.Player.Inventory;
import com.quzzar.game.Objects.Font;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Player.Stats;
import com.quzzar.game.Utility;

public class EquipmentDisplay {

    private Image firstHandImage;
    private Image secondHandImage;
    private Image helmetImage;
    private Image armorImage;
    private Image necklaceImage;
    private Image firstRingImage;
    private Image secondRingImage;

    private Inventory inventory = Player.getInventory();

    private Font statsFont;

    private com.quzzar.game.Display.HealthBar healthBar;

    private Stats stats;

    public EquipmentDisplay(){

        stats = Player.getStats();

        healthBar = new com.quzzar.game.Display.HealthBar(new Location(0.56,0.9),0.22);


        firstHandImage = new Image(new Texture("game/inventory/equipment/sword_left_icon.png"),
                new Location(0.1, 0.5),0.15, Utility.adjustedHeightScale(0.15,0.15));

        secondHandImage = new Image(new Texture("game/inventory/equipment/sword_right_icon.png"),
                new Location(0.6, 0.5),0.15, Utility.adjustedHeightScale(0.15,0.15));

        armorImage = new Image(new Texture("game/inventory/equipment/chest_icon.png"),
                new Location(0.35, 0.3),0.2, Utility.adjustedHeightScale(0.2,0.2));

        helmetImage = new Image(new Texture("game/inventory/equipment/helmet_icon.png"),
                new Location(0.35, 0.85),0.15, Utility.adjustedHeightScale(0.15,0.15));

        necklaceImage = new Image(new Texture("game/inventory/equipment/necklace_icon.png"),
                new Location(0.35, 0.6),0.1, Utility.adjustedHeightScale(0.1,0.1));

        firstRingImage = new Image(new Texture("game/inventory/equipment/ring_icon.png"),
                new Location(0.18, 0.27),0.1, Utility.adjustedHeightScale(0.1,0.1));

        secondRingImage = new Image(new Texture("game/inventory/equipment/ring_icon.png"),
                new Location(0.52, 0.27),0.1, Utility.adjustedHeightScale(0.1,0.1));


        statsFont = new Font(FontType.AK_SANS,3f);

    }

    public Image getFirstHandImage() {
        return firstHandImage;
    }

    public Image getSecondHandImage() {
        return secondHandImage;
    }

    public Image getArmorImage() {
        return armorImage;
    }

    public Image getHelmetImage() {
        return helmetImage;
    }

    public Image getNecklaceImage() {
        return necklaceImage;
    }

    public Image getFirstRingImage() {
        return firstRingImage;
    }

    public Image getSecondRingImage() {
        return secondRingImage;
    }


    public void drawBackgroundOnly(SpriteBatch batch){

        firstHandImage.draw(batch);
        secondHandImage.draw(batch);
        armorImage.draw(batch);
        helmetImage.draw(batch);
        necklaceImage.draw(batch);
        firstRingImage.draw(batch);
        secondRingImage.draw(batch);

        statsFont.writeText(batch,"Damage: "+ stats.getDamage(), new Location(0.05,0.1));
        statsFont.writeText(batch,"Speed: "+stats.getSpeed(), new Location(0.25,0.1));
        statsFont.writeText(batch,"Defense: "+stats.getDefense(), new Location(0.45,0.1));

        healthBar.draw(batch,stats.getHealth(),stats.getMaxHealth());

    }

    public void createItemImages(){

        double decreaseFactor = 0.02;

        double widthDec = decreaseFactor;
        double heightDec = Utility.adjustedHeightScale(widthDec,widthDec);

        inventory.getFirstHand().createImage(firstHandImage.getLocation(),
                firstHandImage.getWidth()-widthDec,firstHandImage.getHeight()-heightDec);
        inventory.getSecondHand().createImage(secondHandImage.getLocation(),
                secondHandImage.getWidth()-widthDec,secondHandImage.getHeight()-heightDec);
        inventory.getArmor().createImage(armorImage.getLocation(),
                armorImage.getWidth()-widthDec,armorImage.getHeight()-heightDec);
        inventory.getHelmet().createImage(helmetImage.getLocation(),
                helmetImage.getWidth()-widthDec,helmetImage.getHeight()-heightDec);
        inventory.getNecklace().createImage(necklaceImage.getLocation(),
                necklaceImage.getWidth()-widthDec,necklaceImage.getHeight()-heightDec);
        inventory.getFirstRing().createImage(firstRingImage.getLocation(),
                firstRingImage.getWidth()-widthDec,firstRingImage.getHeight()-heightDec);
        inventory.getSecondRing().createImage(secondRingImage.getLocation(),
                secondRingImage.getWidth()-widthDec,secondRingImage.getHeight()-heightDec);

    }

    public void draw(SpriteBatch batch){

        drawBackgroundOnly(batch);

        createItemImages();

        inventory.getFirstHand().getImage().draw(batch);
        inventory.getSecondHand().getImage().draw(batch);
        inventory.getArmor().getImage().draw(batch);
        inventory.getHelmet().getImage().draw(batch);
        inventory.getNecklace().getImage().draw(batch);
        inventory.getFirstRing().getImage().draw(batch);
        inventory.getSecondRing().getImage().draw(batch);

    }

}
