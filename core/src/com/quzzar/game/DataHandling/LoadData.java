package com.quzzar.game.DataHandling;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.quzzar.game.Player.Inventory;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Player.Stats;
import com.quzzar.game.Utility;

public class LoadData {

    public static void load(){

        FileHandle invFile = Gdx.files.local(DataUtility.getInventoryDataFile());
        Inventory playerInventory = null;
        try{
            playerInventory = (Inventory) DataUtility.deserialize(invFile.readBytes());
            Utility.print("GAME-DATA-Inv","LOADED!");
        } catch (Exception e){
            e.printStackTrace();
            Utility.print("GAME-ERROR","LoadData: Failed to deserialize player inventory!");
        }

        FileHandle statsFile = Gdx.files.local(DataUtility.getStatsDataFile());
        Stats playerStats = null;
        try{
            playerStats = (Stats) DataUtility.deserialize(statsFile.readBytes());
            Utility.print("GAME-DATA-Stats","LOADED!");
        } catch (Exception e){
            e.printStackTrace();
            Utility.print("GAME-ERROR","LoadData: Failed to deserialize player stats!");
        }

        if(playerInventory!=null && playerStats!=null){
            Player.load(playerInventory, playerStats);
        } else {
            Player.create();
        }

    }

}
