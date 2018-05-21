package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Quest;

public class Book extends Quest {
    public Book(String displayName, String questTitle, String ownerName) {
        super(ItemType.BOOK, displayName, questTitle, ownerName);
    }

    @Override
    public ItemGroup getItemGroup() {
        return super.getItemGroup();
    }

    @Override
    public String getQuestTitle() {
        return super.getQuestTitle();
    }

    @Override
    public String getOwnerName() {
        return super.getOwnerName();
    }
}
