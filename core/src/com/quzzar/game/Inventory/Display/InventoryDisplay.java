package com.quzzar.game.Inventory.Display;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Input;
import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Objects.Image;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Objects.Player;
import com.quzzar.game.Utility;

import java.util.ArrayList;

public class InventoryDisplay {

    ArrayList<Image> itemImages;

    public InventoryDisplay(){

        itemImages = new ArrayList<Image>();

        int columns = 9;
        int rows = 4;

        int itemCount = 0;

        for(int i = 1; i<=columns; i++){
            for(int j = 1; j<=rows; j++){

                double xScale = (1.0/columns);
                double yScale = (1.0/rows);

                if(itemCount<Player.getInventory().getContents().size()){
                    Item item = Player.getInventory().getContents().get(itemCount);
                    itemImages.add(new Image(item.getTexture(),
                            new Location(xScale*i,yScale*j),
                            xScale*0.3,Utility.adjustedHeightScale(xScale*0.3,yScale*0.3)));
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

    public void draw(SpriteBatch batch, Color pressedTint){

        for(Image image : itemImages){

            //Utility.print("TEST",">"+image.getLocation().getX()+" "+image.getLocation().getY()+" "+image.getWidth()+" "+image.getHeight());

            if(image.containsLocation(Input.getTouchedLocation())){

                // To allow moving of the item in the inventory class
                Player.getInventory().setPressedItem(Utility.getItemFromImage(image));

                // To make the pressed items tint another shade
                batch.setColor(pressedTint);
                image.draw(batch);
                batch.setColor(Color.WHITE);
            } else {
                // Else just draw normally
                image.draw(batch);
            }

        }

    }

}
