package com.quzzar.game.Inventory.Display;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Input;
import com.quzzar.game.Player.Inventory;
import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.Items.Nothing;
import com.quzzar.game.Objects.Location;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Utility;

public class InventoryDisplay {

    private Item selectedItem = Nothing.create();

    private SideMenu sideMenu;

    private EquipmentDisplay equipmentDisplay;

    private Inventory inventory = Player.getInventory();

    public InventoryDisplay(){

        sideMenu = new SideMenu(new Texture("misc/stone_1.jpg"));

        equipmentDisplay = new EquipmentDisplay();

        createItemImages();

    }

    private void createItemImages(){

        // Equipment Items...
        equipmentDisplay.createItemImages();

        // The rest of the inventory contents...
        int itemCount = 0;

        double size = 0.07;

        // To account for SideMenu
        double xShift = 0.677;

        double xVal = size;
        double yVal = Utility.adjustedHeightScale(size,size);

        for(double yScale = 1-yVal; yScale>=yVal; yScale-=yVal){
            for(double xScale = xShift+xVal; xScale<=1; xScale+=xVal){
                if(itemCount < inventory.getContents().size()){
                    Item item = inventory.getContents().get(itemCount);
                    item.createImage(new Location(xScale,yScale), xVal, yVal);
                }else{
                    return;
                }
                itemCount++;
            }
        }

    }

    public void handleImagesPressed(){
        // If an item image is selected and they're pressing an equipment slot
        if(!selectedItem.isNothing()){
            Inventory inventory = Player.getInventory();

            if(equipmentDisplay.getFirstHandImage().containsLocation(Input.getTouchedLocation())){
                if(selectedItem.getItemGroup().equals(ItemGroup.WEAPON)){
                    // Swap the item in the firstHand slot with selected item
                    swapItems(selectedItem,inventory.getFirstHand());
                }
                selectedItem = Nothing.create();
                return;
            }
            if(equipmentDisplay.getSecondHandImage().containsLocation(Input.getTouchedLocation())){
                if(selectedItem.getItemGroup().equals(ItemGroup.WEAPON)){
                    // Swap the item in the secondHand slot with selected item
                    swapItems(selectedItem,inventory.getSecondHand());
                }
                selectedItem = Nothing.create();
                return;
            }
            if(equipmentDisplay.getArmorImage().containsLocation(Input.getTouchedLocation())){
                if(selectedItem.getItemGroup().equals(ItemGroup.ARMOR)){
                    // Swap the item in the armor slot with selected item
                    swapItems(selectedItem,inventory.getArmor());
                }
                selectedItem = Nothing.create();
                return;
            }
            if(equipmentDisplay.getHelmetImage().containsLocation(Input.getTouchedLocation())){
                if(selectedItem.getItemGroup().equals(ItemGroup.HELMET)){
                    // Swap the item in the secondHand slot with selected item
                    swapItems(selectedItem,inventory.getHelmet());
                }
                selectedItem = Nothing.create();
                return;
            }
            if(equipmentDisplay.getNecklaceImage().containsLocation(Input.getTouchedLocation())){
                if(selectedItem.getItemGroup().equals(ItemGroup.NECKLACE)){
                    // Swap the item in the secondHand slot with selected item
                    swapItems(selectedItem,inventory.getNecklace());
                }
                selectedItem = Nothing.create();
                return;
            }
            if(equipmentDisplay.getFirstRingImage().containsLocation(Input.getTouchedLocation())){
                if(selectedItem.getItemGroup().equals(ItemGroup.RING)){
                    // Swap the item in the secondHand slot with selected item
                    swapItems(selectedItem,inventory.getFirstRing());
                }
                selectedItem = Nothing.create();
                return;
            }
            if(equipmentDisplay.getSecondRingImage().containsLocation(Input.getTouchedLocation())){
                if(selectedItem.getItemGroup().equals(ItemGroup.RING)){
                    // Swap the item in the secondHand slot with selected item
                    swapItems(selectedItem,inventory.getSecondRing());
                }
                selectedItem = Nothing.create();
                return;
            }
        }

        // Handle selecting images, swapping, deselecting, etc
        for(Item item : inventory.getFullContents()){
            if(item.getImage().containsLocation(Input.getTouchedLocation())){
                if(!selectedItem.isNothing() && selectedItem.equals(item)){
                    // If you press the selectedImage, deselect the image.
                    selectedItem = Nothing.create();
                }else if (!selectedItem.isNothing()){
                    // If you press a different image, swap the two images
                    swapItems(selectedItem,item);
                    selectedItem = Nothing.create();
                } else {
                    // If the selectedImage is null, select a new image.
                    selectedItem = item;
                }
                return;
            }
        }
    }

    public void draw(SpriteBatch batch, Color pressedTint){

        sideMenu.draw(batch);
        equipmentDisplay.drawBackgroundOnly(batch);

        createItemImages();

        for(Item item : inventory.getFullContents()){
            if(item.equals(selectedItem)){
                // To make the pressed image tint a different shade
                batch.setColor(pressedTint);
                item.getImage().draw(batch);
                batch.setColor(Color.WHITE);
            } else {
                // Else just draw normally
                item.getImage().draw(batch);
            }
        }

    }

    private void swapItems(Item selectedItem, Item newItem){
        // If either are equipped, only swap if they're of the same ItemGroup or either are Nothing
        if(inventory.isEquipped(selectedItem)||inventory.isEquipped(newItem)){
            if(!selectedItem.isNothing() && !newItem.isNothing() && !selectedItem.getItemGroup().equals(newItem.getItemGroup())){
                return;
            }
        }

        int selItemIndex = inventory.getFullContents().indexOf(selectedItem);
        int newItemIndex = inventory.getFullContents().indexOf(newItem);

        inventory.getFullContents().set(selItemIndex,newItem);
        inventory.getFullContents().set(newItemIndex,selectedItem);

    }

}
