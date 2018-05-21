package com.quzzar.game.Items.Items;

public class Book extends com.quzzar.game.Items.Items.Groups.Quest {
    public Book(String displayName, String questTitle, String ownerName) {
        super(com.quzzar.game.Items.ItemType.BOOK, displayName, questTitle, ownerName);
    }

    @Override
    public com.quzzar.game.Items.ItemGroup getItemGroup() {
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
