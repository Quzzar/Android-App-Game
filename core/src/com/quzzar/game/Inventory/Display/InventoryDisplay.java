package com.quzzar.game.Inventory.Display;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Objects.Player;
import com.quzzar.game.Utility;

import java.util.ArrayList;
import java.util.Collections;

public class InventoryDisplay {

    private ArrayList<Image> itemImages;

    private Image selectedImage;

    private SideMenu sideMenu;

    public InventoryDisplay(){

        itemImages = new ArrayList<Image>();

        int itemCount = 0;

        double size = 0.07;

        // To account for SideMenu
        double xShift = 0.67;

        double xVal = size;
        double yVal = Utility.adjustedHeightScale(size,size);


        sideMenu = new SideMenu(new Texture("game/inventory/equip_panel.png"));

        for(double yScale = 1-yVal; yScale>=yVal; yScale-=yVal){
            for(double xScale = xShift+xVal; xScale<=1; xScale+=xVal){
                if(itemCount<Player.getInventory().getContents().size()){
                    Item item = Player.getInventory().getContents().get(itemCount);
                    itemImages.add(new Image(item.getTexture(),
                            new Location(xScale,yScale), xVal, yVal));
                }
                itemCount++;
            }
        }

        /*
        for(Item item : Player.getInventory().getContents()){
            itemImages.add(new Image(item.getTexture()));
        }
        */
    }

    public void checkImagesPressed(){
        for(Image image : itemImages){
            if(image.containsLocation(Input.getTouchedLocation())){
                if(selectedImage!=null && selectedImage.equals(image)){
                    // If you press the selectedImage, deselect the image.
                    selectedImage = null;
                }else if (selectedImage!=null){
                    // If you press a different image, swap the two images
                    swapImages(selectedImage,image);
                    selectedImage = null;
                } else {
                    // If the selectedImage is null, select a new image.
                    selectedImage = image;
                }
                return;
            }
        }
    }

    public void draw(SpriteBatch batch, Color pressedTint){

        sideMenu.draw(batch);

        for(Image image : itemImages){
            if(image.equals(selectedImage)){
                // To make the pressed image tint a different shade
                batch.setColor(pressedTint);
                image.draw(batch);
                batch.setColor(Color.WHITE);
            } else {
                // Else just draw normally
                image.draw(batch);
            }
        }

    }

    private void swapImages(Image selectedImage, Image newImage){
        Location selLoc = selectedImage.getLocation();
        Location newLoc = newImage.getLocation();

        selectedImage.setLocation(newLoc);
        newImage.setLocation(selLoc);
    }

}
