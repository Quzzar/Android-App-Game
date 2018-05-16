package com.quzzar.game.Inventory.Display;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Inventory;
import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.Items.Groups.Armor;
import com.quzzar.game.Inventory.Items.Groups.Weapon;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Objects.Player;
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

    public EquipmentDisplay(){

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

    }

    public void createItemImages(){

        inventory.getFirstHand().createImage(firstHandImage.getLocation(),firstHandImage.getWidth(),firstHandImage.getHeight());
        inventory.getSecondHand().createImage(secondHandImage.getLocation(),secondHandImage.getWidth(),secondHandImage.getHeight());
        inventory.getArmor().createImage(armorImage.getLocation(),armorImage.getWidth(),armorImage.getHeight());
        inventory.getHelmet().createImage(helmetImage.getLocation(),helmetImage.getWidth(),helmetImage.getHeight());
        inventory.getNecklace().createImage(necklaceImage.getLocation(),necklaceImage.getWidth(),necklaceImage.getHeight());
        inventory.getFirstRing().createImage(firstRingImage.getLocation(),firstRingImage.getWidth(),firstRingImage.getHeight());
        inventory.getSecondRing().createImage(secondRingImage.getLocation(),secondRingImage.getWidth(),secondRingImage.getHeight());

    }

    public void draw(SpriteBatch batch){

        firstHandImage.draw(batch);
        secondHandImage.draw(batch);
        armorImage.draw(batch);
        helmetImage.draw(batch);
        necklaceImage.draw(batch);
        firstRingImage.draw(batch);
        secondRingImage.draw(batch);

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
