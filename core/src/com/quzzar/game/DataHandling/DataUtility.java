package com.quzzar.game.DataHandling;

import com.badlogic.gdx.Gdx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataUtility {

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }

    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(data);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }


    public static boolean hasSave(){
        return Gdx.files.local(getInventoryDataFile()).exists();
    }

    public static void deleteAllFiles(){
        Gdx.files.local(getInventoryDataFile()).delete();
        Gdx.files.local(getStatsDataFile()).delete();
    }

    public static String getInventoryDataFile(){
        return "playerInv.dat";
    }
    public static String getStatsDataFile(){
        return "playerStats.dat";
    }

}
