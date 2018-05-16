package com.quzzar.game.Inventory.Items.Groups;

import com.quzzar.game.Inventory.Item;
import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;

public class Quest extends Item {

    private String questTitle;
    private String ownerName;

    public Quest(ItemType itemType, int amount, String displayName, String questTitle, String ownerName) {
        super(itemType, amount, displayName);

        this.questTitle = questTitle;
        this.ownerName = ownerName;
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.QUEST;
    }

    public String getQuestTitle() {
        return questTitle;
    }

    public String getOwnerName() {
        return ownerName;
    }

}
