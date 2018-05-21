package com.quzzar.game.DataHandling;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.quzzar.game.Player.Player;
import com.quzzar.game.Utility;

public class SaveData {

    public static void save(){

        if(Player.getInventory()!=null){
            FileHandle file = Gdx.files.local(DataUtility.getInventoryDataFile());
            try {
                file.writeBytes(DataUtility.serialize(Player.getInventory()), false);
                Utility.print("GAME-DATA-Inv","SAVED!");
            } catch (Exception e) {
                e.printStackTrace();
                Utility.print("GAME-ERROR","SaveData: Failed to serialize player inventory!");
            }
        }

        if(Player.getStats()!=null){
            FileHandle file = Gdx.files.local(DataUtility.getStatsDataFile());
            try {
                file.writeBytes(DataUtility.serialize(Player.getStats()), false);
                Utility.print("GAME-DATA-Stats","SAVED!");
            } catch (Exception e) {
                e.printStackTrace();
                Utility.print("GAME-ERROR","SaveData: Failed to serialize player stats!");
            }
        }

    }


}
