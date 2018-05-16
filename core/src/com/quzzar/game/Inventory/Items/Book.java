package com.quzzar.game.Inventory.Items;

import com.quzzar.game.Inventory.ItemGroup;
import com.quzzar.game.Inventory.ItemType;
import com.quzzar.game.Inventory.Items.Groups.Quest;

public class Book extends Quest {
    public Book(int amount, String questTitle, String ownerName) {
        super(ItemType.BOOK, amount, "Book", questTitle, ownerName);
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
