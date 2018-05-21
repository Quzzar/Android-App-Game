package com.quzzar.game.Items.Items.Groups;

import com.quzzar.game.Items.Item;
import com.quzzar.game.Items.ItemGroup;
import com.quzzar.game.Items.ItemType;

public class Quest extends Item {

    private String questTitle;
    private String ownerName;

    public Quest(ItemType itemType, String displayName, String questTitle, String ownerName) {
        super(itemType, displayName);

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
