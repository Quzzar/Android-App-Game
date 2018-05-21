package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemType;

public class Nothing {

    public static Item create(){
        return new Item(ItemType.NOTHING, "");
    }

}
